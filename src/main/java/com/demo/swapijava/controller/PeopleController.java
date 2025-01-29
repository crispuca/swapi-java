package com.demo.swapijava.controller;

import com.demo.swapijava.service.PeopleService;
import com.demo.swapijava.service.models.people.PeopleResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("swapi/people")
public class PeopleController {

    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public PeopleResponse findAll() {
        return this.peopleService.findAll();
    }
}
