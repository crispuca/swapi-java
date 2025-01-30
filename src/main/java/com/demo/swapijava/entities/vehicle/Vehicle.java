package com.demo.swapijava.entities.vehicle;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class Vehicle implements Serializable {

    @JsonProperty("name")
    public String name;

    @JsonProperty("model")
    public String model;

    @JsonProperty("vehicle_class")
    public String vehicleClass;

    @JsonProperty("manufacturer")
    public String manufacturer;

    @JsonProperty("length")
    public String length;

    @JsonProperty("cost_in_credits")
    public String costInCredits;

    @JsonProperty("crew")
    public String crew;

    @JsonProperty("passengers")
    public String passengers;

    @JsonProperty("max_atmosphering_speed")
    public String maxAtmospheringSpeed;

    @JsonProperty("cargo_capacity")
    public String cargoCapacity;

    @JsonProperty("consumables")
    public String consumables;

    @JsonProperty("films")
    public List<String> filmsUrls;

    @JsonProperty("pilots")
    public List<String> pilotsUrls;

    @JsonProperty("url")
    public String url;

    @JsonProperty("created")
    public String created;

    @JsonProperty("edited")
    public String edited;

}
