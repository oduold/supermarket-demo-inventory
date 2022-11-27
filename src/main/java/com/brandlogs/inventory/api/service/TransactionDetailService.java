package com.brandlogs.inventory.api.service;

import com.brandlogs.inventory.api.model.Transaction;
import com.brandlogs.inventory.api.model.TransactionDetail;
import com.brandlogs.inventory.api.repository.TransactionDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionDetailService {
    @Autowired
    private TransactionDetailRepository repository;

    @Autowired
    private TransactionService transactionService;

    public List<TransactionDetail> saveAll(Transaction transaction, List<TransactionDetail> transactionDetails) {
        Optional<Transaction> t = Optional.ofNullable(transactionService.findById(transaction.getId()).orElseGet(
                () -> transactionService.create(transaction)
        ));
        t.ifPresent(value -> transactionDetails.forEach(td -> td.setTransaction(value)));
        return repository.saveAll(transactionDetails);
    }
}
