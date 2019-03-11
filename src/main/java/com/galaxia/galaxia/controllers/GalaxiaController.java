package com.galaxia.galaxia.controllers;

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
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/galaxia")
public class GalaxiaController {

    @Autowired
    GalaxyRepository galaxyRepository;

    @Autowired
    GalaxyService galaxyService;

    @RequestMapping(value = "/all-weather", method = RequestMethod.GET)
    public ResponseEntity<List<Weather>> findAll(){
        List<Weather> weatherList = galaxyRepository.findAll();
        if(weatherList.isEmpty()){
            return new ResponseEntity<List<Weather>>(weatherList, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Weather>>(weatherList, HttpStatus.OK);
    }

    @RequestMapping(value = "/clima", method = RequestMethod.GET)
    public ResponseEntity<Weather> search(@RequestParam Integer dia){
        Weather weather = galaxyService.getWeatherByDay(dia);
        if(weather != null){
            return new ResponseEntity<Weather>(weather, HttpStatus.OK);
        }else{
            return new ResponseEntity<Weather>(weather, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/clima-hasta", method = RequestMethod.GET)
    public ResponseEntity<?>  getWeatherBetweenDates(@RequestParam("to") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate toDate){
        LocalDate now = LocalDate.now();
        if(now.isAfter(toDate)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.TEXT_PLAIN)
                    .body("La fecha ingresada debe ser superior al dia de hoy.");
        }
        try{
            HashMap<String, Integer> result = galaxyService.getWeatherBetweenDates(now, toDate);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(e.getMessage());
        }
    }
}
