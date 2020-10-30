package com.greenfoxacademy.gftakout.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

  @Id
  @GeneratedValue
  private long id;

  @Column
  private String name;

  @Column
  private String address;

  @Column
  private String base;

  @Column
  private String topping;

  @Column
  private String status = "ordered";
}
