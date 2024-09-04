package com.eazybytes.stocks.repository;

import com.eazybytes.stocks.entity.Stock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StocksRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StocksRepository stocksRepository;

    @Test
    void findByCustomerNumber_ShouldReturnStock() {
        Stock stock = new Stock();
        stock.setCustomerNumber("C001");
        stock.setStockNumber("S001");
        stock.setStockType("EQUITY");
        stock.setStatus("ACTIVE");
        entityManager.persist(stock);
        entityManager.flush();

        Optional<Stock> found = stocksRepository.findByCustomerNumber("C001");

        assertTrue(found.isPresent());
        assertEquals("C001", found.get().getCustomerNumber());
    }

    @Test
    void findByCustomerNumber_ShouldReturnEmptyWhenNotFound() {
        Optional<Stock> found = stocksRepository.findByCustomerNumber("C002");

        assertFalse(found.isPresent());
    }

    @Test
    void findByStockNumber_ShouldReturnStock() {
        Stock stock = new Stock();
        stock.setCustomerNumber("C001");
        stock.setStockNumber("S001");
        stock.setStockType("EQUITY");
        stock.setStatus("ACTIVE");
        entityManager.persist(stock);
        entityManager.flush();

        Optional<Stock> found = stocksRepository.findByStockNumber("S001");

        assertTrue(found.isPresent());
        assertEquals("S001", found.get().getStockNumber());
    }
}
