package com.demo.swapijava.service;

import com.demo.swapijava.entities.people.PeopleResponseAll;
import com.demo.swapijava.entities.people.PeopleResponseById;

public interface PeopleService {
    PeopleResponseAll findAll();
    PeopleResponseById findById(Long Id);
}
