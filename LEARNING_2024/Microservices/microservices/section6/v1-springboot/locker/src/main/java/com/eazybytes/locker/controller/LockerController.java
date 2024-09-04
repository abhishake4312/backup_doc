package com.eazybytes.locker.controller;

import com.eazybytes.locker.dto.LockerDto;
import com.eazybytes.locker.service.ILockerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/locker", produces = {MediaType.APPLICATION_JSON_VALUE})  
@Validated
@AllArgsConstructor
public class LockerController {

    private ILockerService iLockerService;

    @PostMapping("/create")
    public ResponseEntity<String> createLocker(@RequestParam 
                @Pattern(regexp="(^$|[0-9]{7})",message = "Customer number must be 7 digits") 
                String customerNumber) {
        iLockerService.createLocker(customerNumber);
        return ResponseEntity.status(HttpStatus.CREATED).body("Locker created successfully");
    }
    
    @GetMapping("/fetch")
    public ResponseEntity<LockerDto> fetchLocker(@RequestParam
                @Pattern(regexp="(^$|[0-9]{7})",message = "Customer number must be 7 digits")
                String customerNumber) {
        LockerDto lockerDto = iLockerService.fetchLocker(customerNumber);
        return ResponseEntity.ok(lockerDto);
    }
    
    @PutMapping("/update")  
    public ResponseEntity<String> updateLocker(@Valid @RequestBody LockerDto lockerDto) {
        boolean isUpdated = iLockerService.updateLocker(lockerDto);
        if(isUpdated) {
            return ResponseEntity.ok("Locker updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Failed to update locker");
        }
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteLocker(@RequestParam
                @Pattern(regexp="(^$|[0-9]{7})",message = "Customer number must be 7 digits") 
                String customerNumber) {
        boolean isDeleted = iLockerService.deleteLocker(customerNumber);
        if(isDeleted) {
            return ResponseEntity.ok("Locker deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Failed to delete locker");
        }
    }
}
