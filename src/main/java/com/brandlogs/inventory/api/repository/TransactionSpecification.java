package com.brandlogs.inventory.api.repository;

import com.brandlogs.inventory.api.model.Transaction;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class TransactionSpecification implements Specification<Transaction> {

    @Override
    public Predicate toPredicate(Root<Transaction> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }

    public static Specification<Transaction> hasType(Transaction.TransactionTypeEnum type) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("transactionType"), type);
    }
}
