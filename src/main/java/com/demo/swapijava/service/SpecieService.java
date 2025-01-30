package com.demo.swapijava.service;

import com.demo.swapijava.service.models.species.SpecieResponseAll;
import com.demo.swapijava.service.models.species.SpecieResponseById;

public interface SpecieService {

    SpecieResponseAll findAll();

    SpecieResponseById findById(Long id);
}
