package com.demo.swapijava.service;

import com.demo.swapijava.entities.vehicle.VehicleResponseAll;
import com.demo.swapijava.entities.vehicle.VehicleResponseById;

public interface VehicleService {

    VehicleResponseAll findAll();
    VehicleResponseById findById(Long id);
}
