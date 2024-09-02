package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.FruitException;
import com.workintech.s18d2.exceptions.VegetableException;
import com.workintech.s18d2.repository.VegetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService {

    private VegetableRepository vegetableRepository;

    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public Vegetable getById(Long id) {
        Optional<Vegetable> vegetableOptional = vegetableRepository.findById(id);
        if (vegetableOptional.isPresent()) {
            return vegetableOptional.get();
        }
        throw new VegetableException("Vegetable with given id is not exist : " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Vegetable> findAll() {
        return vegetableRepository.findAll();
    }

    @Override
    public List<Vegetable> searchByName(String vegetableName) {
        return vegetableRepository.searchByName(vegetableName.toLowerCase());
    }

    @Override
    public Vegetable delete(Long id) {
        Vegetable willRemove = getById(id);
        vegetableRepository.delete(willRemove);
        return willRemove;
    }

    @Override
    public List<Vegetable> getByPriceAsc() {
        return vegetableRepository.getByPriceAsc();
    }

    @Override
    public List<Vegetable> getByPriceDesc() {
        return vegetableRepository.getByPriceDesc();
    }
}
