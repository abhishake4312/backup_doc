package com.boeing.ps.innovationvenue.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.boeing.ps.innovationvenue.config.JwtConfigUtil;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.boeing.ps.innovationvenue.common.exception.ApplicationException;
import com.boeing.ps.innovationvenue.service.NotificationService;
import com.boeing.ps.innovationvenue.valueobjects.NotificationVO;

@RestController
@CrossOrigin(origins = {"https://psinnovations-dev.web.boeing.com",
						 "https://psinnovations-test.web.boeing.com",
						 "https://psinnovations.web.boeing.com",
						 "http://localhost:4300",
						 "https://psinnovations-signalr-dev.web.boeing.com", 
						 "https://psinnovations-signalr-test.web.boeing.com", 
						 "https://psinnovations-signalr.web.boeing.com",
						 "http://localhost:59414"})
@RequestMapping(value = "/notificationService")
public class UserNotificationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserNotificationController.class);

	private static final String SUCCESS_STATUS = "SUCCESS";
	private static final String FAILURE_STATUS = "FAILURE";

	@Autowired
	public NotificationService notificationService;

	@RequestMapping(value = "/saveNotification", method = RequestMethod.POST)

	@PostMapping("/saveNotification")
	@ResponseBody
	public ResponseEntity<?> addUserNotification(@RequestBody NotificationVO notificationVO) {
		try {

			NotificationVO notificationVO1 = notificationService.saveNotification(notificationVO);

			return new ResponseEntity<NotificationVO>(
					setResponseStatus(notificationVO1, SUCCESS_STATUS, "Saved Records Successfully"), HttpStatus.OK);
		} catch (ApplicationException ex) {
			LOGGER.error("The Save operation  failed", ex);
			return new ResponseEntity<NotificationVO>(
					setResponseStatus(new NotificationVO(), FAILURE_STATUS, ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/deleteNotifications")
	@ResponseBody
	public ResponseEntity<?> deleteNotifications(@RequestBody List<NotificationVO> notificationVOs) {

		try {
			notificationService.deleteNotifications(notificationVOs);

			return new ResponseEntity<NotificationVO>(
					setResponseStatus(new NotificationVO(), SUCCESS_STATUS, "Deleted Records Successfully"),
					HttpStatus.OK);

		} catch (ApplicationException ex) {
			LOGGER.error("The delete operation  failed", ex);
			return new ResponseEntity<NotificationVO>(
					setResponseStatus(new NotificationVO(), FAILURE_STATUS, ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * This method retreive notification for the specific user and public comments
	 * based on the isPubic Flag (1-All public Comments retreived)
	 * 
	 * @param bemsID
	 * @param        isPublic---1-->All public comments 0---> No public comments
	 * @return
	 */
	@GetMapping(value = "/searchUserNotifications")
	@ResponseBody
	public List<NotificationVO> getUserNotificationMessage(@RequestParam String bemsID, @RequestParam String isPublic) {

		try {
			long bemsid = !(StringUtils.isEmpty(bemsID)) ? Long.parseLong(bemsID) : 0;
			return notificationService.getNotificationMessage(bemsid, isPublic);

		} catch (ApplicationException | NumberFormatException ex) {
			LOGGER.error("The Search operation  failed", ex);
			ArrayList<NotificationVO> notifications = new ArrayList<>();
			notifications.add(setResponseStatus(new NotificationVO(), FAILURE_STATUS, ex.getMessage()));
			return notifications;
		}

	}

	private NotificationVO setResponseStatus(NotificationVO notificationVO, String status, String message) {
		notificationVO.setStatus(status);
		notificationVO.setStatusMessage(message);
		return notificationVO;
	}

	/**
	 * This method retreive notification for the specific user and public comments
	 * based on the isPubic Flag (1-All public Comments retreived)
	 * 
	 * @param bemsID
	 * @param        isPublic---1-->All public comments 0---> No public comments
	 * @return
	 */
	@GetMapping(value = "/searchFirst10UserNotifications")
	@ResponseBody
	public List<NotificationVO> getFirst10UserNotificationMessage(@RequestHeader(value = "Authorization", required = true) String header, @RequestParam String bemsID,
																  @RequestParam String isPublic) {
		String token = header.split(" ")[1];
		Claims claims = new JwtConfigUtil().getAllClaimsFromToken(token);
		if(String.valueOf(bemsID).equalsIgnoreCase(String.valueOf(claims.get("bemsId"))) || ("true".equalsIgnoreCase(String.valueOf(claims.get("isAdmin"))))) {
			try {
				long bemsid = !(StringUtils.isEmpty(bemsID)) ? Long.parseLong(bemsID) : 0;
				return notificationService.getFirst10NotificationMessage(bemsid, isPublic);

			} catch (ApplicationException | NumberFormatException ex) {
				LOGGER.error("The Search First 10 operation  failed", ex);
				ArrayList<NotificationVO> notifications = new ArrayList<>();
				notifications.add(setResponseStatus(new NotificationVO(), FAILURE_STATUS, ex.getMessage()));
				return notifications;
			}
		}
		return null;
	}

	@GetMapping(value = "/getUserNotificationUnReadCount")
	@ResponseBody
	public ResponseEntity<?> getUserNotificationUnReadCount(@RequestHeader(value = "Authorization", required = true) String header, @RequestParam String bemsID, @RequestParam String isPublic) {

		String token = header.split(" ")[1];
		Claims claims = new JwtConfigUtil().getAllClaimsFromToken(token);
		if(String.valueOf(bemsID).equalsIgnoreCase(String.valueOf(claims.get("bemsId"))) || ("true".equalsIgnoreCase(String.valueOf(claims.get("isAdmin"))))) {
			try {
				long bemsid = !(StringUtils.isEmpty(bemsID)) ? Long.parseLong(bemsID) : 0;
				List<NotificationVO> notifications = notificationService.getNotificationMessage(bemsid, isPublic);

				List<NotificationVO> result = notifications.stream()
						.filter(notificationVO -> 0 == (notificationVO.getReadStatus())).collect(Collectors.toList());

				return new ResponseEntity<Integer>(result.size(), HttpStatus.OK);

			} catch (ApplicationException | NumberFormatException ex) {
				LOGGER.error("The getUserNotificationReadCount  failed", ex);
				return new ResponseEntity<NotificationVO>(
						setResponseStatus(new NotificationVO(), FAILURE_STATUS, ex.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return null;
	}

}
