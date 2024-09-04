package com.eazybytes.stocks.mapper;

import com.eazybytes.stocks.dto.StockDto;
import com.eazybytes.stocks.entity.Stock;

public class StockMapper {

    public static StockDto mapToStockDto(Stock stock) {
        StockDto stockDto = new StockDto();
        stockDto.setCustomerNumber(stock.getCustomerNumber());
        stockDto.setStockNumber(stock.getStockNumber());
        stockDto.setStockType(stock.getStockType());
        stockDto.setStatus(stock.getStatus());
        return stockDto;
    }

    public static Stock mapToStock(StockDto stockDto) {
        Stock stock = new Stock();
        stock.setCustomerNumber(stockDto.getCustomerNumber());
        stock.setStockNumber(stockDto.getStockNumber());
        stock.setStockType(stockDto.getStockType());
        stock.setStatus(stockDto.getStatus());
        return stock;
    }
}
