package com.eazybytes.locker.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class LockerDto {

    @NotEmpty(message = "Customer number cannot be null or empty")
    @Pattern(regexp="(^$|[0-9]{7})",message = "Customer number must be 7 digits")
    private String customerNumber;
    
    @NotEmpty(message = "Locker number cannot be null or empty") 
    @Pattern(regexp="(^$|[0-9]{6})",message = "Locker number must be 6 digits")
    private String lockerNumber;
    
    @NotEmpty(message = "Locker type cannot be null or empty")
    private String lockerType;
     
    private String status;
}
