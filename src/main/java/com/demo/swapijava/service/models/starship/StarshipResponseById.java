package com.demo.swapijava.service.models.starship;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StarshipResponseById {

    public String message;

    @JsonProperty("result")
    public Result result;

}
