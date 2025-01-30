package com.demo.swapijava.entities.starship;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class Starship implements Serializable {

    @JsonProperty("name")
    public String name;

    @JsonProperty("model")
    public String model;

    @JsonProperty("starship_class")
    public String starshipClass;

    @JsonProperty("manufacturer")
    public String manufacturer;

    @JsonProperty("cost_in_credits")
    public String costInCredits;

    @JsonProperty("length")
    public String length;

    @JsonProperty("crew")
    public String crew;

    @JsonProperty("passengers")
    public String passengers;

    @JsonProperty("max_atmosphering_speed")
    public String maxAtmospheringSpeed;

    @JsonProperty("hyperdrive_rating")
    public String hyperdriveRating;

    @JsonProperty("MGLT")
    public String mglt;

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
