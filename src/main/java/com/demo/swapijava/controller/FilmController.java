package com.demo.swapijava.controller;

import com.demo.swapijava.service.FilmService;
import com.demo.swapijava.service.models.film.FilmResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("swapi/films")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public FilmResponse findAll() {
        return this.filmService.findAll();
    }

}
