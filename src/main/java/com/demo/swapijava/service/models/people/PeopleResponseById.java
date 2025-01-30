package com.demo.swapijava.service.models.people;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PeopleResponseById {

    public String message;

    @JsonProperty("result")
    public Result result;
}
