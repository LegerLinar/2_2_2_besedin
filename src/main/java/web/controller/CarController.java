package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    }

    @GetMapping("/cars")
    public String getCarsByCount(@RequestParam(value = "count", defaultValue = "0")
                                 Integer count, Model model) {
        List<Car> cars = carService.getCarsByCount(count);
        model.addAttribute("cars", cars);

        return "cars_view";
    }

}
