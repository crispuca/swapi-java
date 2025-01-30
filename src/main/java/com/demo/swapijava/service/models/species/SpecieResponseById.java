package com.demo.swapijava.service.models.species;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SpecieResponseById {

    public String message;

    @JsonProperty("result")
    public Result result;
}
