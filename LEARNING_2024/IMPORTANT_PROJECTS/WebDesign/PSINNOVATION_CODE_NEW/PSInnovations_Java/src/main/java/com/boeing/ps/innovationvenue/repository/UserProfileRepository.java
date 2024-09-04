package com.boeing.ps.innovationvenue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.boeing.ps.innovationvenue.entity.UserProfile;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

	UserProfile findByBemsId(Long bemsId);
	
}
