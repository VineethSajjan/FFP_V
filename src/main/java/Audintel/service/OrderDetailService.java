package Audintel.service;

import Audintel.dao.OrderDetail;
import Audintel.repository.OrderDetailRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public OrderDetail saveOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    public OrderDetail updateOrderDetail(OrderDetail newObj) {
        OrderDetail oldObj = getOrderDetailById(newObj.getId());
        oldObj.setOrder(newObj.getOrder());
        oldObj.setQuantity(newObj.getQuantity());
        oldObj.setPrice(newObj.getPrice());
        oldObj.setItemName(newObj.getItemName());
        oldObj.setDate(newObj.getDate());
        orderDetailRepository.save(oldObj);
        return oldObj;
    }

    public OrderDetail getOrderDetailById(Integer id) {
        Optional<OrderDetail> orderDetail = orderDetailRepository.findById(id);
        return orderDetail.orElse(null);
    }

    public void deleteOrderDetail(Integer id) {
        OrderDetail orderDetail = getOrderDetailById(id);
        orderDetailRepository.delete(orderDetail);
    }

    public List<OrderDetail> getAllOrderDetails() {
        return (List<OrderDetail>) orderDetailRepository.findAll();
    }

    public OrderDetail patchOrderDetail(OrderDetail newObj) {
        OrderDetail oldObj = getOrderDetailById(newObj.getId());
        if(!Objects.equals(newObj.getOrder(), oldObj.getOrder()))
            oldObj.setOrder(newObj.getOrder());
        if(!Objects.equals(newObj.getDate(), oldObj.getDate()))
            oldObj.setDate(newObj.getDate());
        if(!Objects.equals(newObj.getItemName(), oldObj.getItemName()))
            oldObj.setItemName(newObj.getItemName());
        if(!Objects.equals(newObj.getPrice(), oldObj.getPrice()))
            oldObj.setPrice(newObj.getPrice());
        if(!Objects.equals(newObj.getQuantity(), oldObj.getQuantity()))
            oldObj.setQuantity(newObj.getQuantity());
        orderDetailRepository.save(oldObj);
        return oldObj;
    }

    public String findAll() {
        List<OrderDetail> dlist = (List<OrderDetail>) orderDetailRepository.findAll();
        StringBuilder json = new StringBuilder();
        System.out.println(dlist);
        for(OrderDetail d: dlist){
            //System.out.println(d.getDest_Id());
            Gson g = new Gson();
            json.append(g.toJson(d)).append("\n");
        }
        return json.toString();
    }
}

