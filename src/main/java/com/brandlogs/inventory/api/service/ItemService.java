package com.brandlogs.inventory.api.service;

import com.brandlogs.inventory.api.model.Item;
import com.brandlogs.inventory.api.model.Vendor;
import com.brandlogs.inventory.api.repository.ItemRepository;
import com.brandlogs.inventory.api.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ItemService {
    final private ItemRepository repository;

    final private VendorRepository vendorRepository;

    public ItemService(ItemRepository repository, VendorRepository vendorRepository) {
        this.repository = repository;
        this.vendorRepository = vendorRepository;
    }

    private Item create(Item item) {
        return repository.save(item);
    }

    public List<Item> all() { return repository.findAll(); }

    public Optional<Item> findById(Long id) { return repository.findById(id); }

    public List<Item> findByCreationDate(LocalDate created) {
        return repository.findByCreationDate(created);
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }

    public Item createOrUpdate(Long id, Item item) {
        if(id == null) id = 0L;
        return repository.findById(id).map(ev -> {
            Vendor v = item.getVendor();
            if(v != null && (v.getId() != null && !v.getId().equals(ev.getVendor().getId())) ||
                    ((Objects.requireNonNull(v).getCode() != null && !v.getCode().equals(ev.getVendor().getCode())))) {
                Optional<Vendor> gv;
                if(v.getId() != null && !v.getId().equals(ev.getVendor().getId())) {
                    gv = vendorRepository.findById(v.getId());
                }
                else{
                    gv = Optional.ofNullable(vendorRepository.findByCode(v.getCode()));
                }
                gv.ifPresent(ev::setVendor);
            }
            if(item.getName() != null && !item.getName().equals(ev.getName())) {
                ev.setName(item.getName());
            }
            return repository.save(ev);
        }).orElseGet(() -> this.create(item));
    }
}
