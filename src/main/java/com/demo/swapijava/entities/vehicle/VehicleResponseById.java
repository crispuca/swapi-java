package com.demo.swapijava.entities.vehicle;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VehicleResponseById {

    public String message;

    @JsonProperty("result")
    public Result result;
}
