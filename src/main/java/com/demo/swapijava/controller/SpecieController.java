package com.demo.swapijava.controller;

import com.demo.swapijava.service.SpecieService;
import com.demo.swapijava.entities.species.SpecieResponseAll;
import com.demo.swapijava.entities.species.SpecieResponseById;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("swapi/species")
public class SpecieController {

    private final SpecieService specieService;

    public SpecieController(SpecieService specieService) {
        this.specieService = specieService;
    }

    @GetMapping
    public SpecieResponseAll findAll() {
        return this.specieService.findAll();
    }

    @GetMapping("/{id}")
    public SpecieResponseById findById(@PathVariable("id") long id){return this.specieService.findById(id);}
}
