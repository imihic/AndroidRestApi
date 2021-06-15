package com.android.restapi.demo.car;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "car")
@Data
@NoArgsConstructor
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="make")
    private String make;

    @Column(name="model")
    private String model;

    @Column(name="dateYear")
    private String dateYear;

    @Column(name="image")
    private String image;


    public Car(long id, String make, String model, String dateYear, String image) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.dateYear = dateYear;
        this.image = image;
    }
}
