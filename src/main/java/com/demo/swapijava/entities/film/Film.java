package com.demo.swapijava.entities.film;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Film implements Serializable {

    @JsonProperty("title")
    public String title;

    @JsonProperty("episode_id")
    public int episodeId;

    @JsonProperty("opening_crawl")
    public String openingCrawl;

    @JsonProperty("director")
    public String director;

    @JsonProperty("producer")
    public String producer;

    @JsonProperty("release_date")
    public Date releaseDate;

    @JsonProperty("species")
    public List<String> speciesUrls;

    @JsonProperty("starships")
    public List<String> starshipsUrls;

    @JsonProperty("vehicles")
    public List<String> vehiclesUrls;

    @JsonProperty("characters")
    public List<String> charactersUrls;

    @JsonProperty("planets")
    public List<String> planetsUrls;

    @JsonProperty("url")
    public String url;

    @JsonProperty("created")
    public String created;

    @JsonProperty("edited")
    public String edited;

}
