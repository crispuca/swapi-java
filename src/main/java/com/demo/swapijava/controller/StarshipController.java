package com.demo.swapijava.controller;

import com.demo.swapijava.service.StarshipService;
import com.demo.swapijava.service.models.starship.StarshipResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    public StarshipResponse findAll() {
        return this.starshipService.findAll();
    }

}
