package com.greenfoxacademy.gftakout.repositories;

import com.greenfoxacademy.gftakout.models.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepositories extends CrudRepository<Orders, Long> {
  Orders findById(long id);

  boolean existsById(long id);
}
