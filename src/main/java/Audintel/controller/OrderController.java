package Audintel.controller;

import Audintel.dao.Order;
import Audintel.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/list")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/save")
    public Order saveOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @PutMapping("/update")
    public Order updateOrder(@RequestBody Order order) {
        return orderService.updateOrder(order);
    }

    @PatchMapping("/patch")
    public Order patchOrder(@RequestBody Order order) {
        return orderService.patchOrder(order);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrder(id);
    }
    public String findAll(){
        return orderService.findAll();
    }
}

