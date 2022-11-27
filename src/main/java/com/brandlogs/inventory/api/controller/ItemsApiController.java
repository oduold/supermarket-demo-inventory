package com.brandlogs.inventory.api.controller;

import com.brandlogs.inventory.api.interfaces.ItemsApi;
import com.brandlogs.inventory.api.model.Item;
import com.brandlogs.inventory.api.model.Vendor;
import com.brandlogs.inventory.api.service.ItemService;
import com.brandlogs.inventory.api.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class ItemsApiController implements ItemsApi {

    @Autowired
    private ItemService service;

    @Autowired
    private VendorService vendorService;
    private final NativeWebRequest request;

    @Autowired
    public ItemsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<Item> addStockItem(Item item) {
        //create vendor if not exists
        Vendor vendor = vendorService.findByCode(item.getVendor().getCode());
        if(vendor == null) {
            vendor = vendorService.create(item.getVendor());
            if(vendor == null) {
                return ResponseEntity.notFound().build();
            }
        }
        item.setVendor(vendor);
        Item newItem = service.createOrUpdate(null,item);
        if(newItem == null) {
            return ItemsApi.super.addStockItem(item);
        }
        else{
            URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(newItem.getId()).toUri();
            return ResponseEntity.created(uri).body(newItem);
        }
    }

    @Override
    public ResponseEntity<Item> item(Long id) {
        Optional<Item> i = service.findById(id);
        return i.map(ResponseEntity::ok).orElseGet(ResponseEntity.notFound()::build);
    }

    @Override
    public ResponseEntity<List<Item>> stockItems(LocalDate created) {
        List<Item> items =  service.all();
        if(created != null) {
            items = items.stream().filter(i -> i.getCreationDate().isEqual(created)).collect(Collectors.toList());
        }
        return ResponseEntity.ok(items);
    }

    @Override
    public ResponseEntity<Void> itemDelete(Long id) {
        //does item exist
        Optional<Item> item = service.findById(id);
        if(!item.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.remove(id);
        return ResponseEntity.accepted().build();
    }

    @Override
    public ResponseEntity<Item> itemEdit(Long id, Item item) {
        Item u =  service.createOrUpdate(id,item);
        if(u == null) {
            ResponseEntity.notFound().build();
        }
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(u.getId()).toUri();
        return ResponseEntity.created(uri).body(u);
    }
}
