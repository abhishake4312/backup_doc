package com.boeing.ps.innovationvenue.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boeing.ps.innovationvenue.entity.UserNotificationEntity;
import com.boeing.ps.innovationvenue.entity.UserProfile;

@Repository
public interface UserNotificationRepository extends JpaRepository<UserNotificationEntity, BigDecimal> {


	List<UserNotificationEntity> findByUserProfileOrderByCreatedDateDesc(UserProfile userProfile);

	List<UserNotificationEntity> findByIsPublicOrderByCreatedDateDesc(int isPublic);
	
	

	List<UserNotificationEntity> findFirst10ByUserProfileOrderByCreatedDateDesc(UserProfile userProfile);

	List<UserNotificationEntity> findFirst10ByIsPublicOrderByCreatedDateDesc(int isPublic);

	
}
