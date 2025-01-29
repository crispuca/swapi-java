package com.demo.swapijava.controller;

import com.demo.swapijava.service.SpecieService;
import com.demo.swapijava.service.models.species.SpecieResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("swapi/species")
public class SpecieController {

    private final SpecieService specieService;

    public SpecieController(SpecieService specieService) {
        this.specieService = specieService;
    }

    @GetMapping
    public SpecieResponse findAll() {
        return this.specieService.findAll();
    }

}
