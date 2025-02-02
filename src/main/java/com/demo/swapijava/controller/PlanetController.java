package com.demo.swapijava.controller;

import com.demo.swapijava.service.PlanetService;
import com.demo.swapijava.entities.planet.PlanetResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("swapi/planets")
public class PlanetController {

    private final PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping
    public PlanetResponse findAll() {
        return this.planetService.findAll();
    }

}
