package Audintel.controller;

import Audintel.dao.Destination;
import Audintel.dao.OrderDetail;
import Audintel.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/OrderDetails")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping("/save")
    public OrderDetail saveOrderDetail(@RequestBody OrderDetail orderDetail) {
        return orderDetailService.saveOrderDetail(orderDetail);
    }

    @PutMapping("/update")
    public OrderDetail updateOrderDetail(@RequestBody OrderDetail orderDetail) {
        return orderDetailService.updateOrderDetail(orderDetail);
    }

    @GetMapping("/list")
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailService.getAllOrderDetails();
    }
    @PatchMapping ("/patch")
    public OrderDetail patch(@RequestBody OrderDetail dest){
        return  orderDetailService.patchOrderDetail(dest);
    }
    @GetMapping("/{id}")
    public OrderDetail getOrderDetailById(@PathVariable Integer id) {
        return orderDetailService.getOrderDetailById(id);
    }
    @GetMapping("/findAll")
    public String findAll(){
        return orderDetailService.findAll();
    }
    @DeleteMapping("/delete/{id}")
    public void deleteOrderDetail(@PathVariable Integer id) {
        orderDetailService.deleteOrderDetail(id);
    }
}
