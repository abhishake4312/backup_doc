package com.boeing.ps.innovationvenue.controller;



import com.boeing.ps.innovationvenue.common.exception.ApplicationException;
import com.boeing.ps.innovationvenue.service.SaveSubmitIdeaService;
import com.boeing.ps.innovationvenue.valueobjects.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.boeing.ps.innovationvenue.service.UserProfileService;

@RestController
@CrossOrigin(origins = {"https://psinnovations-dev.web.boeing.com",
						 "https://psinnovations-test.web.boeing.com",
						 "https://psinnovations.web.boeing.com",
						 "http://localhost:4300"})
@RequestMapping(value = "/innovationVenue")
public class DashboardController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DashboardController.class);
	
	private static final String SUCCESS_STATUS = "SUCCESS";
	private static final String FAILURE_STATUS = "FAILURE";
	
	@Autowired
	private UserProfileService userProfileService;

	@Autowired
	private SaveSubmitIdeaService saveSubmitIdeaService;
	
	@RequestMapping(value = "/getRoles", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<UserProfileResponse> getRoles(@Validated @RequestBody UserProfileRequest userProfileReq) {
		
		UserProfileResponse userProfileRes;
		try {
			userProfileRes = userProfileService.getRolesByUserId(userProfileReq);
			userProfileRes.setStatus(SUCCESS_STATUS);
			userProfileRes.setStatusMessage(SUCCESS_STATUS);
		} catch (ApplicationException ae) {
			LOGGER.error(ae.getMessage());
			userProfileRes = new UserProfileResponse();
			userProfileRes.setStatus(FAILURE_STATUS);
			userProfileRes.setStatusMessage(ae.getMessage());
		}
		return new ResponseEntity<UserProfileResponse>(userProfileRes, HttpStatus.OK);
	}

	@RequestMapping(value = "/saveSubmitIdea", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<IdeaResponse> saveSubmitIdea(@RequestBody IdeaRequest ideaRequest) {
		LOGGER.info("Saving user idea "+ ideaRequest.getBemsId());

		IdeaResponse ideaResponse = saveSubmitIdeaService.saveSubmitIdea(ideaRequest);

		return new ResponseEntity<IdeaResponse>(ideaResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAllIdea", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<AllIdeaResponse> getAllIdeaForUser(@RequestParam(value="bemsId", required=true) long  bemsId) {
		return new ResponseEntity<AllIdeaResponse>(saveSubmitIdeaService.getAllIdeaDetails(bemsId), HttpStatus.OK);
	}

	@RequestMapping(value = "/sendFeedback", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<MailResponse> sendFeedback(@Validated @RequestBody UserQueryRequest userQueryReq)  {
		MailResponse mailResponse = saveSubmitIdeaService.sendFeedback(userQueryReq);
		return new ResponseEntity<MailResponse>(mailResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/getIdeaById", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<IdeaByIdResponse> getIdeaById(@RequestParam(value="bemsId", required=true) long bemsId,
														@RequestParam(value="ideaId", required = true) int ideaId) {
		LOGGER.info("idea id "+ ideaId);
		return new ResponseEntity<IdeaByIdResponse>(saveSubmitIdeaService.getIdeaById(bemsId,ideaId), HttpStatus.OK);

	}

	@RequestMapping(value = "/deleteIdeaById", method = RequestMethod.DELETE)
	public ResponseEntity<DeleteIdeaResponse> deleteIdeaById(@RequestParam(value="bemsId", required=true) long bemsId,
								@RequestParam(value="ideaId", required = true) int ideaId) {
		LOGGER.info("delete idea with id "+ ideaId);
		return new ResponseEntity<DeleteIdeaResponse>(saveSubmitIdeaService.deleteIdeabyId(bemsId,ideaId), HttpStatus.OK);
	}

	@RequestMapping(value = "/getIdeaByStatus", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<AllIdeaResponse> getAllIdeaForAdmin(@RequestParam(value="bemsId", required=true) long bemsId, @RequestParam(value="status", required = true) int status) {
		AllIdeaResponse response = saveSubmitIdeaService.getAllIdeaDetailsForAdmin(bemsId, status);
		if(response.getIdeaList() == null || response.getIdeaList().isEmpty())
			if("Non-Admin user".equalsIgnoreCase(response.getMessage()))
				return new ResponseEntity<AllIdeaResponse>(response, HttpStatus.UNAUTHORIZED);
			else if("User doesn't exist".equalsIgnoreCase(response.getMessage()))
				return new ResponseEntity<AllIdeaResponse>(response, HttpStatus.NOT_FOUND);
			else if("Invalid status".equalsIgnoreCase(response.getMessage()))
				return new ResponseEntity<AllIdeaResponse>(response, HttpStatus.UNAUTHORIZED);
		return new ResponseEntity<AllIdeaResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/updateIdeaStatus", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<IdeaStatusResponse> updateIdeaStatus(@Validated @RequestBody IdeaStatusRequest ideaStatusRequest) {
		LOGGER.info("Update idea Id "+ ideaStatusRequest.getIdeaId() + "Update idea status "+ ideaStatusRequest.getIdeaStatus());
		IdeaStatusResponse ideaStatusResponse = saveSubmitIdeaService.updateIdeaStatus(ideaStatusRequest);
		return new ResponseEntity<IdeaStatusResponse>(ideaStatusResponse, HttpStatus.OK);
	}

}
