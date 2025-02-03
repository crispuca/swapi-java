package com.demo.swapijava.entities.vehicle;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Result {

    @JsonProperty("properties")
    public Properties properties;

    @JsonProperty("description")
    public String description;

    private String _id;
    private String uid;
    private int __v;
}
