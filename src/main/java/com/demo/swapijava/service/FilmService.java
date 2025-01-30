package com.demo.swapijava.service;

import com.demo.swapijava.service.models.film.FilmResponseAll;
import com.demo.swapijava.service.models.film.FilmResponseById;

public interface FilmService {

    FilmResponseAll findAll();

    FilmResponseById findById(Long id);

}
