package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name= "Fruit", schema = "fsweb")
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "name")
    @NotNull
    @Size(min = 2, max = 50)
    private String name;

    @Column( name = "price")
    @DecimalMin("10")
    private Double price;

    @Column(name = "fruit_type")
    @NotNull
    @Enumerated(EnumType.STRING)
    private FruitType fruitType;


}
