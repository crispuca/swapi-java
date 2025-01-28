package com.demo.swapijava.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Root implements Serializable {

    @JsonProperty("films")
    public String filmsUrl;

    @JsonProperty("people")
    public String peopleUrl;

    @JsonProperty("planets")
    public String planetsUrl;

    @JsonProperty("species")
    public String speciesUrl;

    @JsonProperty("starships")
    public String starshipsUrl;

    @JsonProperty("vehicles")
    public String vehiclesUrl;

}
