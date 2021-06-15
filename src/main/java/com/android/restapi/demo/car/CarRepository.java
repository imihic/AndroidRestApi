package com.android.restapi.demo.car;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository {
    List<Car> findAll();
}
