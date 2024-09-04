package com.boeing.ps.innovationvenue.repository;

import com.boeing.ps.innovationvenue.entity.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRoles, Long> {
}
