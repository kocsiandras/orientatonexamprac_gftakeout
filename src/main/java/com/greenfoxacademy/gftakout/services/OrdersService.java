package com.greenfoxacademy.gftakout.services;

import com.greenfoxacademy.gftakout.models.Orders;

import java.util.List;

public interface OrdersService {
  void saveOrder(Orders order);

  Orders findById(long id);

  boolean existsById(long id);

  List<Orders> findByTypeAndStatus(String type, String status);

  String getType(Orders orders);

  List<Orders> orderList();
}
