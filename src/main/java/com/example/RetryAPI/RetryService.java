package com.example.RetryAPI;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryService {
    @Retryable(value = ArithmeticException.class, maxAttempts = 5,backoff=@Backoff(value = 20000))
    public String checkRetry() {
        System.out.println("Kiem tra lai API");
        int i= 0;
        int n = 10/i;
        return "SUCCESS";
    }
    @Recover
    public String getRecoveryAfterRetry() {
        return "API hien tai khong phan hoi!";
    }
}
