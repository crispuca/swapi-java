package com.demo.swapijava.controller;

import com.demo.swapijava.service.PeopleService;
import com.demo.swapijava.entities.people.PeopleResponseAll;
import com.demo.swapijava.entities.people.PeopleResponseById;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("swapi/people")
public class PeopleController {

    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public PeopleResponseAll findAll() {
        return this.peopleService.findAll();
    }


    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public PeopleResponseById findById(@PathVariable("id") long id){return this.peopleService.findById(id);}
}
