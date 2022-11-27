package com.brandlogs.inventory.api.repository;

import com.brandlogs.inventory.api.model.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDetailRepository extends JpaRepository<TransactionDetail,Long> {
}
