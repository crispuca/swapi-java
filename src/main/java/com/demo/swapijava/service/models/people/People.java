package com.demo.swapijava.service.models.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class People implements Serializable {

    @JsonProperty("name")
    public String name;

    @JsonProperty("films")
    public List<String> filmsUrls;

    @JsonProperty("species")
    public List<String> speciesUrls;

    @JsonProperty("starships")
    public List<String> starshipsUrls;

    @JsonProperty("vehicles")
    public List<String> vehiclesUrls;

    @JsonProperty("url")
    public String url;

    public String created;

    public String edited;

}
