package com.demo.swapijava.entities.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PeopleResponseById {

    public String message;

    @JsonProperty("result")
    public Result result;
}
