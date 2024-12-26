package com.example.order_service.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class OrderProcessingService {

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void processOrder(Runnable orderTask) {
        executorService.submit(orderTask);
    }
}
