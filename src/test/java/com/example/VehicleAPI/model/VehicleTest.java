package com.example.VehicleAPI.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VehicleTest {

    @Autowired
    private Validator validator;

    @Test
    public void nullMakeCheckTest() {
        Vehicle vehicle =  new Vehicle(1999,null,"Civic");
        Set<ConstraintViolation<Vehicle>> violations = validator.validate(vehicle);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void emptyMakeCheckTest() {
        Vehicle vehicle =  new Vehicle(1999," ","Civic");
        Set<ConstraintViolation<Vehicle>> violations = validator.validate(vehicle);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void nullModelCheckTest() {
        Vehicle vehicle =  new Vehicle(1999,"Honda",null);
        Set<ConstraintViolation<Vehicle>> violations = validator.validate(vehicle);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void emptyModelCheckTest() {
        Vehicle vehicle =  new Vehicle(1999,"Honda"," ");
        Set<ConstraintViolation<Vehicle>> violations = validator.validate(vehicle);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void yearCheckTest() {
        Vehicle vehicle =  new Vehicle(1900,"Honda","Civic");
        Set<ConstraintViolation<Vehicle>> violations1 = validator.validate(vehicle);
        assertFalse(violations1.isEmpty());

        vehicle.setYear(3000);
        Set<ConstraintViolation<Vehicle>> violations2 = validator.validate(vehicle);
        assertFalse(violations2.isEmpty());
    }

}