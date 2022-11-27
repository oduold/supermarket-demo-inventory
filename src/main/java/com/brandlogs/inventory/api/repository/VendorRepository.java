package com.brandlogs.inventory.api.repository;

import com.brandlogs.inventory.api.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface VendorRepository extends JpaRepository<Vendor, Long> {
    Vendor findByCode(String code);
}
