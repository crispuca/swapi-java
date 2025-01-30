package com.demo.swapijava.entities.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


@Data
public class PeopleResponseAll {
    public String message;

    @JsonProperty("results")
    public List<People> people;
}
