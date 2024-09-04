/**
 * 
 */
package com.boeing.ps.innovationvenue.service;

import java.util.List;

import com.boeing.ps.innovationvenue.common.exception.ApplicationException;
import com.boeing.ps.innovationvenue.valueobjects.NotificationVO;

/**
 * @author hs645e
 *
 */
public interface NotificationService {

	NotificationVO saveNotification(NotificationVO notificationVO) throws ApplicationException;

	void deleteNotifications(List<NotificationVO> NotificationVO) throws ApplicationException;

	List<NotificationVO> getNotificationMessage(long bemsID, String isPublic) throws ApplicationException;

	List<NotificationVO> getFirst10NotificationMessage(long bemsid, String isPublic) throws ApplicationException;

}
