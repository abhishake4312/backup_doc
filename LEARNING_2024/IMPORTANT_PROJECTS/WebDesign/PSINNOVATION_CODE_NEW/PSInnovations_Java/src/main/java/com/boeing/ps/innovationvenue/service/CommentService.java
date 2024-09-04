/**
 * 
 */
package com.boeing.ps.innovationvenue.service;

import java.math.BigDecimal;
import java.util.List;

import com.boeing.ps.innovationvenue.common.exception.ApplicationException;
import com.boeing.ps.innovationvenue.valueobjects.CommentVO;

/**
 * @author hs645e
 *
 */
public interface CommentService {
	
	CommentVO saveComment(CommentVO commentVO) throws ApplicationException;
	List<CommentVO> getIdeaComments(long bemsId,BigDecimal mainContentId) throws ApplicationException;
	CommentVO getComments(BigDecimal commentID) throws ApplicationException;
	void deleteComment(List<CommentVO> comments) throws ApplicationException;
}
