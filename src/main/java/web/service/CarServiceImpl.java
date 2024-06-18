package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private List<Car> cars = new ArrayList<>();

    public CarServiceImpl() {
        cars.add(new Car("BMW", 1995, "Red"));
        cars.add(new Car("Audi", 2016, "Grey"));
        cars.add(new Car("Hyundai", 1990, "Blue"));
        cars.add(new Car("Mercedes", 2009, "Green"));
        cars.add(new Car("Moskvich", 2012, "Blue"));

    }

    @Override
    public List<Car> getCarsByCount(int count) {
        if(count < cars.size() && count > 0) {
            return cars.stream().limit(count).collect(Collectors.toList());
        }
        return cars;
    }
}
