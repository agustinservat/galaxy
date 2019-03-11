package com.galaxia.galaxia.services;

import com.galaxia.galaxia.models.SolarSystem;
import com.galaxia.galaxia.models.Weather;
import com.galaxia.galaxia.repositories.GalaxyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Service
public class GalaxyService {

    @Autowired
    private GalaxyRepository galaxyRepository;

    private static final SolarSystem solarSystem = new SolarSystem();


    public Weather getWeatherByDay(Integer day){
        Weather weather = galaxyRepository.findByDay(day);
        if(weather == null){
            weather = solarSystem.getWeather(day);
            this.saveWeather(weather);
        }
        return weather;
    }

    public Weather saveWeather(Weather weather){
        return galaxyRepository.save(weather);
    }

    public List<Weather> getAllWeather(){
        return galaxyRepository.findAll();
    }

    public HashMap<String, Integer> getWeatherBetweenDates(LocalDate start, LocalDate end){
        LocalDate currentStart=LocalDate.from(start);
        LocalDate currentEnd=LocalDate.from(end.plusDays(1));//end is inclusive
        Integer count = 0;
        HashMap<String, Integer> program = new HashMap<String, Integer>();
        do{
            count += 1;
            Weather weather = solarSystem.getWeather(count);

            int repeat = program.containsKey(weather.getStatus()) ? program.get(weather.getStatus()) : 0;
            program.put(weather.getStatus(), repeat + 1);

            currentStart=currentStart.plusDays(1);
        }while (!currentStart.equals(currentEnd));

        program.put("Último pico máximo de lluvia se dio en el día", SolarSystem.getPerimeter());

        return program;
    }
}
