package web.service;

import web.model.Car;

import java.util.List;

public interface CarService {
    Car getCar(int id);
    List<Car> getAllCars();
    void saveCar(Car car);
    void deleteCar(int id);

}
