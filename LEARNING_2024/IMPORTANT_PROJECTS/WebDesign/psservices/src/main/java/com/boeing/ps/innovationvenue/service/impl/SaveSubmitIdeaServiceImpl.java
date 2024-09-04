package com.boeing.ps.innovationvenue.service.impl;


import com.boeing.ps.innovationvenue.bean.EmailMessage;

import com.boeing.ps.innovationvenue.entity.Idea;
import com.boeing.ps.innovationvenue.entity.UserProfile;
import com.boeing.ps.innovationvenue.repository.IdeaRepository;
import com.boeing.ps.innovationvenue.repository.UserProfileRepository;

import com.boeing.ps.innovationvenue.service.SaveSubmitIdeaService;
import com.boeing.ps.innovationvenue.valueobjects.*;

import com.boeing.ps.innovationvenue.service.EmailNotificationService;

import freemarker.template.TemplateException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.*;


@Service
public class SaveSubmitIdeaServiceImpl extends SaveSubmitIdeaService {

    private static final Logger logger = LoggerFactory.getLogger(SaveSubmitIdeaServiceImpl.class);

    private static final String SAVED = "Saved";
    private static final String SUBMITTED = "Submitted"; 
    private static final String PENDING_REVIEW = "Pending Review"; 
    private static final String AWAITING_REPLY = "Awaiting Reply";
    private static final String CLOSED = "Closed"; 
    private static final String EMAIL_SUBJECT = "SUBJECT"; 
    private static final String EMAIL_TITLE = "MESSAGETITLE";
    private static final String SUCCESS_STATUS = "SUCCESS";
    private static final String FAILURE_STATUS = "FAILURE";
    private static final String ADMIN_ROLE = "ADMIN";
    
    String msgTitleAdmin =  "<tr>\r\n" + 
							"		<td class=\"title\" style=\"padding: 0 0 24px 0; color: #212121; font-size: 28px; font-weight: bold; letter-spacing: -0.04em; line-height: 40px; word-break: break-word;display:block\">\r\n" + 
							"			<MessageTitle>\r\n" + 
							"		</td>\r\n" + 
							"	</tr>\r\n" ;
    
    String msgTitleGuest =   "<tr>\r\n" + 
							"		<td class=\"title\" style=\"padding: 0 0 24px 0; color: #212121; font-size: 28px; font-weight: bold; letter-spacing: -0.04em; line-height: 40px; word-break: break-word;display:block\">\r\n" + 
							"			  <MessageTitle>\r\n" + 
							"		</td>\r\n" + 
							"	</tr>";

    
    @Autowired
    UserProfileRepository userProfileRepo;

    @Autowired
    IdeaRepository ideaRepository;

    @Autowired
    private EmailNotificationService emailNotificationService;
    
    @Autowired
    private Environment env;


