package com.demo.swapijava.service;

import com.demo.swapijava.entities.species.SpecieResponseAll;
import com.demo.swapijava.entities.species.SpecieResponseById;

public interface SpecieService {

    SpecieResponseAll findAll();

    SpecieResponseById findById(Long id);
}
