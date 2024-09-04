package com.boeing.ps.innovationvenue.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boeing.ps.innovationvenue.common.exception.ApplicationException;
import com.boeing.ps.innovationvenue.service.CommentService;
import com.boeing.ps.innovationvenue.valueobjects.CommentVO;

@RestController
@CrossOrigin(origins = {"https://psinnovations-dev.web.boeing.com",
						 "https://psinnovations-test.web.boeing.com",
						 "https://psinnovations.web.boeing.com",
						 "http://localhost:4300"})
@RequestMapping(value = "/commentService")
public class IdeaCommentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(IdeaCommentController.class.getName());

	@Autowired
	private CommentService commentService;

	private static final String SUCCESS_STATUS = "SUCCESS";
	private static final String FAILURE_STATUS = "FAILURE";

	@GetMapping(value = "/searchComment")
	public CommentVO searchComment(@RequestParam String commentID) {

		try {

			CommentVO comment = commentService.getComments(new BigDecimal(commentID));
			return setResponseStatus(comment, SUCCESS_STATUS, "The Search Option Completed successfully  ");

		} catch (NumberFormatException ex) {
			LOGGER.error("CommentID provided in the search criteria is not valid one", ex);
			return setResponseStatus(new CommentVO(), FAILURE_STATUS,
					"CommentID provided in the search criteria is not valid");
		} catch (ApplicationException ex) {
			LOGGER.error("The search operation  failed", ex);
			return setResponseStatus(new CommentVO(), FAILURE_STATUS, ex.getMessage());
		}

	}

	private CommentVO setResponseStatus(CommentVO comment, String status, String message) {

		if (comment == null) {
			comment = new CommentVO();
		}
		comment.setStatus(status);
		comment.setStatusMessage(message);
		return comment;
	}

	@GetMapping(value = "/searchAllComment")
	public List<CommentVO> searchAllComments(@RequestParam(value="bemsId", required=true) long bemsId,@RequestParam String ideaID) {
		try {

			return commentService.getIdeaComments(bemsId,new BigDecimal(ideaID));
		} catch (NumberFormatException ex) {
			LOGGER.error("CommentID provided in the search criteria is not valid", ex);

			ArrayList<CommentVO> comments = new ArrayList<CommentVO>();
			comments.add(setResponseStatus(new CommentVO(), FAILURE_STATUS,
					"CommentID provided in the search criteria is not valid"));
			return comments;
		} catch (ApplicationException ex) {
			LOGGER.error("The search operation  failed", ex);

			ArrayList<CommentVO> comments = new ArrayList<>();
			comments.add(setResponseStatus(new CommentVO(), FAILURE_STATUS, ex.getMessage()));
			return comments;

		}

	}

	@PostMapping("/addComment")
	public CommentVO addComment(@RequestBody CommentVO commentVO) {
		try {
			CommentVO comment = commentService.saveComment(commentVO);
			return setResponseStatus(comment, SUCCESS_STATUS, "The Save Option Completed successfully  ");

		} catch (ApplicationException ex) {
			LOGGER.error("The search operation  failed", ex);
			return setResponseStatus(new CommentVO(), FAILURE_STATUS, ex.getMessage());
		}
	}

	@PostMapping("/deleteComments")
	public CommentVO delete(@RequestBody List<CommentVO> commentVOs) throws ApplicationException {

		try {
			commentService.deleteComment(commentVOs);
			return setResponseStatus(new CommentVO(), SUCCESS_STATUS, "The delete Option Completed successfully  ");

		} catch (ApplicationException ex) {
			LOGGER.error("The search operation  failed", ex);
			return setResponseStatus(new CommentVO(), FAILURE_STATUS, ex.getMessage());
		}

	}

}
