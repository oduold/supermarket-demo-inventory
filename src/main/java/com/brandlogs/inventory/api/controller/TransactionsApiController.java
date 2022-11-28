package com.brandlogs.inventory.api.controller;

import com.brandlogs.inventory.api.interfaces.TransactionsApi;
import com.brandlogs.inventory.api.model.Item;
import com.brandlogs.inventory.api.model.Transaction;
import com.brandlogs.inventory.api.model.TransactionDetail;
import com.brandlogs.inventory.api.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("${openapi.brandlogsSupermarket.base-path:}")
public class TransactionsApiController implements TransactionsApi {

    @Autowired
    private TransactionService service;

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
    public ResponseEntity<Void> addStockTransaction(Transaction.TransactionTypeEnum type,List<TransactionDetail> transactionDetails) {
        Transaction transaction = transactionDetails.get(0).getTransaction();
        //do transactions
        //if vendor_transfer exist in transaction  we know its either return or receive
        //create only one stock transaction transfer
        //else
        //we are doing a release
        //create two stock transaction transfers
        return TransactionsApi.super.addStockTransaction(type, transactionDetails);
    }

    @Override
    public ResponseEntity<List<TransactionDetail>> stockTransaction(Long id) {
        List<TransactionDetail> transactionDetails = service.findTransactionDetailsById(id);
        return ResponseEntity.ok(transactionDetails);
    }

    @Override
    public ResponseEntity<List<Item>> stockTransactionsItems(Transaction.TransactionTypeEnum type, String source,
         String target, LocalDate from, LocalDate to) {
        List<Item> items = new ArrayList<>();
        List<TransactionDetail> transactionDetails;
        if(type == null && source == null && target == null && from == null && to == null) {
            transactionDetails = service.findAll();
        }
        else if ( Objects.equals(type,Transaction.TransactionTypeEnum.returns) ||
                Objects.equals(type,Transaction.TransactionTypeEnum.receipts) ||
                Objects.equals(type, Transaction.TransactionTypeEnum.releases)){
            transactionDetails = service.queryStockTransactionsByType(type, from, to, source, target);
        }
        else if(from != null || to != null) {
            transactionDetails = service.queryStockTransactionsByType(type, from,to, source, target);
        }
        else{
            return ResponseEntity.badRequest().build();
        }
        if(transactionDetails == null) {
            transactionDetails = new ArrayList<>();
        }
        transactionDetails.forEach(td -> items.add(td.getItem()));
        return ResponseEntity.ok(items);
    }
}
