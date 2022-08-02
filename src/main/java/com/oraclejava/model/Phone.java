package com.oraclejava.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Phone {
    @Id
    private  int id;
    private  String name;
    private  int price;
}
