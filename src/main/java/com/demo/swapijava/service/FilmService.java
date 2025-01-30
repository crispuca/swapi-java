package com.demo.swapijava.service;

import com.demo.swapijava.entities.film.FilmResponseAll;
import com.demo.swapijava.entities.film.FilmResponseById;

public interface FilmService {

    FilmResponseAll findAll();

    FilmResponseById findById(Long id);

}
