package com.brandlogs.inventory.api.service;

import com.brandlogs.inventory.api.model.Transaction;
import com.brandlogs.inventory.api.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    public Transaction create(Transaction transaction) {
        return repository.save(transaction);
    }

    public Optional<Transaction> findById(Long id) {
        return repository.findById(id);
    }
}
