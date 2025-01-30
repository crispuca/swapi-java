package com.demo.swapijava.service;

import com.demo.swapijava.entities.starship.StarshipResponseAll;
import com.demo.swapijava.entities.starship.StarshipResponseById;

public interface StarshipService {

    StarshipResponseAll findAll();

    StarshipResponseById findById(Long id);
}
