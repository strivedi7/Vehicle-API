package com.example.VehicleAPI.controller;


import com.example.VehicleAPI.model.Vehicle;
import com.example.VehicleAPI.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping("/api/v1/vehicle")
@RestController
public class VehicleController {
    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping(path = "{id}")
    public Vehicle getVehicleById(@PathVariable int id){
        return vehicleService.getVehicle(id).orElse(null);
    }

    //Allowing to optional filter using make
    @GetMapping
    public List<Vehicle> getVehiclesByMake(@RequestParam(value = "make" , required = false) String make){
        if(make == null) return getAllVehicles();
        return vehicleService.getVehiclesByMake(make);
    }

    public List<Vehicle> getAllVehicles(){
        return vehicleService.getVehicles();
    }

    @PostMapping
    public Vehicle insertVehicle(@Valid @RequestBody Vehicle vehicle){
        return vehicleService.addVehicle(vehicle);
    }

    @PutMapping
    public void updateVehicle(@Valid @RequestBody Vehicle vehicle){
        vehicleService.updateVehicle(vehicle);
    }

    @DeleteMapping(path = "{id}")
    public void deleteVehicleByID(@PathVariable int id){
        vehicleService.deleteVehicleByID(id);
    }


}
