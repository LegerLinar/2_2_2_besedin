package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.lang.reflect.AnnotatedWildcardType;
import java.util.ArrayList;
import java.util.List;

@Controller("/cars")
public class CarController {


    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
        carService.saveCar(new Car("BMW", 1995, "Red"));
        carService.saveCar(new Car("Audi", 2016, "Grey"));
        carService.saveCar(new Car("Hyundai", 1990, "Blue"));
        carService.saveCar(new Car("Mercedes", 2009, "Green"));
        carService.saveCar(new Car("Moskvich", 2012, "Blue"));

    }

    @GetMapping("/cars")
    public String showCars(@RequestParam(value = "count", required = false)
                                  Integer count, Model model) {
        List<Car> cars = carService.getAllCars();
        if (count == null || count >= cars.size()) {
            model.addAttribute("cars", cars);
        } else {
            model.addAttribute("cars", cars.subList(0, count));
        }
        return "cars_view";
    }

    }
