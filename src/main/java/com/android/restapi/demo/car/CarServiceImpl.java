package com.android.restapi.demo.car;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService{
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    private CarDTO mapCarToDTO(Car car){
        return new CarDTO(car.getMake(), car.getModel(), car.getDateYear(), car.getImage());
    }

    @Override
    public List<CarDTO> findAll() {
        return carRepository.findAll().stream().map(this::mapCarToDTO).collect(Collectors.toList());
    }
}
