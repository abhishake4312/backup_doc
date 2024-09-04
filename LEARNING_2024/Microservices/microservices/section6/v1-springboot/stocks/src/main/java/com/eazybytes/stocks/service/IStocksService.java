package com.eazybytes.stocks.service;

import com.eazybytes.stocks.dto.StockDto;

public interface IStocksService {

    StockDto createStock(StockDto stockDto);

    StockDto fetchStock(String customerNumber);

    StockDto updateStock(StockDto stockDto);

    void deleteStock(String customerNumber);
}
