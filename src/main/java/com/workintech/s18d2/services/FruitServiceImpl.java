package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.FruitException;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService {

    private FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit getById(Long id) {
        Optional<Fruit> fruitOptional = fruitRepository.findById(id);
        if (fruitOptional.isPresent()) {
            return fruitOptional.get();
        }
        throw new PlantException("Fruit with given id is not exist : " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Fruit> findAll() {
        return fruitRepository.findAll();
    }

    @Override
    public List<Fruit> searchByName(String fruitName) {
        return fruitRepository.searchByName(fruitName.toLowerCase());
    }


    @Override
    public Fruit delete(Long id) {
        Fruit willRemove = getById(id);
        fruitRepository.delete(willRemove);
        return willRemove;
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.getByPriceAsc();
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getByPriceDesc();
    }
}
