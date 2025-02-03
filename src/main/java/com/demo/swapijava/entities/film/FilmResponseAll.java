package com.demo.swapijava.entities.film;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class FilmResponseAll {

    public String message;

    @JsonProperty("result")
    public List<Result> result;

}
