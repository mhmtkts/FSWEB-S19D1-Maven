package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;

import java.util.List;

public interface VegetableService {

    Vegetable save(Vegetable vegetable);
    Vegetable getById(Long id);
    List<Vegetable> findAll();
    List<Vegetable> searchByName(String vegetableName);
    Vegetable delete(Long id);
    List<Vegetable> getByPriceAsc();
    List<Vegetable> getByPriceDesc();
}
