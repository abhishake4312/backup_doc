package com.eazybytes.locker.service.impl;

import com.eazybytes.locker.dto.CreateLockerRequest;
import com.eazybytes.locker.exception.LockerAlreadyExistsException;
import com.eazybytes.locker.model.Locker;
import com.eazybytes.locker.repository.LockerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class LockerServiceImplTest {

    @Mock
    private LockerRepository lockerRepository;

    @InjectMocks
    private LockerServiceImpl lockerService;

    @Test
    public void testCreateLocker_NewCustomer() {
        CreateLockerRequest request = new CreateLockerRequest(1234567L, "Test Locker", "123 Main St");
        when(lockerRepository.findByCustomerNumber(1234567L)).thenReturn(Optional.empty());
        when(lockerRepository.save(any(Locker.class))).thenReturn(new Locker());

        Locker result = lockerService.createLocker(request);

        assertNotNull(result);
        verify(lockerRepository, times(1)).findByCustomerNumber(1234567L);
        verify(lockerRepository, times(1)).save(any(Locker.class));
    }

    // Add more test methods for other service scenarios  
}
