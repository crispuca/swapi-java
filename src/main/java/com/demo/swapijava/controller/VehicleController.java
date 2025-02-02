package com.demo.swapijava.controller;

import com.demo.swapijava.service.VehicleService;
import com.demo.swapijava.entities.vehicle.VehicleResponseAll;
import com.demo.swapijava.entities.vehicle.VehicleResponseById;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public VehicleResponseAll findAll() {
        return this.vehicleService.findAll();
    }


    @GetMapping("/{id}")
    public VehicleResponseById findById(@PathVariable("id") long id){return this.vehicleService.findById(id);}

}
