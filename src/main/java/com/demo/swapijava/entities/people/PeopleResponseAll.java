package com.demo.swapijava.entities.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Data
@Getter
@Setter
public class PeopleResponseAll {

    @JsonProperty("message")
    public String message;

    @JsonProperty("results")
    public List<People> people;
}
