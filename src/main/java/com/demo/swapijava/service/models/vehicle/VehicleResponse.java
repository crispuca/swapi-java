package com.demo.swapijava.service.models.vehicle;

import com.demo.swapijava.service.models.species.Specie;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class VehicleResponse {

    public String status;

    @JsonProperty("results")
    public List<Vehicle> vehicles;

}
