package com.demo.swapijava.entities.species;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SpecieResponseById {

    public String message;

    @JsonProperty("result")
    public Result result;
}
