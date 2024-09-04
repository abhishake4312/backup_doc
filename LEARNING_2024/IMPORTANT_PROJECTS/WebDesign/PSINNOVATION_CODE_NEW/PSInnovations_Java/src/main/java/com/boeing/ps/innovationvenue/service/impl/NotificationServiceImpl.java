/**
 * 
 */
package com.boeing.ps.innovationvenue.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.hibernate.exception.DataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.boeing.ps.innovationvenue.common.exception.ApplicationException;
import com.boeing.ps.innovationvenue.entity.UserNotificationEntity;
import com.boeing.ps.innovationvenue.entity.UserProfile;
import com.boeing.ps.innovationvenue.repository.UserNotificationRepository;
import com.boeing.ps.innovationvenue.repository.UserProfileRepository;
import com.boeing.ps.innovationvenue.service.NotificationService;
import com.boeing.ps.innovationvenue.valueobjects.NotificationVO;

/**
 * @author hs645e
 *
 */
@Service
public class NotificationServiceImpl implements NotificationService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CommentServiceImpl.class.getName());

	@Autowired
	UserNotificationRepository userNotificationRepository;

	@Autowired
	UserProfileRepository userProfileRepo;

	public NotificationVO saveNotification(NotificationVO notificationVO) throws ApplicationException {
		try {
			UserNotificationEntity entity = new UserNotificationEntity();
			BeanUtils.copyProperties(notificationVO, entity);
			if (0 != notificationVO.getBemsId()) {
				UserProfile profile = userProfileRepo.findByBemsId(notificationVO.getBemsId());
				if (profile == null) {
					profile = new UserProfile();
					profile.setBemsId(notificationVO.getBemsId());
					// userProfileRepo.save(profile);
				}
				entity.setCreatedBy(Long.toString(notificationVO.getBemsId()));

				entity.setUsers(profile);
			}
			Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
			entity.setCreatedDate(calendar.getTime());
			entity.setStatus(notificationVO.getReadStatus());
			UserNotificationEntity response = userNotificationRepository.save(entity);
			BeanUtils.copyProperties(response, notificationVO);
			return notificationVO;
		} catch (DataException | IllegalArgumentException ex) {
			LOGGER.error("Save operation failed in the DAO layer", ex);
			throw new ApplicationException("Save operation failed in the DAO layer");
		}
	}

	@Override
	public void deleteNotifications(List<NotificationVO> NotificationVO) throws ApplicationException {
		try {
			List<UserNotificationEntity> opNotificationEntity = new ArrayList<>();
			if (!CollectionUtils.isEmpty(NotificationVO)) {
				NotificationVO.stream().forEach(eachNotification -> {
					UserNotificationEntity notificationEntity = new UserNotificationEntity();
					BeanUtils.copyProperties(eachNotification, notificationEntity);

					opNotificationEntity.add(notificationEntity);
				});

			}

			userNotificationRepository.deleteAll(opNotificationEntity);
		} catch (DataException | IllegalArgumentException ex) {
			LOGGER.error("deleteComment operation failed in the DAO layer", ex);
			throw new ApplicationException("deleteComment operation failed in the DAO layer");
		}
	}

	@Override
	public List<NotificationVO> getNotificationMessage(long bemsID, String isPublic) throws ApplicationException {
		try {
			List<NotificationVO> notifications = new ArrayList<>();

			UserProfile users = userProfileRepo.findByBemsId(bemsID);
			if (users == null) {
				users = new UserProfile();
				users.setBemsId(bemsID);
			}
			// Search based on Userbemsid
			ArrayList<UserNotificationEntity> notification = (ArrayList<UserNotificationEntity>) userNotificationRepository
					.findByUserProfileOrderByCreatedDateDesc(users);
			if (!CollectionUtils.isEmpty(notification)) {
				notification.stream().forEach(eachNotification -> {
					notifications.add(convertCommentEntityToVO(eachNotification));
				});

			}
			// Get all public comments
			if (isPublic.equals("1")) {
				notification = (ArrayList<UserNotificationEntity>) userNotificationRepository
						.findByIsPublicOrderByCreatedDateDesc(Integer.parseInt(isPublic));

				if (!CollectionUtils.isEmpty(notification)) {
					notification.stream().forEach(eachNotification -> {
						if (eachNotification.getUsers() == null) {
							notifications.add(convertCommentEntityToVO(eachNotification));
						} else if (eachNotification.getUsers().getBemsId() != bemsID) {
							notifications.add(convertCommentEntityToVO(eachNotification));
						}
					});

				}
			}
			return notifications;
		} catch (DataException | IllegalArgumentException ex) {
			LOGGER.error("getNotificationMessage operation failed in the DAO layer", ex);
			throw new ApplicationException("getNotificationMessage operation failed in the DAO layer" + ex);
		}
	}

	private NotificationVO convertCommentEntityToVO(UserNotificationEntity eachNotification) {
		NotificationVO notificationVO = new NotificationVO();
		BeanUtils.copyProperties(eachNotification, notificationVO);
		if (null != eachNotification.getUsers()) {
			notificationVO.setBemsId(eachNotification.getUsers().getBemsId());
		}
		notificationVO.setReadStatus(eachNotification.getStatus());
		return notificationVO;
	}

	@Override
	public List<NotificationVO> getFirst10NotificationMessage(long bemsID, String isPublic)
			throws ApplicationException {
		int paginationCount = 10;
		try {
			List<NotificationVO> notifications = new ArrayList<>();

			UserProfile users = userProfileRepo.findByBemsId(bemsID);
			if (users == null) {
				users = new UserProfile();
				users.setBemsId(bemsID);
			}
			// Search based on Userbemsid
			ArrayList<UserNotificationEntity> notification = (ArrayList<UserNotificationEntity>) userNotificationRepository
					.findFirst10ByUserProfileOrderByCreatedDateDesc(users);
			if (!CollectionUtils.isEmpty(notification)) {
				notification.stream().forEach(eachNotification -> {
					notifications.add(convertCommentEntityToVO(eachNotification));
				});

			}

			// Get all public comments
			if ("1".equals(isPublic) && notifications.size() < paginationCount) {
				notification = (ArrayList<UserNotificationEntity>) userNotificationRepository
						.findFirst10ByIsPublicOrderByCreatedDateDesc(Integer.parseInt(isPublic));

				if (!CollectionUtils.isEmpty(notification)) {
					notification.stream().forEach(eachNotification -> {
						if (notifications.size() < paginationCount) {
							if (eachNotification.getUsers() == null) {
								notifications.add(convertCommentEntityToVO(eachNotification));
							} else if (eachNotification.getUsers().getBemsId() != bemsID) {
								notifications.add(convertCommentEntityToVO(eachNotification));
							}
						}
					});

				}
			}
			return notifications;
		} catch (DataException | IllegalArgumentException ex) {
			LOGGER.error("getFirst10NotificationMessage operation failed in the DAO layer", ex);
			throw new ApplicationException("getFirst10NotificationMessage operation failed in the DAO layer" + ex);
		}
	}

}
