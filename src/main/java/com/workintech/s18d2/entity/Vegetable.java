package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name= "Vegetable", schema = "fsweb")
public class Vegetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "name")
    private String name;

    @Column( name = "price")
    private Double price;

    @Column( name = "isGrownOnTree")
    private Boolean isGrownOnTree;


    public void setGrownOnTree(Boolean grownOnTree) {
        isGrownOnTree = grownOnTree;
    }

    public boolean isGrownOnTree() {
        return isGrownOnTree;
    }
}
