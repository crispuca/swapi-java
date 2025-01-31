package com.demo.swapijava.controller;

import com.demo.swapijava.service.FilmService;
import com.demo.swapijava.entities.film.FilmResponseAll;
import com.demo.swapijava.entities.film.FilmResponseById;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("swapi/films")
@Tag(name = "Films", description = "Endpoints para la gestión de los Films GetAll y GetById")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public FilmResponseAll findAll() {
        return this.filmService.findAll();
    }

    @GetMapping("/{id}")
    public FilmResponseById findById(@PathVariable("id") long id){return this.filmService.findById(id);}

}
