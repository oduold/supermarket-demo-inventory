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
import java.util.concurrent.atomic.AtomicReference;

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
        transaction.setTransactionType(type);
        if(transaction.getVendorTransfer() == null) {
            transaction.setVendorTransfer(false);
        }
        service.create(transaction,transactionDetails);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<TransactionDetail>> stockTransaction(Long id) {
        List<TransactionDetail> transactionDetails = service.findTransactionDetailsById(id);
        return ResponseEntity.ok(transactionDetails);
    }

    @Override
    public ResponseEntity<List<Item>> stockTransactionsItems(Transaction.TransactionTypeEnum type, boolean vendor, String source,
         String target, LocalDate from, LocalDate to) {
        List<Item> items = new ArrayList<>();
        List<TransactionDetail> transactionDetails;
        if(type == null && source == null && target == null && from == null && to == null && !vendor) {
            transactionDetails = service.findAll();
        }
        else if ( Objects.equals(type,Transaction.TransactionTypeEnum.returns) ||
                Objects.equals(type,Transaction.TransactionTypeEnum.receipts) ||
                Objects.equals(type, Transaction.TransactionTypeEnum.releases) ||
                from != null || to != null){
            transactionDetails = service.queryStockTransactionsByType(type, vendor,from, to, source, target);
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
