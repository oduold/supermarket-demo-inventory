package com.brandlogs.inventory.api.controller;

import com.brandlogs.inventory.api.interfaces.TransactionsApi;
import com.brandlogs.inventory.api.model.Transaction;
import com.brandlogs.inventory.api.model.TransactionDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("${openapi.brandlogsSupermarket.base-path:}")
public class TransactionsApiController implements TransactionsApi {

    private final NativeWebRequest request;

    @Autowired
    public TransactionsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<Void> addStockTransaction(List<TransactionDetail> transactionDetails) {
        Transaction transaction = transactionDetails.get(0).getTransaction();
        //do transactions
        //if vendor exist in transaction  we know its either return or receive
        //create only one stock transaction transfer
        //else
        //we are doing a release
        //create two stock transaction transfer
        return TransactionsApi.super.addStockTransaction(transactionDetails);
    }
}
