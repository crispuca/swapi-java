package com.demo.swapijava.controller;

import com.demo.swapijava.service.VehicleService;
import com.demo.swapijava.service.models.vehicle.VehicleResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("swapi/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public VehicleResponse findAll() {
        return this.vehicleService.findAll();
    }

}
