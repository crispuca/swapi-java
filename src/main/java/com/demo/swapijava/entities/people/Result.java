package com.demo.swapijava.entities.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return __v == result.__v &&
                Objects.equals(properties, result.properties) &&
                Objects.equals(description, result.description) &&
                Objects.equals(_id, result._id) &&
                Objects.equals(uid, result.uid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(properties, description, _id, uid, __v);
    }
}
