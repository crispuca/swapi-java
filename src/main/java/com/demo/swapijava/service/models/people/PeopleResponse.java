package com.demo.swapijava.service.models.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


@Data
public class PeopleResponse {
    public String status;

    @JsonProperty("results")
    public List<People> people;
}
