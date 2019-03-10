package com.galaxia.galaxia.controllers;

import com.galaxia.galaxia.models.SolarSystem;
import com.galaxia.galaxia.models.Weather;
import com.galaxia.galaxia.repositories.GalaxyRepository;
import com.galaxia.galaxia.services.GalaxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/galaxia")
public class GalaxiaController {

    @Autowired
    GalaxyRepository galaxyRepository;

    @Autowired
    GalaxyService galaxyService;

    @RequestMapping(value = "/weather", method = RequestMethod.GET)
    public List<Weather> findAll(){
        return galaxyRepository.findAll();
    }

    @RequestMapping(value = "/clima", method = RequestMethod.GET)
    public Weather search(@RequestParam Integer day){
        return galaxyService.getWeatherByDay(day);
    }

    @RequestMapping(value = "/climaHasta", method = RequestMethod.GET)
    public ResponseEntity<?>  getWeatherBetweenDates(@RequestParam("to") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate toDate){
        LocalDate now = LocalDate.now();
        if(now.isAfter(toDate)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.TEXT_PLAIN)
                    .body("La fecha ingresada debe ser superior al dia de hoy.");
        }
        HashMap<String, Integer> result = galaxyService.getWeatherBetweenDates(now, toDate);
        return ResponseEntity.ok(result);
    }
}
