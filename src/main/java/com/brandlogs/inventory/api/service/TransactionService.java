package com.brandlogs.inventory.api.service;

import com.brandlogs.inventory.api.model.Transaction;
import com.brandlogs.inventory.api.model.TransactionDetail;
import com.brandlogs.inventory.api.repository.TransactionDetailRepository;
import com.brandlogs.inventory.api.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    @Autowired
    private TransactionDetailRepository transactionDetailRepository;

    public Transaction create(Transaction transaction) {
        return repository.save(transaction);
    }

    private Optional<Transaction> findById(Long id) {
        return repository.findById(id);
    }

    public List<TransactionDetail> findTransactionDetailsById(Long id) {
        return this.findById(id)
                .map(transaction -> transactionDetailRepository.findByTransactionId(transaction.getId()))
                .orElseGet(ArrayList::new);
    }

    public List<TransactionDetail> findAll() {
        return transactionDetailRepository.findAll();
    }

    public List<TransactionDetail> queryStockTransactionsByType(Transaction.TransactionTypeEnum type, boolean vendor, LocalDate from,
                                                                LocalDate to, String source, String target) {
        List<Transaction> transactions = repository.findTransactionDetailsByType(type,vendor,from,to,source,target);
        List<TransactionDetail> transactionDetails = new ArrayList<>();
        transactions.forEach(t -> transactionDetails.addAll(transactionDetailRepository.findByTransactionId(t.getId())));
        return transactionDetails;
    }

    public List<TransactionDetail> queryStockTransactionsByDate(LocalDate since, LocalDate now) {
        return new ArrayList<>();
    }
}
