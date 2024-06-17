package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private List<Car> cars = new ArrayList<>();
//    Car car1 = new Car("BMW", 1995, "Red");
//    Car car2 = new Car("Audi", 2016, "Grey");
//    Car car3 = new Car("Hyundai", 1990, "Blue");
//    Car car4 = new Car("Mercedes", 2009, "Green");
//    Car car5 = new Car("Moskvich", 2012, "Blue");

    public CarServiceImpl() {

    }

    @Override
    public Car getCar(int id) {
        if (cars.size() > 0) {
            return cars.get(id);
        } else {
            return null;
        }
    }

    @Override
    public List<Car> getAllCars() {
        return cars;
    }

    @Override
    public void saveCar(Car car) {
        cars.add(car);
    }

    @Override
    public void deleteCar(int id) {
        cars.remove(id);
    }


}
