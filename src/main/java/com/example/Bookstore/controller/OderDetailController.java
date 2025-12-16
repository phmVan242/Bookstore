package com.example.Bookstore.controller;

import com.example.Bookstore.model.OrderDetail;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-details")
public class OderDetailController {
    private final OrderDetailService orderDetailService;

    public OderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    //Lấy tất cả order
    @GetMapping
    public List<OrderDetail> getAllOrders(){
        return orderDetailService.getAllOrderDetails();
    }

    @GetMapping("/{id}")
    public OrderDetail getOrderDetailById(@PathVariable long id){
        return orderDetailService.getOrderDetailById(id);
    }

    @PostMapping
    public OrderDetail createOrderDetail(@RequestBody OrderDetail order){
        return orderDetailService.createOrderDetail(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderDetail(@PathVariable long id){
        orderDetailService.deleteOrderDetail(id);
    }

    @PutMapping("/{id}")
    public OrderDetail updateOrderDetail(@PathVariable long id, @RequestBody OrderDetail order){
        return orderDetailService.updateOrderDetail(id, order);
    }
}


