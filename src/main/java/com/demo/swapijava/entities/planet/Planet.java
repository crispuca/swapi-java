package com.demo.swapijava.entities.planet;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class Planet implements Serializable {

    @JsonProperty("name")
    public String name;

    @JsonProperty("diameter")
    public String diameter;

    @JsonProperty("rotation_period")
    public String rotationPeriod;

    @JsonProperty("orbital_period")
    public String orbitalPeriod;

    @JsonProperty("gravity")
    public String gravity;

    @JsonProperty("population")
    public String population;

    @JsonProperty("climate")
    public String climate;

    @JsonProperty("terrain")
    public String terrain;

    @JsonProperty("surface_water")
    public String surfaceWater;

    @JsonProperty("residents")
    public List<String> residentsUrls;

    @JsonProperty("films")
    public List<String> filmsUrls;

    @JsonProperty("url")
    public String url;

    @JsonProperty("created")
    public String created;

    @JsonProperty("edited")
    public String edited;

}
