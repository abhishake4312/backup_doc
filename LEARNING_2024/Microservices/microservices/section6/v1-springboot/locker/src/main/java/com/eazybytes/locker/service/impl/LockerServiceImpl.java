package com.eazybytes.locker.service.impl;

import com.eazybytes.locker.dto.LockerDto;  
import com.eazybytes.locker.entity.Locker;
import com.eazybytes.locker.exception.LockerAlreadyExistsException;
import com.eazybytes.locker.exception.ResourceNotFoundException;
import com.eazybytes.locker.mapper.LockerMapper;
import com.eazybytes.locker.repository.LockerRepository;
import com.eazybytes.locker.service.ILockerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LockerServiceImpl implements ILockerService {

    private LockerRepository lockerRepository;

    @Override
    public void createLocker(String customerNumber) {
        Optional<Locker> optionalLocker = lockerRepository.findByCustomerNumber(customerNumber);
        if(optionalLocker.isPresent()){
            throw new LockerAlreadyExistsException("Locker already exists for customer: "+customerNumber);
        }
        lockerRepository.save(createNewLocker(customerNumber));
    }
    
    private Locker createNewLocker(String customerNumber) {
        Locker locker = new Locker();
        locker.setCustomerNumber(customerNumber);
        locker.setLockerNumber(generateLockerNumber());
        locker.setLockerType("Small");
        locker.setStatus("Active");
        return locker;
    }
    
    private String generateLockerNumber() {
        Random random = new Random();
        int number = random.nextInt(999999);
        return String.format("%06d", number);
    }

    @Override
    public LockerDto fetchLocker(String customerNumber) {
        Locker locker = lockerRepository.findByCustomerNumber(customerNumber).orElseThrow(
            () -> new ResourceNotFoundException("Locker", "customerNumber", customerNumber)
        );
        return LockerMapper.mapToLockerDto(locker);
    }

    @Override 
    public boolean updateLocker(LockerDto lockerDto) {
        Locker locker = lockerRepository.findByLockerNumber(lockerDto.getLockerNumber()).orElseThrow(
            () -> new ResourceNotFoundException("Locker", "lockerNumber", lockerDto.getLockerNumber())
        );
        locker.setLockerType(lockerDto.getLockerType());
        locker.setStatus(lockerDto.getStatus());
        lockerRepository.save(locker);
        return true;
    }

    @Override
    public boolean deleteLocker(String customerNumber) {
        Locker locker = lockerRepository.findByCustomerNumber(customerNumber).orElseThrow(
            () -> new ResourceNotFoundException("Locker", "customerNumber", customerNumber) 
        );
        lockerRepository.delete(locker);
        return true;
    }
    
}
