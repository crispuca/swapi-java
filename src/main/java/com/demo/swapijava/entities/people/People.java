package com.demo.swapijava.entities.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Data
@Getter
@Setter
public class People implements Serializable {

    @JsonProperty("name")
    public String name;

    @JsonProperty("birth_year")
    public String birthYear;

    public String gender;

    @JsonProperty("eye_color")
    public String eyeColor;

    @JsonProperty("hair_color")
    public String hairColor;

    public String height;

    public String mass;

    @JsonProperty("skin_color")
    public String skinColor;

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

    private String homeworld;
    public String created;

    public String edited;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Properties that = (Properties) o;
        return Objects.equals(height, that.height) &&
                Objects.equals(mass, that.mass) &&
                Objects.equals(hairColor, that.hairColor) &&
                Objects.equals(skinColor, that.skinColor) &&
                Objects.equals(eyeColor, that.eyeColor) &&
                Objects.equals(birthYear, that.birthYear) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(created, that.created) &&
                Objects.equals(edited, that.edited) &&
                Objects.equals(name, that.name) &&
                Objects.equals(homeworld, that.getHomeworld()) &&
                Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, mass, hairColor, skinColor, eyeColor, birthYear, gender, created, edited, name, homeworld, url);
    }

}
