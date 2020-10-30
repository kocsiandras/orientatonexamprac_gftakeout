package com.greenfoxacademy.gftakout.services;

import com.greenfoxacademy.gftakout.models.Orders;
import com.greenfoxacademy.gftakout.repositories.OrdersRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

  final
  OrdersRepositories ordersRepositories;

  public OrdersServiceImpl(OrdersRepositories ordersRepositories) {
    this.ordersRepositories = ordersRepositories;
  }

  @Override
  public void saveOrder(Orders order) {
    ordersRepositories.save(order);
  }

  @Override
  public Orders findById(long id) {
    return ordersRepositories.findById(id);
  }

  @Override
  public boolean existsById(long id) {
    return ordersRepositories.existsById(id);
  }


  @Override
  public List<Orders> findByTypeAndStatus(String type, String status) {
    List<Orders> specifiedList = new ArrayList<>();
    List<Orders> ordersList = (List<Orders>) ordersRepositories.findAll();
    for (Orders order : ordersList) {
      if (getType(order).equals(type) && order.getStatus().equals(status)) {
        specifiedList.add(order);
      }
    }
    return specifiedList;
  }

  @Override
  public String getType(Orders orders) {
    if (orders.getTopping().equals("smoked tofu")) {
      return "vegetarian";
    }
    return "all";
  }

  @Override
  public List<Orders> orderList() {
    return (List<Orders>) ordersRepositories.findAll();
  }
}
