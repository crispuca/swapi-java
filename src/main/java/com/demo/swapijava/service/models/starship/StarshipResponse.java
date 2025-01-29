package com.demo.swapijava.service.models.starship;

import com.demo.swapijava.service.models.species.Specie;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class StarshipResponse {

    public String status;

    @JsonProperty("results")
    public List<Starship> starships;

}
