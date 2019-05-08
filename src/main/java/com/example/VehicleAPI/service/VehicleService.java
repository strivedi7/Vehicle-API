package com.example.VehicleAPI.service;

import com.example.VehicleAPI.dao.VehicleRepository;
import com.example.VehicleAPI.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getVehicles(){
        List<Vehicle> allVehicles = new ArrayList<>();
        vehicleRepository.findAll().forEach(allVehicles::add);
        return allVehicles;
    }

    public List<Vehicle> getVehiclesByMake(String make){
        return vehicleRepository.findAllByMakeIgnoreCase(make);
    }

    public Optional<Vehicle> getVehicle(int id){
        return vehicleRepository.findById(id);
    }

    public Vehicle addVehicle(Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }

    public void updateVehicle(Vehicle vehicle){
        vehicleRepository.save(vehicle);
    }

    public void deleteVehicleByID(int id){
        vehicleRepository.deleteById(id);
    }



}
