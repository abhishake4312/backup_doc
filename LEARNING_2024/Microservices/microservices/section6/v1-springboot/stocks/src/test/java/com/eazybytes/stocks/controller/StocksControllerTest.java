package com.eazybytes.stocks.controller;

import com.eazybytes.stocks.dto.StockDto;
import com.eazybytes.stocks.service.IStocksService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class StocksControllerTest {

    @Mock
    private IStocksService stocksService;

    @InjectMocks
    private StocksController stocksController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createStock_ShouldReturnCreatedStock() {
        StockDto stockDto = new StockDto("C001", "S001", "EQUITY", "ACTIVE");
        when(stocksService.createStock(any(StockDto.class))).thenReturn(stockDto);

        ResponseEntity<StockDto> response = stocksController.createStock(stockDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(stockDto, response.getBody());
        verify(stocksService, times(1)).createStock(stockDto);
    }

    @Test
    void fetchStock_ShouldReturnStock() {
        String customerNumber = "C001";
        StockDto stockDto = new StockDto(customerNumber, "S001", "EQUITY", "ACTIVE");
        when(stocksService.fetchStock(customerNumber)).thenReturn(stockDto);

        ResponseEntity<StockDto> response = stocksController.fetchStock(customerNumber);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(stockDto, response.getBody());
        verify(stocksService, times(1)).fetchStock(customerNumber);
    }

    @Test
    void updateStock_ShouldReturnUpdatedStock() {
        StockDto stockDto = new StockDto("C001", "S001", "EQUITY", "INACTIVE");
        when(stocksService.updateStock(any(StockDto.class))).thenReturn(stockDto);

        ResponseEntity<StockDto> response = stocksController.updateStock(stockDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(stockDto, response.getBody());
        verify(stocksService, times(1)).updateStock(stockDto);
    }

    @Test
    void deleteStock_ShouldReturnSuccessMessage() {
        String customerNumber = "C001";
        when(stocksService.deleteStock(customerNumber)).thenReturn(true);

        ResponseEntity<String> response = stocksController.deleteStock(customerNumber);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Stock deleted successfully", response.getBody());
        verify(stocksService, times(1)).deleteStock(customerNumber);
    }
}
