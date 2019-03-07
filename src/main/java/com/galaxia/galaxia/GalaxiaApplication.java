package com.galaxia.galaxia;

import com.galaxia.galaxia.models.Planet;
import com.galaxia.galaxia.models.Point;
import com.galaxia.galaxia.models.SolarSystem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;

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

		Planet Ferengi = new Planet("Ferengi", 500, 1, true);
		Planet Betasoide = new Planet("Betasoide", 2000, 3, true);
		Planet Vulcano = new Planet("Vulcano", 1000, 5, false);

		List<Planet> planets = new ArrayList<Planet>();
		planets.add(Ferengi);
		planets.add(Vulcano);
		planets.add(Betasoide);
		SolarSystem solarSystem = new SolarSystem(planets);

//		Point PositionFerengi = Ferengi.getPoint(1);
//		Point PositionBetasoide = Betasoide.getPoint(1);
//		Point PositionVulcano = Vulcano.getPoint(1);
//
//		System.out.println("El punto es: " + PositionFerengi.getX() + " y el otro es: " + PositionFerengi.getY());
//		System.out.println("El punto es: " + PositionVulcano.getX() + " y el otro es: " + PositionVulcano.getY());
//		System.out.println("El punto es: " + PositionBetasoide.getX() + " y el otro es: " + PositionBetasoide.getY());

//		Point punto = new Point(0,0);
//		Point p1 = new Point(1,1);
//		Point p2 = new Point(2,2);
//		Point p3 = new Point(3,3);
//
//		System.out.println("Es linea o no: " + solarSystem.isLine(p1, p2, p3));


		LocalDate start = LocalDate.of(2018, 2, 28);
		LocalDate end = LocalDate.of(2028, 2, 28);
		LocalDate currentStart=LocalDate.from(start);
		LocalDate currentEnd=LocalDate.from(end.plusDays(1));//end is inclusive
		Integer count = 0;
        HashMap<String, Integer> program = new HashMap<String, Integer>();
        do{
			count += 1;
			String result = solarSystem.getWeather(count);

            int repeat = program.containsKey(result) ? program.get(result) : 0;
            program.put(result, repeat + 1);

			currentStart=currentStart.plusDays(1);
		}while (!currentStart.equals(currentEnd));


        program.forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v));

        System.out.println("El perimetro es: " + SolarSystem.getPerimeter());
	}


}