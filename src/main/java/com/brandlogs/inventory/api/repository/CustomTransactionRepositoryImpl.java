package com.brandlogs.inventory.api.repository;

import com.brandlogs.inventory.api.model.Transaction;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomTransactionRepositoryImpl implements CustomTransactionRepository{

    @Autowired
    EntityManager em;

    @Override
    public List<Transaction> findTransactionDetailsByType(Transaction.TransactionTypeEnum type, boolean vendor, LocalDate from,
                                                          LocalDate to, String source, String target) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Transaction> transactionCriteriaQuery = cb.createQuery(Transaction.class);
        Root<Transaction> transactionRoot = transactionCriteriaQuery.from(Transaction.class);
        List<Predicate> predicates = new ArrayList<>();
        if(type != null) {
            predicates.add(cb.equal(transactionRoot.get("transactionType"), type));
            if(source != null) {
                predicates.add(cb.equal(transactionRoot.get("source"), source));
            }
            if(target != null) {
                predicates.add(cb.equal(transactionRoot.get("target"), target));
            }
        }
        if(from != null) {
            predicates.add(cb.greaterThanOrEqualTo(transactionRoot.<LocalDate>get("transactionDate"),cb.literal(from)));
        }
        if (to != null) {
            predicates.add(cb.lessThanOrEqualTo(transactionRoot.<LocalDate>get("transactionDate"),cb.literal(to)));
        }
        if(vendor) {
            predicates.add(cb.equal(transactionRoot.<Boolean>get("vendorTransfer"),true));
        }
        transactionCriteriaQuery.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(transactionCriteriaQuery).getResultList();
    }
}