    public IdeaResponse saveSubmitIdea(IdeaRequest ideaRequest) {

        Idea ideaEntity = null;
        IdeaResponse ideaResponse = null;
        
        boolean isUserExists = userProfileRepo.existsById(ideaRequest.getBemsId());
        logger.info("User Profile exist " + isUserExists);
        //This piece of code is used when user is saving or directly submitting the data for first time.
        if (ideaRequest.getIdeaId() == 0 ) {
            if (isUserExists) {
                if(ideaRequest.getIdeaStatus()==1 || ideaRequest.getIdeaStatus()==2) {
                    UserProfile userProfile = userProfileRepo.findByBemsId(ideaRequest.getBemsId());
                    logger.info("User Profile " + userProfile);
                    ideaEntity = new Idea(ideaRequest.getIdeaTitle(), ideaRequest.getIdeaBody(),
                            ideaRequest.getIdeaStatus(), new Date(),userProfile);
                    if (ideaRequest.getIdeaStatus() == 2) {
                        ideaEntity.setSubmittedDate(new Date());
                    }

                    Idea ideaSavedEntity = ideaRepository.save(ideaEntity);
                    //                   logger.info("Idea id--->" + ideaList.size());
                    int ideaId = ideaSavedEntity.getIdeaId();
                    logger.info("Idea id--->" + ideaId);
                    ideaResponse = new IdeaResponse(ideaId, "Idea Saved Successfully");

                    if (ideaRequest.getIdeaStatus() == 2) {
                        sendEmail(userProfile, ideaSavedEntity);

                        ideaResponse = new IdeaResponse(ideaId, "Idea Submitted Successfully");
                    }
                }
                else{
                    ideaResponse = new IdeaResponse(0, "Failed Request!! Please check the status, new idea can only be saved and submitted");
                }

            }
            else{
                ideaResponse = new IdeaResponse(0, "Failed Request!! user doesn't exist to save or submit ");
            }

        }

        //This is used for updating the saved record and saving/submitting it again
        else {

            ideaEntity = ideaRepository.findByIdeaId(ideaRequest.getIdeaId());

            UserProfile userProfile = userProfileRepo.findByBemsId(ideaRequest.getBemsId());
//            ideaEntity = new Idea(ideaRequest.getIdeaTitle(), ideaRequest.getIdeaDescription(), ideaRequest.getIdeaBody(),
//                    ideaRequest.getIdeaStatus(), Calendar.getInstance().getTime());
            if (ideaEntity != null) {
                if(ideaRequest.getBemsId() == ideaEntity.getUser().getBemsId())
                {
                    if ((ideaRequest.getIdeaStatus() == 1 && ideaEntity.getIdeaStatus() == 1) || (ideaRequest.getIdeaStatus() == 2 && ideaEntity.getIdeaStatus() == 1) || (ideaRequest.getIdeaStatus() == 2 && ideaEntity.getIdeaStatus()==4)) {
                        ideaEntity.setIdeaTitle(ideaRequest.getIdeaTitle());
                        ideaEntity.setIdeaBody(ideaRequest.getIdeaBody());

                        ideaEntity.setIdeaStatus(ideaRequest.getIdeaStatus());
                        ideaEntity.setModificationDate(new Date());
                        ideaEntity.setUser(userProfile);
                        if (ideaRequest.getIdeaStatus() == 2 ) {
                            ideaEntity.setSubmittedDate(new Date());
                        }
                        Idea idea = ideaRepository.save(ideaEntity);
                        ideaResponse = new IdeaResponse(ideaRequest.getIdeaId(), "Idea Updated Successfully");

                        if (ideaRequest.getIdeaStatus() == 2 ) {
                            sendEmail(userProfile, idea);

                            ideaResponse = new IdeaResponse(ideaRequest.getIdeaId(), "Idea Submitted Successfully");
                        }
                    } else {
                        ideaResponse = new IdeaResponse(ideaRequest.getIdeaId(), "Failed Request!! please check the idea status");
                    }
                }else{
                    ideaResponse = new IdeaResponse(ideaRequest.getIdeaId(), "Not Authorized to do any operations on this Idea");
                }
            } else {
                ideaResponse = new IdeaResponse(ideaRequest.getIdeaId(), "Please give valid ideaId");
            }
	    }
        return ideaResponse;
    }


    public AllIdeaResponse getAllIdeaDetails(long bemsId) {
        UserProfile userProfile = userProfileRepo.findByBemsId(bemsId);
        AllIdeaResponse allIdeaResponse = null;
        List<Idea> ideaList = null;
        if (userProfile != null) {
            logger.info("User Profile " + userProfile);
            ideaList = ideaRepository.findByUserOrderByModificationDateDesc(userProfile);
            if (!ideaList.isEmpty()) {
                allIdeaResponse = new AllIdeaResponse(ideaList, "All idea user save/submitted");
            } else {
                allIdeaResponse = new AllIdeaResponse(ideaList, "User has not has given any idea");
            }
        } else {
            allIdeaResponse = new AllIdeaResponse(ideaList, "User doesn't exits");
        }
        return allIdeaResponse;
    }

