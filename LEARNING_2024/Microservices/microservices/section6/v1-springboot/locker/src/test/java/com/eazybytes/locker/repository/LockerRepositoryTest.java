package com.eazybytes.locker.repository;

import com.eazybytes.locker.model.Locker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class LockerRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private LockerRepository lockerRepository;

    @Test
    public void testFindByCustomerNumber_ExistingCustomer() {
        Locker locker = new Locker(1L, 1234567L, "Test Locker", "123 Main St", null);
        entityManager.persist(locker);
        entityManager.flush();

        Optional<Locker> result = lockerRepository.findByCustomerNumber(1234567L);

        assertTrue(result.isPresent());
        assertEquals(1234567L, result.get().getCustomerNumber());
    }

    // Add more test methods for other repository scenarios
}  
