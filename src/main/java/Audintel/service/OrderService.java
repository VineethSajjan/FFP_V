package Audintel.service;

import Audintel.dao.Order;
import Audintel.repository.OrderRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository repo;

    public Order saveOrder(Order order) {
        return repo.save(order);
    }

    public Order updateOrder(Order newObj) {
        Order oldObj = getOrderById(newObj.getOrderId());
        oldObj.setStoreId(newObj.getStoreId());
        oldObj.setMember(newObj.getMember());
        oldObj.setCost(newObj.getCost());
        oldObj.setDate(newObj.getDate());
        oldObj.setStatus(newObj.getStatus());
        repo.save(oldObj);
        return oldObj;
    }

    public Order patchOrder(Order newObj) {
        Order oldObj = getOrderById(newObj.getOrderId());
        if (!Objects.equals(newObj.getStoreId(), oldObj.getStoreId()))
            oldObj.setStoreId(newObj.getStoreId());
        if (!Objects.equals(newObj.getMember(), oldObj.getMember()))
            oldObj.setMember(newObj.getMember());
        if (!Objects.equals(newObj.getCost(), oldObj.getCost()))
            oldObj.setCost(newObj.getCost());
        if (!Objects.equals(newObj.getDate(), oldObj.getDate()))
            oldObj.setDate(newObj.getDate());
        if (!Objects.equals(newObj.getStatus(), oldObj.getStatus()))
            oldObj.setStatus(newObj.getStatus());
        repo.save(oldObj);
        return oldObj;
    }
    public Order getOrderById(Integer id) {
        Optional<Order> order = repo.findById(id);
        return order.orElse(null);
    }

    public void deleteOrder(Integer id) {
        Order order = getOrderById(id);
        repo.delete(order);
    }

    public List<Order> getAllOrders() {
        return (List<Order>) repo.findAll();
    }

    public String findAll() {
        List<Order> dlist = (List<Order>) repo.findAll();
        StringBuilder json = new StringBuilder();
        System.out.println(dlist);
        for(Order d: dlist){
            //System.out.println(d.getDest_Id());
            Gson g = new Gson();
            json.append(g.toJson(d)).append("\n");
        }
        return json.toString();
    }

}

