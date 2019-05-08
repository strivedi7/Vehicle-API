package com.example.VehicleAPI.service;

import com.example.VehicleAPI.dao.VehicleRepository;
import com.example.VehicleAPI.model.Vehicle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VehicleServiceTest {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Before
    public void setUp() {
        Vehicle vehicle = new Vehicle(1999,"Honda","Civic");
        List<Vehicle> list = new ArrayList<>();
        list.add(vehicle);

//        Mockito.when(vehicleRepository.findAllByMakeIgnoreCase("Honda"))
//                .thenReturn(list);
    }

    @Test
    public void getVehicleByIdTest() {
        int id = 13;
        Optional<Vehicle> found = vehicleRepository.findById(id);
        if(found.isPresent())
            assertEquals(found.get().getId() , id);
    }

    @Test
    public void addVehicleTest() {
         Vehicle vehicle =  new Vehicle(1999,"Honda","Civic");
         Vehicle response = vehicleRepository.save(vehicle);
         assertEquals(vehicle.getYear() , response.getYear());
         assertEquals(vehicle.getModel() , response.getModel());
         assertEquals(vehicle.getMake() , response.getMake());
         assertNotNull(response.getId());
    }

    @Test
    public void updateVehicleTest() {
        Vehicle vehicle =  new Vehicle();
        vehicle.setId(13);
        vehicle.setYear(1999);
        vehicle.setMake("Honda");
        vehicle.setModel("Civic");
        vehicleRepository.save(vehicle);

        vehicle.setModel("Accord");
        vehicleRepository.save(vehicle);

        Optional<Vehicle> updated = vehicleRepository.findById(vehicle.getId());
        if(updated.isPresent()){
            assertEquals(updated.get().getModel() , "Accord");
        }
    }


    @Test
    public void deleteVehicleByIDTest() {
        int id = 13;
        vehicleRepository.deleteById(id);
        Optional<Vehicle> found = vehicleRepository.findById(id);
        assertFalse(found.isPresent());

    }

    //    @Test
//    public void getVehicleByMakeTest() {
//        List<Vehicle> list =  vehicleRepository.findAllByMakeIgnoreCase("Honda");
//        assertFalse(list.isEmpty());
//    }
}