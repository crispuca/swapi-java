package com.demo.swapijava.entities.vehicle;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {

    @JsonProperty("properties")
    public Properties properties;

    @JsonProperty("description")
    public String description;
}
