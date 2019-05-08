package com.example.VehicleAPI.controller;

import com.example.VehicleAPI.dao.VehicleRepository;
import com.example.VehicleAPI.model.Vehicle;
import com.example.VehicleAPI.service.VehicleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VehicleControllerTest {

    @Mock
    private VehicleRepository vehicleRepository;

    @InjectMocks
    private VehicleService vehicleService;

    @Before
    public void setUp() {
        Vehicle vehicle = new Vehicle(1999,"Honda","Civic");
        Vehicle vehicle1 = new Vehicle(2005,"Nishan","Juke");
        Vehicle vehicle2 = new Vehicle(2017,"BMW","X3");
        Vehicle vehicle3 = new Vehicle(2019,"Toyota","Camry");

        List<Vehicle> hondaList = new ArrayList<>();
        hondaList.add(vehicle);

        List<Vehicle> allList = new ArrayList<>(Arrays.asList(vehicle,vehicle1,vehicle2,vehicle3));

        Mockito.when(vehicleRepository.findAllByMakeIgnoreCase("Honda"))
                .thenReturn(hondaList);

        Mockito.when(vehicleRepository.findAll())
                .thenReturn(allList);
    }

    @Test
    public void getVehiclesByMakeTest() {
        List<Vehicle> vehicles  = vehicleService.getVehiclesByMake("Honda");
        assertFalse(vehicles.isEmpty());
    }

    @Test
    public void getAllVehicles() {
        List<Vehicle> vehicles  = vehicleService.getVehicles();
        assertTrue(vehicles.size() == 4 );
    }
}