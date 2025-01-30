package com.demo.swapijava.service;

import com.demo.swapijava.service.models.vehicle.VehicleResponseAll;
import com.demo.swapijava.service.models.vehicle.VehicleResponseById;

public interface VehicleService {

    VehicleResponseAll findAll();
    VehicleResponseById findById(Long id);
}
