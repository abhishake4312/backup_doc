package com.boeing.ps.innovationvenue.controller;



import com.boeing.ps.innovationvenue.common.exception.ApplicationException;
import com.boeing.ps.innovationvenue.config.JwtConfigUtil;
import com.boeing.ps.innovationvenue.service.SaveSubmitIdeaService;
import com.boeing.ps.innovationvenue.valueobjects.*;

import io.jsonwebtoken.Claims;
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
						 "http://localhost:4300",
						 "https://psinnovations-signalr-dev.web.boeing.com", 
						 "https://psinnovations-signalr-test.web.boeing.com", 
						 "https://psinnovations-signalr.web.boeing.com",
						 "http://localhost:59414"})
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
	public ResponseEntity<AllIdeaResponse> getAllIdeaForUser(@RequestHeader(value = "Authorization", required = true) String header, @RequestParam(value="bemsId", required=true) long  bemsId) {
		String token = header.split(" ")[1];
		Claims claims = new JwtConfigUtil().getAllClaimsFromToken(token);
		if(String.valueOf(bemsId).equalsIgnoreCase(String.valueOf(claims.get("bemsId"))) || ("true".equalsIgnoreCase(String.valueOf(claims.get("isAdmin"))))) {
			return new ResponseEntity<AllIdeaResponse>(saveSubmitIdeaService.getAllIdeaDetails(bemsId), HttpStatus.OK);
		}
		AllIdeaResponse allIdeaResponse = new AllIdeaResponse(null, "Unauthorized usage of access token.");
		return new ResponseEntity<AllIdeaResponse>(allIdeaResponse, HttpStatus.UNAUTHORIZED);
	}

	@RequestMapping(value = "/sendFeedback", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<MailResponse> sendFeedback(@Validated @RequestBody UserQueryRequest userQueryReq)  {
		MailResponse mailResponse = saveSubmitIdeaService.sendFeedback(userQueryReq);
		return new ResponseEntity<MailResponse>(mailResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/getIdeaById", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<IdeaByIdResponse> getIdeaById(@RequestHeader(value = "Authorization", required = true) String header, @RequestParam(value="bemsId", required=true) long bemsId,
														@RequestParam(value="ideaId", required = true) int ideaId, @RequestParam(value="assigneeId", defaultValue= "0", required = false) long assigneeId) {
		String token = header.split(" ")[1];
		LOGGER.info("idea id "+ ideaId + " bemsId " + bemsId + " assigneeId " + assigneeId);
		Claims claims = new JwtConfigUtil().getAllClaimsFromToken(token);
		LOGGER.info("Bems id via claim is: "+claims.get("bemsId"));
		if(String.valueOf(bemsId).equalsIgnoreCase(String.valueOf(claims.get("bemsId"))) || ("true".equalsIgnoreCase(String.valueOf(claims.get("isAdmin"))))) {
			return new ResponseEntity<IdeaByIdResponse>(saveSubmitIdeaService.getIdeaById(bemsId,ideaId,assigneeId), HttpStatus.OK);
		}
		IdeaByIdResponse ideaByIdResponse = new IdeaByIdResponse();
		ideaByIdResponse.setMessage("Unauthorized usage of access token.");
		ideaByIdResponse.setIdea(null);
		return new ResponseEntity<IdeaByIdResponse>(ideaByIdResponse, HttpStatus.UNAUTHORIZED);
	}

	@RequestMapping(value = "/deleteIdeaById", method = RequestMethod.DELETE)
	public ResponseEntity<DeleteIdeaResponse> deleteIdeaById(@RequestHeader(value = "Authorization", required = true) String header, @RequestParam(value="bemsId", required=true) long bemsId,
								@RequestParam(value="ideaId", required = true) int ideaId) {
		LOGGER.info("delete idea with id "+ ideaId);
		String token = header.split(" ")[1];
		Claims claims = new JwtConfigUtil().getAllClaimsFromToken(token);
		if(String.valueOf(bemsId).equalsIgnoreCase(String.valueOf(claims.get("bemsId"))) || ("true".equalsIgnoreCase(String.valueOf(claims.get("isAdmin"))))) {
			return new ResponseEntity<DeleteIdeaResponse>(saveSubmitIdeaService.deleteIdeabyId(bemsId,ideaId), HttpStatus.OK);
		}
		IdeaByIdResponse ideaByIdResponse = new IdeaByIdResponse();
		ideaByIdResponse.setMessage("Unauthorized usage of access token.");
		ideaByIdResponse.setIdea(null);
		return new ResponseEntity(ideaByIdResponse, HttpStatus.UNAUTHORIZED);
	}

	@RequestMapping(value = "/getIdeaByStatus", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<IdeaResponseForAdmin> getAllIdeaForAdmin(@RequestHeader(value = "Authorization", required = true) String header, @RequestParam(value="bemsId", required=true) long bemsId, @RequestParam(value="status", required = true) int status) {
		String token = header.split(" ")[1];
		Claims claims = new JwtConfigUtil().getAllClaimsFromToken(token);
		if(String.valueOf(bemsId).equalsIgnoreCase(String.valueOf(claims.get("bemsId"))) || ("true".equalsIgnoreCase(String.valueOf(claims.get("isAdmin"))))) {
			IdeaResponseForAdmin response = saveSubmitIdeaService.getAllIdeaDetailsForAdmin(bemsId, status);
			if(response.getIdeaList() == null || response.getIdeaList().isEmpty())
				if("Non-Admin user".equalsIgnoreCase(response.getMessage()))
					return new ResponseEntity<IdeaResponseForAdmin>(response, HttpStatus.UNAUTHORIZED);
				else if("User doesn't exist".equalsIgnoreCase(response.getMessage()))
					return new ResponseEntity<IdeaResponseForAdmin>(response, HttpStatus.NOT_FOUND);
				else if("Invalid status".equalsIgnoreCase(response.getMessage()))
					return new ResponseEntity<IdeaResponseForAdmin>(response, HttpStatus.UNAUTHORIZED);
			return new ResponseEntity<IdeaResponseForAdmin>(response, HttpStatus.OK);
		}
		IdeaResponseForAdmin allIdeaResponse = new IdeaResponseForAdmin(null, "Unauthorized usage of access token");
		return new ResponseEntity<IdeaResponseForAdmin>(allIdeaResponse, HttpStatus.UNAUTHORIZED);
	}

	@RequestMapping(value = "/updateIdeaStatus", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<IdeaStatusResponse> updateIdeaStatus(@Validated @RequestBody IdeaStatusRequest ideaStatusRequest) {
		LOGGER.info("Update idea Id "+ ideaStatusRequest.getIdeaId() + "Update idea status "+ ideaStatusRequest.getIdeaStatus());
		IdeaStatusResponse ideaStatusResponse = saveSubmitIdeaService.updateIdeaStatus(ideaStatusRequest);
		return new ResponseEntity<IdeaStatusResponse>(ideaStatusResponse, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getIdeasForSME", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<AllIdeaResponse> getIdeasForSME(@RequestHeader(value = "Authorization", required = true) String header, @RequestParam(value="bemsId", required=true) long  bemsId) {
		String token = header.split(" ")[1];
		Claims claims = new JwtConfigUtil().getAllClaimsFromToken(token);
		if(String.valueOf(bemsId).equalsIgnoreCase(String.valueOf(claims.get("bemsId"))) || ("SME".equalsIgnoreCase(String.valueOf(claims.get("isSME"))))) {
			LOGGER.info("Get Ideas mapped to SME, bemsId --> "+ bemsId);
			AllIdeaResponse allIdeaResponse = saveSubmitIdeaService.getIdeasAssignedToSME(bemsId);
			return new ResponseEntity<AllIdeaResponse>(allIdeaResponse, HttpStatus.OK);
		}
		AllIdeaResponse allIdeaResponse = new AllIdeaResponse(null, "Unauthorized usage of access token");
		return new ResponseEntity<AllIdeaResponse>(allIdeaResponse, HttpStatus.UNAUTHORIZED);
	}

}
