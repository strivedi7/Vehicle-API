package com.example.VehicleAPI.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "vehicle")
public class Vehicle {

    @Id
    @JsonProperty("Id")
    // GenerationType.IDENTITY will allow to have auto-incremented Primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @DecimalMin(value = "1950" , message = "Year should be between 1950 to 2050")
    @DecimalMax(value = "2050",message = "Year should be between 1950 to 2050")
    @JsonProperty("Year")
    private int year;

    @NotBlank(message = "Year must not be blank")
    @JsonProperty("Make")
    private String make;

    @NotBlank(message = "Model must not be blank")
    @JsonProperty("Model")
    private String model;


    public Vehicle(@DecimalMin(value = "1950", message = "Year should be between 1950 to 2050") @DecimalMax(value = "2050", message = "Year should be between 1950 to 2050") int year, @NotBlank(message = "Year must not be blank") String make, @NotBlank(message = "Model must not be blank") String model) {
        this.year = year;
        this.make = make;
        this.model = model;
    }

    public Vehicle(){

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }
}

