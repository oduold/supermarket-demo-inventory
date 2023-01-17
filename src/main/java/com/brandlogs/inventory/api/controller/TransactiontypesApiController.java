package com.brandlogs.inventory.api.controller;

import com.brandlogs.inventory.api.interfaces.TransactiontypesApi;
import com.brandlogs.inventory.api.model.TransactionType;
import com.brandlogs.inventory.api.service.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("${openapi.brandlogsSupermarket.base-path:}")
public class TransactiontypesApiController implements TransactiontypesApi {

    @Autowired
    private TransactionTypeService service;
    private final NativeWebRequest request;

    @Autowired
    public TransactiontypesApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<TransactionType>> transactionTypes() {
        List<TransactionType> transactionTypes = service.findAll();
        if(transactionTypes.isEmpty()) {
            return TransactiontypesApi.super.transactionTypes();
        }
        return ResponseEntity.ok(transactionTypes);
    }
}
