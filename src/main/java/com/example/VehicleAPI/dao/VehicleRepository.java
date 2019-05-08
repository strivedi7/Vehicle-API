package com.example.VehicleAPI.dao;

import com.example.VehicleAPI.model.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//Using JPA for management of database
public interface VehicleRepository extends CrudRepository<Vehicle , Integer> {

    List<Vehicle> findAllByMakeIgnoreCase(String make);
}
