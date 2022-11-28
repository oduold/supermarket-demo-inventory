package com.brandlogs.inventory.api.service;

import com.brandlogs.inventory.api.model.Vendor;
import com.brandlogs.inventory.api.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorService {

    @Autowired
    private VendorRepository repository;

    public Vendor create(Vendor vendor) {
        return repository.save(vendor);
    }

    public Vendor findByCode(String code) {
        return repository.findByCode(code);
    }
}
