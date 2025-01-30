package com.demo.swapijava.service.models.film;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {

    @JsonProperty("properties")
    public Properties properties;

    @JsonProperty("description")
    public String description;
}
