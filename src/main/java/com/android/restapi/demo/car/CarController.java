package com.android.restapi.demo.car;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("car")
@CrossOrigin(origins = "http://localhost:4200")
public class CarController {

    private final CarService carService;
    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping
    public List<CarDTO> getAllVaccines(){
        return carService.findAll();
    }

}
