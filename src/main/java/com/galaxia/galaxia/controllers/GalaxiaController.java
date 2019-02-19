package com.galaxia.galaxia.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/galaxia")
public class GalaxiaController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Integer getGalaxia(@PathVariable Integer id){
        return id;

    }
}
