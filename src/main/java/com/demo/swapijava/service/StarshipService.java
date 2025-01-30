package com.demo.swapijava.service;

import com.demo.swapijava.service.models.starship.StarshipResponseAll;
import com.demo.swapijava.service.models.starship.StarshipResponseById;

public interface StarshipService {

    StarshipResponseAll findAll();

    StarshipResponseById findById(Long id);
}
