package com.eazybytes.locker.mapper;

import com.eazybytes.locker.dto.LockerDto;
import com.eazybytes.locker.entity.Locker;

public class LockerMapper {

    public static LockerDto mapToLockerDto(Locker locker) {
        LockerDto lockerDto = new LockerDto();
        lockerDto.setCustomerNumber(locker.getCustomerNumber());
        lockerDto.setLockerNumber(locker.getLockerNumber()); 
        lockerDto.setLockerType(locker.getLockerType());
        lockerDto.setStatus(locker.getStatus());
        return lockerDto;
    }

    public static Locker mapToLocker(LockerDto lockerDto) {
        Locker locker = new Locker();
        locker.setCustomerNumber(lockerDto.getCustomerNumber());
        locker.setLockerNumber(lockerDto.getLockerNumber());
        locker.setLockerType(lockerDto.getLockerType());
        locker.setStatus(lockerDto.getStatus());
        return locker;
    }

}
