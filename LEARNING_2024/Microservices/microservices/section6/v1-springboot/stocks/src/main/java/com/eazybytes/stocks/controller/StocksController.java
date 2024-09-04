package com.eazybytes.stocks.controller;

import com.eazybytes.stocks.dto.StockDto;
import com.eazybytes.stocks.service.IStocksService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stocks")
@Validated
@AllArgsConstructor
public class StocksController {

    private final IStocksService stocksService;

    @PostMapping("/create")
    public ResponseEntity<StockDto> createStock(@Valid @RequestBody StockDto stockDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(stocksService.createStock(stockDto));
    }

    @GetMapping("/fetch")
    public ResponseEntity<StockDto> fetchStock(@RequestParam
                                               @Pattern(regexp = "(^$|[0-9]{10})", message = "Customer number must be 10 digits")
                                               String customerNumber) {
        return ResponseEntity.ok(stocksService.fetchStock(customerNumber));
    }

    @PutMapping("/update")
    public ResponseEntity<StockDto> updateStock(@Valid @RequestBody StockDto stockDto) {
        return ResponseEntity.ok(stocksService.updateStock(stockDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteStock(@RequestParam
                                            @Pattern(regexp = "(^$|[0-9]{10})", message = "Customer number must be 10 digits")
                                            String customerNumber) {
        stocksService.deleteStock(customerNumber);
        return ResponseEntity.noContent().build();
    }

}
