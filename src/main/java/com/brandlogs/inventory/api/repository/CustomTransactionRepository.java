package com.brandlogs.inventory.api.repository;

import com.brandlogs.inventory.api.model.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface CustomTransactionRepository {
    List<Transaction> findTransactionDetailsByType(Transaction.TransactionTypeEnum type, boolean vendor, LocalDate from,
                                                   LocalDate to, String source, String target);
}
