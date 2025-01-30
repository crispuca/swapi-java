package com.demo.swapijava.entities.species;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class Specie implements Serializable {

    @JsonProperty("name")
    public String name;

    @JsonProperty("classification")
    public String classification;

    @JsonProperty("designation")
    public String designation;

    @JsonProperty("average_height")
    public String averageHeight;

    @JsonProperty("average_lifespan")
    public String averageLifespan;

    @JsonProperty("eye_colors")
    public String eyeColors;

    @JsonProperty("hair_colors")
    public String hairColors;

    @JsonProperty("skin_colors")
    public String skinColors;

    @JsonProperty("lenguage")
    public String language;

    @JsonProperty("homeworld")
    public String homeWorld;

    @JsonProperty("people")
    public List<String> peopleUrls;

    @JsonProperty("films")
    public List<String> filmsUrls;

    @JsonProperty("url")
    public String url;

    @JsonProperty("created")
    public String created;

    @JsonProperty("edited")
    public String edited;

}
