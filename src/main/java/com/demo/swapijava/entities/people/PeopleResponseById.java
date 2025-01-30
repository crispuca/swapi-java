package com.demo.swapijava.entities.people;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PeopleResponseById {

    public String message;

    @JsonProperty("result")
    public Result result;
}
