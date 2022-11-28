package com.brandlogs.inventory.api.service;

import com.brandlogs.inventory.api.model.Transaction;
import com.brandlogs.inventory.api.model.TransactionDetail;
import com.brandlogs.inventory.api.repository.TransactionDetailRepository;
import com.brandlogs.inventory.api.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionDetailService {
    @Autowired
    private TransactionDetailRepository repository;

    @Autowired
    private TransactionRepository transactionRepository;

    public List<TransactionDetail> saveAll(Transaction transaction, List<TransactionDetail> transactionDetails) {
        Optional<Transaction> t = Optional.of(transactionRepository.findById(transaction.getId()).orElseGet(
                () -> transactionRepository.save(transaction)
        ));
        t.ifPresent(value -> transactionDetails.forEach(td -> td.setTransaction(value)));
        return repository.saveAll(transactionDetails);
    }

    public List<TransactionDetail> findAll() {
        return repository.findAll();
    }
}
