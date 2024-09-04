package com.boeing.ps.innovationvenue.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boeing.ps.innovationvenue.entity.Idea;
import com.boeing.ps.innovationvenue.entity.IdeaCommentEntity;

@Repository
public interface CommentRepository extends CrudRepository<IdeaCommentEntity, BigDecimal> {

	Optional<IdeaCommentEntity> findById(BigDecimal x);

	List<IdeaCommentEntity> findByIdea(Idea idea);
}