    /** To Send New Idea Submission Email Notification To User & Admin
      *
      * @param userProfile - User Profile Details
      * @param idea -Idea details
      */
    protected void sendEmail(UserProfile userProfile, Idea idea)  {
        Map<String,Object> modelMap = new HashMap<>();
        
        try {
            logger.info("idea id"+idea.getIdeaStatus()+idea.getIdeaId()+idea.getIdeaTitle());
        	String ideaStatus = getStatusDesc(idea.getIdeaStatus());
        	
        	modelMap.put("ideaId", ideaFormat(idea.getIdeaId()));
        	modelMap.put("ideaTitle",idea.getIdeaTitle());
        	modelMap.put("status",ideaStatus);
            if(SUBMITTED.equalsIgnoreCase(ideaStatus)) {
                constructAdminTemplate(userProfile, modelMap, idea);
                constructGuestTemplate(userProfile, modelMap, idea);
                logger.info("inside submitted"+userProfile);
            }
            else if(PENDING_REVIEW.equalsIgnoreCase(ideaStatus) || CLOSED.equalsIgnoreCase(ideaStatus)
                    || AWAITING_REPLY.equalsIgnoreCase(ideaStatus) ) {
                constructGuestTemplate(userProfile, modelMap, idea);
                logger.info("inside status other than 2"+userProfile);
            }
        }

        catch ( Exception e) {
            logger.info("Exception happened in sendEmail"+ e.getMessage());
        }
    }
    /** To Send New Idea Submission Email Notification To Admin
      *
      * @param userProfile - User Profile Details
      * @param modelMap -User Email Template Model
      * @param idea -Idea details
      */
    private void constructAdminTemplate(UserProfile userProfile, Map<String, Object> modelMap, Idea idea) {
    	ArrayList<String> emailAddress = new ArrayList<String>();
        
    	try {
            logger.info("inside constructAdminTemplate-1"+userProfile.getBemsId());
    		Map<String,String> emailFillerMap=  getEmailFillerForAdmin(getStatusDesc(idea.getIdeaStatus()), userProfile.getUserName(), idea.getIdeaId());
    		modelMap.put("messageTitle", msgTitleAdmin.replace("<MessageTitle>", emailFillerMap.get(EMAIL_TITLE)));
    		String appURL = env.getProperty("ps.innovationcorner.appURL");
    		modelMap.put("ideaAppURL", appURL + "/admin");
            modelMap.put("footerMessage", "We sent you this notification because you are part of Admin Team.");
    		
            EmailMessage emailMessage = new EmailMessage();
	    	emailMessage.setFromAddress(env.getProperty("ps.innovationcorner.email.fromaddress"));
	    	emailMessage.setSubject(emailFillerMap.get(EMAIL_SUBJECT));
	        emailAddress.add(userProfile.getEmailAddress());
	        emailMessage.setToAddress(emailAddress);
            logger.info("inside constructAdminTemplate-2"+userProfile.getBemsId());
	        emailNotificationService.sendEmailNotification(emailMessage,modelMap);
            logger.info("inside constructAdminTemplate-3"+userProfile.getBemsId());
    	} catch (MessagingException |IOException |TemplateException e) {
            logger.info("Exception occured during constructing email templates for Admin");
            e.printStackTrace();
        } catch ( Exception e) {
            logger.info("Exception occured during constructing email templates for Admin");
            e.printStackTrace();
        }
    }


