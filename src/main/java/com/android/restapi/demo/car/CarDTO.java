package com.android.restapi.demo.car;

import lombok.Data;

@Data
public class CarDTO {

    private final String make;
    private final String model;
    private final String dateYear;
    private final String image;
}
