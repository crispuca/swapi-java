package com.demo.swapijava.entities.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Result {


    @JsonProperty("properties")
    public Properties properties;

    @JsonProperty("description")
    public String description;
}
