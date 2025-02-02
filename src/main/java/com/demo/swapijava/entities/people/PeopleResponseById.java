package com.demo.swapijava.entities.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


@Getter
@Setter
public class PeopleResponseById {

    public String message;

    @JsonProperty("result")
    public Result result;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeopleResponseById that = (PeopleResponseById) o;
        return Objects.equals(message, that.message) &&
                Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, result);
    }

}
