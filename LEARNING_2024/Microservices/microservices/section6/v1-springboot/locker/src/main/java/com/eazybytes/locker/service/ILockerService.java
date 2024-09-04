package com.eazybytes.locker.service;

import com.eazybytes.locker.dto.LockerDto;

public interface ILockerService {

    void createLocker(String customerNumber);
    
    LockerDto fetchLocker(String customerNumber);
    
    boolean updateLocker(LockerDto lockerDto);
    
    boolean deleteLocker(String customerNumber);

}