    /** To Send New Idea Submission Email Notification To User
     *
     * @param userProfile - User Profile Details
     * @param modelMap -User Email Template Model
     * @param idea -Idea details
     */
    private void constructGuestTemplate(UserProfile userProfile, Map<String, Object> modelMap, Idea idea) {
    	ArrayList<String> emailAddress = new ArrayList<String>();
        
    	try {
            logger.info("inside constructGuestTemplate-1"+userProfile.getBemsId());
    		Map<String,String> emailFillerMap=  getEmailFillerForGuest(getStatusDesc(idea.getIdeaStatus()), idea.getIdeaId());
    		modelMap.put("messageTitle", msgTitleGuest.replace("<MessageTitle>", emailFillerMap.get(EMAIL_TITLE)));
    		String appURL = env.getProperty("ps.innovationcorner.appURL");
    		modelMap.put("ideaAppURL", appURL + "/myIdeas");
    		modelMap.put("footerMessage", "We sent you this notification due to a default subscription");
    		
    		EmailMessage emailMessage = new EmailMessage();
	    	emailMessage.setFromAddress(env.getProperty("ps.innovationcorner.email.fromaddress"));
	    	emailMessage.setSubject(emailFillerMap.get(EMAIL_SUBJECT));
	        emailAddress.add(userProfile.getEmailAddress());
	        emailMessage.setToAddress(emailAddress);
            logger.info("inside constructGuestTemplate-2"+userProfile.getBemsId());
	        emailNotificationService.sendEmailNotification(emailMessage,modelMap);
            logger.info("inside constructGuestTemplate-3"+userProfile.getBemsId());
    	} catch (MessagingException |IOException |TemplateException e) {
            logger.error("Exception occured during constructing email templates for Guest");
            e.printStackTrace();
        } catch ( Exception e) {
            logger.error("Exception occured during constructing email templates for Guest");
            e.printStackTrace();
        }
    }

    public IdeaByIdResponse getIdeaById(long bemsId, int ideaId) {

        IdeaByIdResponse ideaByIdResponse = new IdeaByIdResponse();
        Idea ideaEntity = ideaRepository.findByIdeaId(ideaId);
        logger.info("idea entity is "+ideaEntity);
        if (null != ideaEntity) {
            if (bemsId == ideaEntity.getUser().getBemsId()) {
                ideaByIdResponse.setIdea(ideaEntity);
                ideaByIdResponse.setMessage("Idea retrieved successfully");
            }else{
                ideaByIdResponse.setMessage("No Authorized to delete the idea");
            }
        } else {
            ideaByIdResponse.setMessage("No Idea Found");
        }
        return ideaByIdResponse;


    }

    /** To send User Queries to Core Team
     *
     * @param userQueryReq - user query request like bemsID, Title and Message
     * @return HTTPResponseEntity
     */
    public MailResponse sendFeedback(UserQueryRequest userQueryReq) {
    	logger.info("inside sendFeedback ------------------>");
    	MailResponse mailResponse = new MailResponse();
    	Map<String, Object> model = new HashMap<>();
        ArrayList<String> toAddress = new ArrayList<String>();
    	try {
    		UserProfile userProfile = userProfileRepo.findByBemsId(userQueryReq.getBemsId());
    		if(null != userProfile) {
        		toAddress.add(env.getProperty("ps.innovationcorner.email.admin.toaddress"));
	            /** COPYING USER_QUERY REQUEST TO EMAIL MESSAGE **/
	            EmailMessage emailMessage = new EmailMessage(userQueryReq.getMessageBody(), toAddress, userQueryReq.getSubject(),
                        env.getProperty("ps.innovationcorner.email.fromaddress"), userProfile.getEmailAddress(), userQueryReq.getBemsId());
	            model.put("UserEmail", userProfile.getEmailAddress());
	            model.put("Title", userQueryReq.getSubject());
	            model.put("Message", userQueryReq.getMessageBody());
	            model.put("Name", userProfile.getUserName());
	            model.put("footerMessage", "We sent you this notification due to a default subscription");
	            emailNotificationService.sendUserQuery(emailMessage, model);
	            mailResponse.setMessage("Feedback sent successfully");
	            mailResponse.setStatus(SUCCESS_STATUS);
    		} else {
    			mailResponse.setStatus(FAILURE_STATUS);
        		mailResponse.setMessage("User doesn't exits");
    		}
        } catch (MessagingException | IOException | TemplateException e) {
        	e.printStackTrace();
        	logger.info("Feedback Failed to send ");
            mailResponse.setMessage("Feedback Failed to send");
            mailResponse.setStatus(FAILURE_STATUS);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Feedback Failed to send");
            mailResponse.setMessage("Feedback Failed to send");
            mailResponse.setStatus(FAILURE_STATUS);
        }
        return mailResponse;
    }

