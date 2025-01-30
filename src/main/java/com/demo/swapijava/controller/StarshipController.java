package com.demo.swapijava.controller;

import com.demo.swapijava.service.StarshipService;
import com.demo.swapijava.entities.starship.StarshipResponseAll;
import com.demo.swapijava.entities.starship.StarshipResponseById;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("swapi/starships")
public class StarshipController {

    private final StarshipService starshipService;

    public StarshipController(StarshipService starshipService) {
        this.starshipService = starshipService;
    }

    @GetMapping
    public StarshipResponseAll findAll() {
        return this.starshipService.findAll();
    }

    @GetMapping("/{id}")
    public StarshipResponseById findById(@PathVariable("id") long id){return this.starshipService.findById(id);}

}
