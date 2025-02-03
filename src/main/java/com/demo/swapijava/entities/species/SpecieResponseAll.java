package com.demo.swapijava.entities.species;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class SpecieResponseAll {

    public String message;

    @JsonProperty("results")
    public List<Specie> species;

}
