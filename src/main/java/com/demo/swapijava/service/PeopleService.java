package com.demo.swapijava.service;

import com.demo.swapijava.service.models.people.PeopleResponseAll;
import com.demo.swapijava.service.models.people.PeopleResponseById;
import com.demo.swapijava.service.models.people.Result;

public interface PeopleService {
    PeopleResponseAll findAll();
    PeopleResponseById findById(Long Id);
}
