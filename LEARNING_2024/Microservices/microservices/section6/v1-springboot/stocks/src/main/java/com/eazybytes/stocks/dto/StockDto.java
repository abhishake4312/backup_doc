package com.eazybytes.stocks.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class StockDto {

    @NotEmpty(message = "Customer number can not be a null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Customer number must be 10 digits")
    private String customerNumber;

    @Pattern(regexp = "(^$|[0-9]{9})", message = "Stock number must be 9 digits")
    private String stockNumber;

    @NotEmpty(message = "Stock type can not be a null or empty")
    private String stockType;

    @NotEmpty(message = "Stock status can not be a null or empty")
    private String status;

}
