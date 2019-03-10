package com.galaxia.galaxia;

import com.galaxia.galaxia.models.Planet;
import com.galaxia.galaxia.models.SolarSystem;
import com.galaxia.galaxia.models.Weather;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class GalaxiaApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(GalaxiaApplication.class);
	}

	public static void main(String[] args) {

		SpringApplication.run(GalaxiaApplication.class, args);

//		Planet Ferengi = new Planet("Ferengi", 500, 1, true);
//		Planet Betasoide = new Planet("Betasoide", 2000, 3, true);
//		Planet Vulcano = new Planet("Vulcano", 1000, 5, false);
//
//		List<Planet> planets = new ArrayList<Planet>();
//		planets.add(Ferengi);
//		planets.add(Vulcano);
//		planets.add(Betasoide);
//		SolarSystem solarSystem = new SolarSystem(planets);
//
//
//		LocalDate start = LocalDate.of(2018, 2, 28);
//		LocalDate end = LocalDate.of(2028, 2, 28);
//		LocalDate currentStart=LocalDate.from(start);
//		LocalDate currentEnd=LocalDate.from(end.plusDays(1));//end is inclusive
//		Integer count = 0;
//        HashMap<String, Integer> program = new HashMap<String, Integer>();
//        do{
//			count += 1;
//			Weather weather = solarSystem.getWeather(count);
//
//			int repeat = program.containsKey(weather.getStatus()) ? program.get(weather.getStatus()) : 0;
//			program.put(weather.getStatus(), repeat + 1);
//
//			currentStart=currentStart.plusDays(1);
//		}while (!currentStart.equals(currentEnd));
//
//
//        program.forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v));
//
//        System.out.println("El perimetro es: " + SolarSystem.getPerimeter());
	}


}