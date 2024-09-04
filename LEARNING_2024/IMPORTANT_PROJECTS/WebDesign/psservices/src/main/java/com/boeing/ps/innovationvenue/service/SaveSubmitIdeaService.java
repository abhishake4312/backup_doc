package com.boeing.ps.innovationvenue.service;

import com.boeing.ps.innovationvenue.valueobjects.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public abstract class SaveSubmitIdeaService {

    public abstract IdeaResponse saveSubmitIdea(IdeaRequest ideaRequest);

    public abstract AllIdeaResponse getAllIdeaDetails(long bemsId);

    public abstract IdeaByIdResponse getIdeaById(long bemsId,int ideaId);

    public abstract MailResponse sendFeedback(UserQueryRequest userQueryReq);

    public abstract DeleteIdeaResponse deleteIdeabyId(long bemsId,int ideaId);

    public abstract AllIdeaResponse getAllIdeaDetailsForAdmin(long bemsId, int status);

    public abstract IdeaStatusResponse updateIdeaStatus(IdeaStatusRequest ideaStatusRequest);
}
