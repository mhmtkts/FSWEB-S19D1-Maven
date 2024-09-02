package com.workintech.s18d2.repository;

import com.workintech.s18d2.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable, Long> {

    @Query("SELECT v FROM Vegetable as v WHERE v.price = :price ORDER BY v.price ASC")
    List<Vegetable> getByPriceAsc();

    @Query("SELECT v FROM Vegetable as v WHERE v.price = :price ORDER BY v.price desc ")
    List<Vegetable> getByPriceDesc();

    @Query("SELECT v FROM Vegetable v WHERE v.name ilike %:name%")
    List<Vegetable> searchByName(String name);
}
