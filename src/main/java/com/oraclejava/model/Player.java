package com.oraclejava.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
public class Player {
    @Id
    private int id;
    private String name;
    private int age;
    private int salary;


    //1대 다 구현...
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private Set<Comment> comments;
}
