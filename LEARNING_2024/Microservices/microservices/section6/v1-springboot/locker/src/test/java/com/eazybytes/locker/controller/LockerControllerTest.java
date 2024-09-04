package com.eazybytes.locker.controller;

import com.eazybytes.locker.dto.CreateLockerRequest;
import com.eazybytes.locker.model.Locker;
import com.eazybytes.locker.service.LockerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class LockerControllerTest {

    @Mock
    private LockerService lockerService;

    @InjectMocks
    private LockerController lockerController;

    @Test
    public void testCreateLocker_ValidRequest() {
        CreateLockerRequest request = new CreateLockerRequest(1234567L, "Test Locker", "123 Main St");
        when(lockerService.createLocker(request)).thenReturn(new Locker());

        ResponseEntity<Locker> response = lockerController.createLocker(request);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    // Add more test methods for other controller scenarios
}
