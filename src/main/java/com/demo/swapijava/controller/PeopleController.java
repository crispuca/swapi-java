package com.demo.swapijava.controller;

import com.demo.swapijava.service.PeopleService;
import com.demo.swapijava.service.models.people.PeopleResponseAll;
import com.demo.swapijava.service.models.people.PeopleResponseById;
import com.demo.swapijava.service.models.people.Result;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("swapi/people")
public class PeopleController {

    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public PeopleResponseAll findAll() {
        return this.peopleService.findAll();
    }


    @GetMapping("/{id}")
    public PeopleResponseById findById(@PathVariable("id") long id){return this.peopleService.findById(id);}
}
