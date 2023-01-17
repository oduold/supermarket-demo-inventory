package com.brandlogs.inventory.api.service;

import com.brandlogs.inventory.api.model.Transaction;
import com.brandlogs.inventory.api.model.TransactionDetail;
import com.brandlogs.inventory.api.repository.TransactionDetailRepository;
import com.brandlogs.inventory.api.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    final private TransactionRepository repository;

    final private TransactionDetailRepository transactionDetailRepository;

    public TransactionService(TransactionRepository repository, TransactionDetailRepository transactionDetailRepository) {
        this.repository = repository;
        this.transactionDetailRepository = transactionDetailRepository;
    }

    private Transaction create(Transaction transaction) {
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

    @Transactional
    public void create(Transaction transaction, List<TransactionDetail> transactionDetails) {
        //save transaction
        Transaction newTransaction = this.create(transaction);
        List<TransactionDetail> transactionDetailList = new ArrayList<>(transactionDetails);
        transactionDetailList.forEach(td -> {
            td.setTransaction(newTransaction);
        });
        transactionDetailRepository.saveAll(transactionDetailList);

    }
}
