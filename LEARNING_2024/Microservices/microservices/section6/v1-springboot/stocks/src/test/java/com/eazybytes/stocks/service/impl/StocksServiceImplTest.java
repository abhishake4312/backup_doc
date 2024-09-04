package com.eazybytes.stocks.service.impl;

import com.eazybytes.stocks.dto.StockDto;
import com.eazybytes.stocks.entity.Stock;
import com.eazybytes.stocks.exception.ResourceNotFoundException;
import com.eazybytes.stocks.exception.StockAlreadyExistsException;
import com.eazybytes.stocks.mapper.StockMapper;
import com.eazybytes.stocks.repository.StocksRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class StocksServiceImplTest {

    @Mock
    private StocksRepository stocksRepository;

    @InjectMocks
    private StocksServiceImpl stocksService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createStock_ShouldCreateNewStock() {
        StockDto stockDto = new StockDto("C001", "S001", "EQUITY", "ACTIVE");
        Stock stock = StockMapper.mapToStock(stockDto);
        when(stocksRepository.findByCustomerNumber(stockDto.getCustomerNumber())).thenReturn(Optional.empty());
        when(stocksRepository.save(any(Stock.class))).thenReturn(stock);

        StockDto result = stocksService.createStock(stockDto);

        assertNotNull(result);
        assertEquals(stockDto.getCustomerNumber(), result.getCustomerNumber());
        verify(stocksRepository, times(1)).findByCustomerNumber(stockDto.getCustomerNumber());
        verify(stocksRepository, times(1)).save(any(Stock.class));
    }

    @Test
    void createStock_ShouldThrowExceptionWhenStockExists() {
        StockDto stockDto = new StockDto("C001", "S001", "EQUITY", "ACTIVE");
        when(stocksRepository.findByCustomerNumber(stockDto.getCustomerNumber())).thenReturn(Optional.of(new Stock()));

        assertThrows(StockAlreadyExistsException.class, () -> stocksService.createStock(stockDto));
        verify(stocksRepository, times(1)).findByCustomerNumber(stockDto.getCustomerNumber());
        verify(stocksRepository, never()).save(any(Stock.class));
    }

    @Test
    void fetchStock_ShouldReturnStock() {
        String customerNumber = "C001";
        Stock stock = new Stock();
        stock.setCustomerNumber(customerNumber);
        when(stocksRepository.findByCustomerNumber(customerNumber)).thenReturn(Optional.of(stock));

        StockDto result = stocksService.fetchStock(customerNumber);

        assertNotNull(result);
        assertEquals(customerNumber, result.getCustomerNumber());
        verify(stocksRepository, times(1)).findByCustomerNumber(customerNumber);
    }

    @Test
    void fetchStock_ShouldThrowExceptionWhenStockNotFound() {
        String customerNumber = "C001";
        when(stocksRepository.findByCustomerNumber(customerNumber)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> stocksService.fetchStock(customerNumber));
        verify(stocksRepository, times(1)).findByCustomerNumber(customerNumber);
    }

    @Test
    void updateStock_ShouldUpdateExistingStock() {
        StockDto stockDto = new StockDto("C001", "S001", "EQUITY", "INACTIVE");
        Stock existingStock = new Stock();
        existingStock.setCustomerNumber(stockDto.getCustomerNumber());
        when(stocksRepository.findByCustomerNumber(stockDto.getCustomerNumber())).thenReturn(Optional.of(existingStock));
        when(stocksRepository.save(any(Stock.class))).thenReturn(existingStock);

        StockDto result = stocksService.updateStock(stockDto);

        assertNotNull(result);
        assertEquals(stockDto.getCustomerNumber(), result.getCustomerNumber());
        verify(stocksRepository, times(1)).findByCustomerNumber(stockDto.getCustomerNumber());
        verify(stocksRepository, times(1)).save(any(Stock.class));
    }

    @Test
    void deleteStock_ShouldDeleteExistingStock() {
        String customerNumber = "C001";
        Stock existingStock = new Stock();
        when(stocksRepository.findByCustomerNumber(customerNumber)).thenReturn(Optional.of(existingStock));

        boolean result = stocksService.deleteStock(customerNumber);

        assertTrue(result);
        verify(stocksRepository, times(1)).findByCustomerNumber(customerNumber);
        verify(stocksRepository, times(1)).delete(existingStock);
    }
}
