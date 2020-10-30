package com.greenfoxacademy.gftakout.controllers;

import com.greenfoxacademy.gftakout.models.Orders;
import com.greenfoxacademy.gftakout.services.OrdersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainRestController {

  @Autowired
  OrdersServiceImpl ordersService;

  @PatchMapping(path = "/api/orders/{orderId}")
  public ResponseEntity changeStatus(@PathVariable long orderId, @RequestBody Orders order) {
    if (!(ordersService.existsById(orderId) || order.getStatus().equals("ordered") || order.getStatus().equals("inprogress") || order.getStatus().equals("done"))) {
      return ResponseEntity.badRequest().build();
    }
    Orders orders = ordersService.findById(orderId);
    orders.setStatus(order.getStatus());
    ordersService.saveOrder(orders);
    return ResponseEntity.ok().build();
  }

  @GetMapping(path = "/api/orders")
  public Object getSpecifiedOrders(@RequestParam(name = "type") String type,
                                   @RequestParam(name = "status") String status) {
    if (!(type.equals("all") || type.equals("vegetarian") || status.equals("ordered") || status.equals("inprogress") || status.equals("done")) || type.isEmpty() || status.isEmpty()) {
      return ResponseEntity.badRequest().build();
    }
    return ordersService.findByTypeAndStatus(type, status);
  }
}
