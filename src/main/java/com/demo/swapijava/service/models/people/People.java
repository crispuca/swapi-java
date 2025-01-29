package com.demo.swapijava.service.models.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class People implements Serializable {

    @JsonProperty("name")
    public String name;

    @JsonProperty("birth_year")
    public String birthYear;

    @JsonProperty("eye_color")
    public String eyeColor;

    @JsonProperty("gender")
    public String gender;

    @JsonProperty("hair_color")
    public String hairColor;

    @JsonProperty("height")
    public String height;

    @JsonProperty("mass")
    public String mass;

    @JsonProperty("skin_color")
    public String skinColor;

    @JsonProperty("homeworld")
    public String homeWorldUrl;

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

    @JsonProperty("created")
    public String created;

    @JsonProperty("edited")
    public String edited;

}
