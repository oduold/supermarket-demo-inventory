package com.brandlogs.inventory.api.service;

import com.brandlogs.inventory.api.model.Location;
import com.brandlogs.inventory.api.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public List<Location> findAll() {
        return locationRepository.findAll();
    }
}
