package com.greenfoxacademy.gftakout.controllers;

import com.greenfoxacademy.gftakout.models.Orders;
import com.greenfoxacademy.gftakout.services.OrdersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

  final
  OrdersServiceImpl ordersService;

  public MainController(OrdersServiceImpl ordersService) {
    this.ordersService = ordersService;
  }

  @GetMapping(path = "/")
  public String orderPage(Model model) {
    model.addAttribute("ordering", new Orders());
    return "ordering";
  }

  @PostMapping(path = "/order")
  public String postOrder(@ModelAttribute Orders order) {
    ordersService.saveOrder(order);
    return "redirect:/order/" + order.getId();
  }

  @GetMapping(path = "/order/{orderId}")
  public Object orderDetails(@PathVariable long orderId, Model model) {
    if (!ordersService.existsById(orderId)) {
      return ResponseEntity.notFound().build();
    }
    Orders order = ordersService.findById(orderId);
    model.addAttribute("order", order);
    return "orderdetails";
  }
}
