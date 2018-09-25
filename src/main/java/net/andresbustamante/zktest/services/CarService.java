package net.andresbustamante.zktest.services;

import net.andresbustamante.zktest.model.Car;

import java.util.List;

public interface CarService {

    /**
     * Retrieve all cars in the catalog.
     * @return all cars
     */
    List<Car> findAll();

    /**
     * search cars according to keyword in model and make.
     * @param keyword for search
     * @return list of car that match the keyword
     */
    List<Car> search(String keyword);
}