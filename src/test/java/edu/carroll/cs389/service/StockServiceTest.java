package edu.carroll.cs389.service;

import jakarta.transaction.Transactional;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@Transactional
@SpringBootTest
public class StockServiceTest {

    @Autowired
    private StockServiceImpl stockService;


    @Test
    private void createPositionTest() {
        
    }
}
