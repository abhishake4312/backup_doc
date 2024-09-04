/**
 * 
 */
package com.boeing.ps.innovationvenue.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

import com.boeing.ps.innovationvenue.bean.EmailMessage;
import com.boeing.ps.innovationvenue.entity.IdeaAssignee;
import com.boeing.ps.innovationvenue.repository.IdeaAssigneeRepository;
import com.boeing.ps.innovationvenue.service.EmailNotificationService;
import freemarker.template.TemplateException;
import org.hibernate.exception.DataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.boeing.ps.innovationvenue.common.exception.ApplicationException;
import com.boeing.ps.innovationvenue.entity.Idea;
import com.boeing.ps.innovationvenue.entity.IdeaCommentEntity;
import com.boeing.ps.innovationvenue.entity.UserProfile;
import com.boeing.ps.innovationvenue.repository.CommentRepository;
import com.boeing.ps.innovationvenue.repository.IdeaRepository;
import com.boeing.ps.innovationvenue.repository.UserProfileRepository;
import com.boeing.ps.innovationvenue.service.CommentService;
import com.boeing.ps.innovationvenue.valueobjects.CommentVO;

import javax.mail.MessagingException;

/**
 * @author hs645e
 *
 */
@Service
public class CommentServiceImpl implements CommentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommentServiceImpl.class.getName());
	private static final String ADMIN_ROLE = "ADMIN";
	private static final String SME_ROLE = "SME";
	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	UserProfileRepository userProfileRepo;
	@Autowired
	IdeaRepository ideaRepository;

	@Autowired
	IdeaAssigneeRepository ideaAssigneeRepository;

	@Autowired
	private EmailNotificationService emailNotificationService;

	@Autowired
	private Environment env;

	@Override
	public CommentVO saveComment(CommentVO commentVO) throws ApplicationException {
		try {
			IdeaCommentEntity entity = new IdeaCommentEntity();
			BeanUtils.copyProperties(commentVO, entity);
			Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
			entity.setCreatedDate(calendar.getTime());
			int ideaID = Integer.valueOf(commentVO.getContentID().toString()).intValue();
			Idea innovationIdeaPresent = ideaRepository.findByIdeaId(ideaID);


			if (null != innovationIdeaPresent) {
				entity.setIdea(innovationIdeaPresent);

				UserProfile commentedUser = userProfileRepo
						.findByBemsId(Long.parseLong(commentVO.getCommentingUser().toString()));
				if (commentedUser == null) {
					commentedUser = new UserProfile();
				}
				commentedUser.setBemsId(Long.parseLong(commentVO.getCommentingUser().toString()));
				userProfileRepo.save(commentedUser);
				entity.setUsers(commentedUser);
				IdeaCommentEntity savedEntity = commentRepository.save(entity);
				commentVO.setCommentID(savedEntity.getCommentID());
				commentVO.setCreatedDate(savedEntity.getCreatedDate());
				constructNotificationEmailTemplate(commentedUser,innovationIdeaPresent,commentVO);// Added for sending email Notification
				commentVO.setUser(commentedUser);
				return commentVO;

			} else {
				throw new ApplicationException("Innovation Idea is not available or present");
			}
		} catch (DataException | IllegalArgumentException ex) {
			LOGGER.error("Save operation failed in the DAO layer", ex);
			throw new ApplicationException("Save operation failed in the DAO layer");
		}

	}

	@Override
	public List<CommentVO> getIdeaComments(long bemsId, BigDecimal mainContentId) throws ApplicationException {
		try {

			List<CommentVO> commentvos = new ArrayList<>();

			Idea idea = new Idea();
			int ideaID = Integer.valueOf(mainContentId.toString()).intValue();
			Idea ideaEntity = ideaRepository.findByIdeaId(ideaID);
			IdeaAssignee assignee = ideaAssigneeRepository.findByIdea(ideaEntity);
			long assigneeID = 0;
			if(assignee!=null)
				assigneeID = assignee.getAssigneeId();
            if(ideaEntity!=null && (bemsId == ideaEntity.getUser().getBemsId() || bemsId == assigneeID)) {
				LOGGER.info("inside method");
            	idea.setIdeaId(ideaID);
				ArrayList<IdeaCommentEntity> comments = (ArrayList<IdeaCommentEntity>) commentRepository.findByIdea(idea);
				if (!CollectionUtils.isEmpty(comments)) {
					LOGGER.info("Comments present");
					comments.stream().forEach(eachComments -> {
						commentvos.add(convertCommentEntityToVO(eachComments));
					});

				}
			}


			return commentvos;
		} catch (DataException | IllegalArgumentException ex) {
			LOGGER.error("getIdeaComments operation failed in the DAO layer", ex);
			throw new ApplicationException("getIdeaComments operation failed in the DAO layer");
		}
	}

	@Override
	public CommentVO getComments(BigDecimal commentID) throws ApplicationException {
		try {

			Optional<IdeaCommentEntity> opCommentEntity = commentRepository.findById(commentID);

			if (opCommentEntity.isPresent()) {

				IdeaCommentEntity commentEntity = opCommentEntity.get();
				return convertCommentEntityToVO(commentEntity);

			}

		} catch (DataException | IllegalArgumentException ex) {
			LOGGER.error("getComments operation failed in the DAO layer", ex);
			throw new ApplicationException("getComments operation failed in the DAO layer");
		}
		return null;
	}

	@Override
	public void deleteComment(List<CommentVO> comments) throws ApplicationException {
		try {
			List<IdeaCommentEntity> opCommentEntity = new ArrayList<>();
			if (!CollectionUtils.isEmpty(comments)) {
				comments.stream().forEach(eachComments -> {
					IdeaCommentEntity commentEntity = new IdeaCommentEntity();
					BeanUtils.copyProperties(eachComments, commentEntity);

					opCommentEntity.add(commentEntity);
				});

			}

			commentRepository.deleteAll(opCommentEntity);
		} catch (DataException | IllegalArgumentException ex) {
			LOGGER.error("deleteComment operation failed in the DAO layer", ex);
			throw new ApplicationException("deleteComment operation failed in the DAO layer");
		}
	}

	private CommentVO convertCommentEntityToVO(IdeaCommentEntity commentEntity) {
		CommentVO commentvo = new CommentVO();
		BeanUtils.copyProperties(commentEntity, commentvo);
		if (null != commentEntity.getUsers()) {
			commentvo.setCommentingUser(BigDecimal.valueOf(commentEntity.getUsers().getBemsId()));
		}
		if (null != commentEntity.getIdea()) {
			commentvo.setContentID(BigDecimal.valueOf(commentEntity.getIdea().getIdeaId()));
		}
		commentvo.setCreatedDate(commentEntity.getCreatedDate());
		commentvo.setUser(commentEntity.getUsers());
		return commentvo;
	}
	/** To Send Email Notification for New Comments on Idea
	  *
	  * @param userProfile - User Profile Details
	  * @param idea -Idea details
	  */
	private void constructNotificationEmailTemplate(UserProfile userProfile, Idea idea,CommentVO commentVO ) {
		Map<String,Object> modelMap = new HashMap<>();
		SaveSubmitIdeaServiceImpl saveSubmitIdeaService= new SaveSubmitIdeaServiceImpl();
		boolean isIdeaMapped = false;
		
		try {
			IdeaAssignee ideaAssignee = ideaAssigneeRepository.findByIdea(idea);
			if(ideaAssignee != null) {
				if ("A".equalsIgnoreCase(ideaAssignee.getStatusFlag())) {
					isIdeaMapped = true;
				}
			}
			
			modelMap.put("ideaId", saveSubmitIdeaService.ideaFormat(idea.getIdeaId()));
			modelMap.put("commentMessage", commentVO.getDescription() );
			modelMap.put("ideaTitle",idea.getIdeaTitle());
			LOGGER.info("meas---"+commentVO.getDescription());
			
			if (ADMIN_ROLE.equalsIgnoreCase(userProfile.getUserRoles().getRoleDesc())) {
				constructInventorTemplate(modelMap, idea);
				if(isIdeaMapped)
					constructSMETemplate(modelMap, idea, ideaAssignee, userProfile);
			}
			else if(SME_ROLE.equalsIgnoreCase(userProfile.getUserRoles().getRoleDesc())) {
				constructAdminTemplate(modelMap, idea, userProfile);
				if(userProfile.getBemsId() == idea.getUser().getBemsId())
					constructSMETemplate(modelMap, idea, ideaAssignee, userProfile);
				else
					constructInventorTemplate(modelMap, idea);	
			}
			else {
				constructAdminTemplate(modelMap, idea, userProfile);
				if(isIdeaMapped)
					constructSMETemplate(modelMap, idea, ideaAssignee, userProfile);
			}

		} catch ( Exception e) {
			LOGGER.info("Exception occured during constructing email templates");
			e.printStackTrace();
		}
	}
	
	private void constructAdminTemplate(Map<String, Object> modelMap, Idea idea, UserProfile userProfile) {
		List<String> toAddressList = new ArrayList<String>();
		SaveSubmitIdeaServiceImpl saveSubmitIdeaService= new SaveSubmitIdeaServiceImpl();
		String appURL = env.getProperty("ps.innovationcorner.appURL");
		
		try {
			LOGGER.info("Prepring email template for ADMIN "+ idea.getIdeaId());
			modelMap.put("ideaAppURL", appURL + "/admin");
			modelMap.put("name",userProfile.getUserName());
			modelMap.put("footerMessage", "We sent you this notification because you are part of Admin Team.");
	
			EmailMessage emailMessage = new EmailMessage();
			emailMessage.setFromAddress(env.getProperty("ps.innovationcorner.email.fromaddress"));
			emailMessage.setSubject(userProfile.getUserName() +" commented on the Idea "+saveSubmitIdeaService.ideaFormat(idea.getIdeaId()));
			toAddressList.add(env.getProperty("ps.innovationcorner.email.admin.toaddress"));
			emailMessage.setToAddress(toAddressList);
			emailNotificationService.sendCommentEmailNotification(emailMessage, modelMap);
		} catch (MessagingException |IOException |TemplateException e) {
			LOGGER.info("Exception occured during constructing email templates for Admin");
            e.printStackTrace();
        } catch ( Exception e) {
        	LOGGER.info("Exception occured during constructing email templates for Admin");
            e.printStackTrace();
        }
	}
	
	private void constructSMETemplate(Map<String, Object> modelMap, Idea idea, IdeaAssignee ideaAssignee, UserProfile userProfile) {
		List<String> toAddressList = new ArrayList<String>();
		SaveSubmitIdeaServiceImpl saveSubmitIdeaService= new SaveSubmitIdeaServiceImpl();
		String appURL = env.getProperty("ps.innovationcorner.appURL");
		
		try {
			LOGGER.info("Prepring email template for SME "+ idea.getIdeaId());
			
			modelMap.put("name",userProfile.getUserName());
			modelMap.put("footerMessage", "We sent you this notification because you are part of Review Team.");
			modelMap.put("ideaAppURL", appURL + "/myIdeas");
			
			EmailMessage emailMessage = new EmailMessage();
			emailMessage.setFromAddress(env.getProperty("ps.innovationcorner.email.fromaddress"));
			emailMessage.setSubject(userProfile.getUserName() +" commented on the Idea "+saveSubmitIdeaService.ideaFormat(idea.getIdeaId()) );
			toAddressList.add(userProfileRepo.findByBemsId(ideaAssignee.getAssigneeId()).getEmailAddress());
			emailMessage.setToAddress(toAddressList);
			emailNotificationService.sendCommentEmailNotification(emailMessage, modelMap);
			
		} catch (MessagingException |IOException |TemplateException e) {
			LOGGER.info("Exception occured during constructing email templates for SME");
            e.printStackTrace();
        } catch ( Exception e) {
        	LOGGER.info("Exception occured during constructing email templates for SME");
            e.printStackTrace();
        }
	}
	
	private void constructInventorTemplate(Map<String, Object> modelMap, Idea idea) {
		List<String> toAddressList = new ArrayList<String>();
		SaveSubmitIdeaServiceImpl saveSubmitIdeaService= new SaveSubmitIdeaServiceImpl();
		String appURL = env.getProperty("ps.innovationcorner.appURL");
		
		try {
			LOGGER.info("Prepring email template for Inventor " + idea.getIdeaId());
			
			modelMap.put("ideaAppURL", appURL + "/myIdeas");
			modelMap.put("name","Review Team");
			modelMap.put("footerMessage", "We sent you this notification to keep you informed about the recent activity on your idea.");

			EmailMessage emailMessage = new EmailMessage();
			emailMessage.setFromAddress(env.getProperty("ps.innovationcorner.email.fromaddress"));
			emailMessage.setSubject("Reviewer has commented on the Idea "+saveSubmitIdeaService.ideaFormat(idea.getIdeaId()));
			toAddressList.add(idea.getUser().getEmailAddress());
			emailMessage.setToAddress(toAddressList);
			emailNotificationService.sendCommentEmailNotification(emailMessage, modelMap);
			
		} catch (MessagingException |IOException |TemplateException e) {
			LOGGER.info("Exception occured during constructing email templates for Inventor");
            e.printStackTrace();
        } catch ( Exception e) {
        	LOGGER.info("Exception occured during constructing email templates for Inventor");
            e.printStackTrace();
        }
	}
}
