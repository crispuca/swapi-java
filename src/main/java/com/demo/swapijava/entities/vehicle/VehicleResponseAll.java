package com.demo.swapijava.entities.vehicle;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class VehicleResponseAll {


    @JsonProperty("message")
    public String message;

    @JsonProperty("results")
    public List<Vehicle> vehicles;

}
