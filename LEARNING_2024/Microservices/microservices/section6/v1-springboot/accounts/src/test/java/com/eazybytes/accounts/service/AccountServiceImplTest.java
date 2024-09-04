package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.AccountsDto;
import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.entity.Customer;
import com.eazybytes.accounts.repository.AccountsRepository;
import com.eazybytes.accounts.repository.CustomerRepository;
import com.eazybytes.accounts.service.impl.AccountsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountsServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private AccountsRepository accountsRepository;

    private AccountsServiceImpl accountsService;

    @BeforeEach
    void setUp() {
        accountsService = new AccountsServiceImpl(accountsRepository, customerRepository);
    }

    @Test
    void createAccount_NewCustomer_ShouldCreateAccount() {
        // Arrange
        CustomerDto customerDto = new CustomerDto("John Doe", "1234567890");
        when(customerRepository.findByMobileNumber(customerDto.getMobileNumber())).thenReturn(Optional.empty());

        // Act
        accountsService.createAccount(customerDto);

        // Assert
        verify(customerRepository, times(1)).save(any(Customer.class));
        verify(accountsRepository, times(1)).save(any());
    }

    @Test
    void createAccount_ExistingCustomer_ShouldThrowException() {
        // Arrange
        CustomerDto customerDto = new CustomerDto("John Doe", "1234567890");
        Customer existingCustomer = new Customer("John Doe", "1234567890");

        // Act & Assert
        assertThrows(CustomerAlreadyExistsException.class, () -> accountsService.createAccount(customerDto));
        verify(customerRepository, never()).save(any(Customer.class));
        verify(accountsRepository, never()).save(any());
    }
}
