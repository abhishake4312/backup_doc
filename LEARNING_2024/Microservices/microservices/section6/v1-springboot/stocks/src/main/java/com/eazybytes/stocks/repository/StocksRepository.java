package com.eazybytes.stocks.repository;

import com.eazybytes.stocks.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StocksRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findByCustomerNumber(String customerNumber);
    Optional<Stock> findByStockNumber(String stockNumber);
}
