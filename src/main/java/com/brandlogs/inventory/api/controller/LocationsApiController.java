package com.brandlogs.inventory.api.controller;


import com.brandlogs.inventory.api.interfaces.LocationsApi;
import com.brandlogs.inventory.api.model.Location;
import com.brandlogs.inventory.api.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("${openapi.brandlogsSupermarket.base-path:}")
public class LocationsApiController implements LocationsApi {

    @Autowired
    private LocationService locationService;

    private final NativeWebRequest request;

    @Autowired
    public LocationsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<Location>> locations() {
        List<Location> locations =  locationService.findAll();
        if(locations.isEmpty()) {
            return LocationsApi.super.locations();
        }
        return ResponseEntity.ok(locations);
    }
}
