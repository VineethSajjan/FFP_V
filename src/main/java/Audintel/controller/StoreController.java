package Audintel.controller;


import Audintel.dao.Store;
import Audintel.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    StoreService storeService;

    @GetMapping("/all")
    public List<Store> getAllStores() {
        return storeService.getAllStores();
    }

    @GetMapping("/{id}")
    public Store getStoreById(@PathVariable Integer id) {
        return storeService.getStoreById(id);
    }

    @PostMapping("/add")
    public Store saveStore(@RequestBody Store store) {
        return storeService.saveStore(store);
    }

    @PutMapping("/update")
    public Store updateStore(@RequestBody Store store) {
        return storeService.updateStore(store);
    }

    @PatchMapping("/patch")
    public Store patchStore(@RequestBody Store store) {
        return storeService.patchStore(store);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStore(@PathVariable Integer id) {
        storeService.deleteStore(id);
    }
}

