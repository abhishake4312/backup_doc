package com.eazybytes.stocks.service.impl;

import com.eazybytes.stocks.dto.StockDto;
import com.eazybytes.stocks.entity.Stock;
import com.eazybytes.stocks.exception.ResourceNotFoundException;
import com.eazybytes.stocks.exception.StockAlreadyExistsException;
import com.eazybytes.stocks.mapper.StockMapper;
import com.eazybytes.stocks.repository.StocksRepository;
import com.eazybytes.stocks.service.IStocksService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class StocksServiceImpl implements IStocksService {

    private final StocksRepository stocksRepository;

    @Override
    public StockDto createStock(StockDto stockDto) {
        if (stocksRepository.findByCustomerNumber(stockDto.getCustomerNumber()).isPresent()) {
            throw new StockAlreadyExistsException("Stock already registered with given customer number " +
                    stockDto.getCustomerNumber());
        }
        stockDto.setStockNumber(String.valueOf(100000000 + new Random().nextInt(900000000)));
        Stock stock = stocksRepository.save(StockMapper.mapToStock(stockDto));
        return StockMapper.mapToStockDto(stock);
    }

    @Override
    public StockDto fetchStock(String customerNumber) {
        Stock stock = stocksRepository.findByCustomerNumber(customerNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Stock", "customerNumber", customerNumber));
        return StockMapper.mapToStockDto(stock);
    }

    @Override
    public StockDto updateStock(StockDto stockDto) {
        Stock stock = stocksRepository.findByStockNumber(stockDto.getStockNumber())
                .orElseThrow(() -> new ResourceNotFoundException("Stock", "stockNumber", stockDto.getStockNumber()));
        Stock updatedStock = StockMapper.mapToStock(stockDto);
        updatedStock.setId(stock.getId());
        return StockMapper.mapToStockDto(stocksRepository.save(updatedStock));
    }

    @Override
    public void deleteStock(String customerNumber) {
        Stock stock = stocksRepository.findByCustomerNumber(customerNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Stock", "customerNumber", customerNumber));
        stocksRepository.deleteById(stock.getId());
    }
}
