package com.boeing.ps.innovationvenue.repository;

import com.boeing.ps.innovationvenue.entity.Idea;
import com.boeing.ps.innovationvenue.entity.UserProfile;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeaRepository extends JpaRepository<Idea,Object> {

    Idea findByIdeaId(int ideaId);
    
    @Query(value="SELECT i FROM Idea i WHERE i.ideaStatus != 1")
    List<Idea> getIdeasForAdmin();

    List<Idea> findByIdeaStatusOrderByModificationDateDesc(int status);

    List<Idea> findByUserOrderByModificationDateDesc(UserProfile userProfile);
}
