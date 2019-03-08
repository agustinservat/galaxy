package com.galaxia.galaxia.controllers;

import com.galaxia.galaxia.models.Weather;
import com.galaxia.galaxia.repositories.GalaxyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/galaxia")
public class GalaxiaController {

    @Autowired
    GalaxyRepository galaxyRepository;

//    @RequestMapping(value = "/weather", method = RequestMethod.GET)
//    public ResponseEntity<List<Weather>> findAll(){
//        List<Weather> list = galaxyRepository.findAll();
//        return new ResponseEntity<List<Weather>>(galaxyRepository.findAll(), HttpStatus.OK);
//    }

    @RequestMapping(value = "/weather", produces = "application/json", method = RequestMethod.GET)
    public List<Weather> findAll(){
        return galaxyRepository.findAll();
    }

    @RequestMapping(value = "/clima", produces = "application/json", method = RequestMethod.GET)
    public Integer search(@RequestParam Integer day){
        return day;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Integer getGalaxia(@PathVariable Integer id){
        return id;
    }
}
