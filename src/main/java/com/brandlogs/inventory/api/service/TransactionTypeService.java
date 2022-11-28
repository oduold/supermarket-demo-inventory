package com.brandlogs.inventory.api.service;

import com.brandlogs.inventory.api.model.TransactionType;
import com.brandlogs.inventory.api.repository.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionTypeService {
    @Autowired
    private TransactionTypeRepository repository;

    public List<TransactionType> findAll() {
        return repository.findAll();
    }
}