    public AllIdeaResponse getAllIdeaDetailsForAdmin(long bemsId, int status) {
        UserProfile userProfile = userProfileRepo.findByBemsId(bemsId);
        AllIdeaResponse allIdeaResponse = null;
        List ideaList = new ArrayList();
        List<Idea> list = null;
        List<Integer> allowedStatus = new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5));
        if (userProfile != null) {
            if (userProfile.getUserRoles().getRoleId() == 1) {
                if (!allowedStatus.contains(status)) {
                    allIdeaResponse = new AllIdeaResponse(null, "Invalid status");
                }
                else {
                    list = ideaRepository.findByIdeaStatusOrderByModificationDateDesc(status);
                    
                    if (!ideaList.isEmpty()) {
                        allIdeaResponse = new AllIdeaResponse(list, "All ideas under category: " + getStatusDesc(status));
                    } else {
                        allIdeaResponse = new AllIdeaResponse(list, "No ideas");
                    }
                }
            }
            else{
                allIdeaResponse = new AllIdeaResponse(null, "Non-Admin user");
            }
        }
        else {
            allIdeaResponse = new AllIdeaResponse(null, "User doesn't exist");
        }
        return allIdeaResponse;
    }

    public DeleteIdeaResponse deleteIdeabyId (long bemsId, int ideaId){

        DeleteIdeaResponse deleteIdeaResponse = new DeleteIdeaResponse();
        Idea ideaEntity = ideaRepository.findByIdeaId(ideaId);


            if (null != ideaEntity) {
                    if (bemsId == ideaEntity.getUser().getBemsId()) {
                        if(ideaEntity.getIdeaStatus()==1) {
                            ideaRepository.deleteById(ideaId);
                            deleteIdeaResponse.setIdea(ideaId);
                            deleteIdeaResponse.setStatus(SUCCESS_STATUS);
                            deleteIdeaResponse.setStatusMessage("Idea has been deleted successfully");
                        }else{
                            deleteIdeaResponse.setStatus(FAILURE_STATUS);
                            deleteIdeaResponse.setStatusMessage("Idea cannot be deleted");
                        }

                    }

                    else{
                        deleteIdeaResponse.setStatus(FAILURE_STATUS);
                        deleteIdeaResponse.setIdea(ideaId);
                        deleteIdeaResponse.setStatusMessage("Not authorized to delete the Idea");
                }
            }
            else {
                deleteIdeaResponse.setStatus(FAILURE_STATUS);
                deleteIdeaResponse.setIdea(ideaId);
                deleteIdeaResponse.setStatusMessage("Idea doesn't exits");
            }


        return deleteIdeaResponse;
    }
    
    public IdeaStatusResponse updateIdeaStatus(IdeaStatusRequest ideaStatusRequest) {
    	
    	UserProfile userProfile= userProfileRepo.findByBemsId(ideaStatusRequest.getBemsId());
    	IdeaStatusResponse ideaStatusResponse;
    	Idea ideaEntity;
    	
    	if(null != userProfile) {
    		if(ADMIN_ROLE.equalsIgnoreCase(userProfile.getUserRoles().getRoleDesc())) {
    			ideaEntity = ideaRepository.findByIdeaId(ideaStatusRequest.getIdeaId());
                if(null != ideaEntity){
    				if(! CLOSED.equalsIgnoreCase(getStatusDesc(ideaEntity.getIdeaStatus()))) {
    					if(ideaWorkFlow(ideaStatusRequest.getIdeaStatus(),ideaEntity.getIdeaStatus())) {
		    				ideaEntity.setIdeaStatus(ideaStatusRequest.getIdeaStatus());
		    	            ideaEntity.setModificationDate(Calendar.getInstance().getTime());
		    	            Idea idea = ideaRepository.save(ideaEntity);
		    	            sendEmail(ideaEntity.getUser(),idea);
		    	            ideaStatusResponse = setResponseStatus(SUCCESS_STATUS, "Idea has been updated successfully");
    					} else 
    						ideaStatusResponse = setResponseStatus(FAILURE_STATUS, "Failed to update as input violates workflow of an Idea. Please provide valid status code");
    				} else 
    					ideaStatusResponse = setResponseStatus(FAILURE_STATUS, "Idea is already in CLOSED status");
    	        }
    	        else 
    	        	ideaStatusResponse = setResponseStatus(FAILURE_STATUS, "Idea doesn't exist");
    		} else 
    			ideaStatusResponse = setResponseStatus(FAILURE_STATUS, "User don't have enough priviledge to update the status");		
    	} else 
    		ideaStatusResponse = setResponseStatus(FAILURE_STATUS,"User doesn't exist");
    	
    	return ideaStatusResponse;
    }
    
	private IdeaStatusResponse setResponseStatus(String status, String message) {

		IdeaStatusResponse ideaStatusResp = new IdeaStatusResponse();
		ideaStatusResp.setStatus(status);
		ideaStatusResp.setStatusMessage(message);
		return ideaStatusResp;
	}

	private boolean ideaWorkFlow(int newStatus, int oldStatus) {
		
		boolean isValid = false;
		if(oldStatus == 2) {
			isValid = (newStatus == 3) ? true : false;
		} else if(oldStatus == 3) {
			isValid = (newStatus == 4 || newStatus == 5) ? true : false;
		} else if(oldStatus == 4) {
			isValid = (newStatus == 5) ? true : false;
		}
		return isValid;
	}
    
    protected String getStatusDesc(int status){
    	if (status == 1)
    		return SAVED;
    	else if (status == 2)
            return SUBMITTED;
        else if (status == 3)
            return PENDING_REVIEW;
        else if(status == 4)
        	return AWAITING_REPLY;
        else
        	return CLOSED;
    }
    
    private Map<String,String> getEmailFillerForAdmin(String status, String userName, int ideaId) {
    	Map<String,String> emailMap = new HashMap<String,String>();
    	if(status.equalsIgnoreCase(SUBMITTED)) {
    		emailMap.put(EMAIL_SUBJECT, "New Idea " + ideaFormat(ideaId) +" has been added to Submission Queue by " + userName);
    		emailMap.put(EMAIL_TITLE, userName + " has submitted an idea");
    	}
    	return emailMap;
    }
    
    private Map<String,String> getEmailFillerForGuest(String status, int ideaId) {
    	Map<String,String> emailMap = new HashMap<String,String>();
    	if(status.equalsIgnoreCase(SUBMITTED)) {
    		emailMap.put(EMAIL_SUBJECT, "Idea " + ideaFormat(ideaId) +" has been added to Submission Queue ");
    		emailMap.put(EMAIL_TITLE,"Your idea has been submitted successfully");
    	} else if (status.equalsIgnoreCase(PENDING_REVIEW)) { 
    		emailMap.put(EMAIL_SUBJECT, "Idea "+ideaFormat(ideaId) +" has been moved to Review");
    		emailMap.put(EMAIL_TITLE, "Your idea has been moved to Review");
    	} else if (status.equalsIgnoreCase(AWAITING_REPLY)){
            emailMap.put(EMAIL_SUBJECT, "Need some more info on your idea");
            emailMap.put(EMAIL_TITLE, "Need some more info on your idea");
        } else if (status.equalsIgnoreCase(CLOSED)) { 
    		emailMap.put(EMAIL_SUBJECT, "Idea "+ ideaFormat(ideaId) +" has been closed");
    		emailMap.put(EMAIL_TITLE, "Your idea has been closed");
    	}
    	
    	return emailMap;
    }

    /** To add prefix zero for single digit idea id
     * @param ideaId - idea id
     * @return String ideaId
     */
    public String ideaFormat(int ideaId)
    {
        return "PSID#" + (ideaId<=9?"0"+ideaId:String.valueOf(ideaId));
    }
  }

