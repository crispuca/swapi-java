package com.demo.swapijava.entities.vehicle;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class VehicleResponseAll {

    public String status;

    @JsonProperty("results")
    public List<Vehicle> vehicles;

}
