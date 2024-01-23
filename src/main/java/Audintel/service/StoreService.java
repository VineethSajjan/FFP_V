package Audintel.service;

import Audintel.dao.Store;
import Audintel.repository.StoreRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    StoreRepository repo;

    public Store saveStore(Store store) {
        return repo.save(store);
    }

    public Store updateStore(Store newObj) {
        Store oldObj = getStoreById(newObj.getStoreId());
        if (!Objects.equals(newObj.getStoreName(), oldObj.getStoreName()))
            oldObj.setStoreName(newObj.getStoreName());
        repo.save(oldObj);
        return oldObj;
    }

    public Store patchStore(Store newObj) {
        Store oldObj = getStoreById(newObj.getStoreId());
        if (!Objects.equals(newObj.getStoreName(), oldObj.getStoreName()))
            oldObj.setStoreName(newObj.getStoreName());
        repo.save(oldObj);
        return oldObj;
    }

    public String findAllStores() {
        List<Store> list = (List<Store>) repo.findAll();
        String json = "";
        for (Store s : list) {
            Gson g = new Gson();
            json += g.toJson(s) + "\n";
        }
        return json;
    }

    public Store getStoreById(Integer id) {
        Optional<Store> store = repo.findById(id);
        return store.orElse(null);
    }

    public void deleteStore(Integer id) {
        Store store = getStoreById(id);
        repo.delete(store);
    }

    public List<Store> getAllStores() {
        return (List<Store>) repo.findAll();
    }
}
