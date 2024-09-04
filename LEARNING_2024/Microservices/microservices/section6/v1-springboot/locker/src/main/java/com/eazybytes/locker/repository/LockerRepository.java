package com.eazybytes.locker.repository;

import com.eazybytes.locker.entity.Locker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LockerRepository extends JpaRepository<Locker, Long> {

    Optional<Locker> findByCustomerNumber(String customerNumber);
    
    Optional<Locker> findByLockerNumber(String lockerNumber);
    
}
