package com.boeing.ps.innovationvenue.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.boeing.ps.innovationvenue.entity.Idea;
import com.boeing.ps.innovationvenue.entity.IdeaAssignee;

@Repository
public interface IdeaAssigneeRepository extends JpaRepository<IdeaAssignee,Long> {
	
	List<IdeaAssignee> findByAssigneeIdAndStatusFlag(long bemsId,String statusFlag);

	IdeaAssignee findByIdea(Idea idea);
	
	@Transactional
	@Modifying
	@Query(value= "update idea_assignee set status_flag =?1 where assignee_id = ?2 and idea_id = ?3", nativeQuery= true)
	Integer updateStatusFlag(String statusFlag, long assigneeId, int ideaId);
	
	@Query(value= "Select case when exists (Select * from idea_assignee where idea_id = ?1 ) then 'true' else 'false' END", nativeQuery= true)
	Boolean existsByIdeaId(int ideaId);
	
}
