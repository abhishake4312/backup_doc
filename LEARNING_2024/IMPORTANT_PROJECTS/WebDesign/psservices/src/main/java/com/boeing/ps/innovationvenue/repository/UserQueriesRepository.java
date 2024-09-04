package com.boeing.ps.innovationvenue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boeing.ps.innovationvenue.entity.UserQueries;

@Repository
public interface UserQueriesRepository extends JpaRepository<UserQueries,Long> {

}
