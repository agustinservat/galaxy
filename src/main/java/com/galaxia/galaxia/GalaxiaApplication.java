package com.galaxia.galaxia;

import com.galaxia.galaxia.models.Planet;
import com.galaxia.galaxia.models.Point;
import com.galaxia.galaxia.models.SolarSystem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.time.LocalDate;
import java.util.ArrayList;
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

		Point PositionFerengi = Ferengi.getPoint(1);
		Point PositionBetasoide = Betasoide.getPoint(1);
		Point PositionVulcano = Vulcano.getPoint(1);

		System.out.println("El punto es: " + PositionFerengi.getX() + " y el otro es: " + PositionFerengi.getY());
		System.out.println("El punto es: " + PositionVulcano.getX() + " y el otro es: " + PositionVulcano.getY());
		System.out.println("El punto es: " + PositionBetasoide.getX() + " y el otro es: " + PositionBetasoide.getY());

//		Point punto = new Point(0,0);
//		Point p1 = new Point(1,0);
//		Point p2 = new Point(0,1);
//		Point p3 = new Point(-1,1);
//
//		System.out.println("Esta adentro del triangulo si o no: " + solarSystem.pointInTriangle(punto, PositionFerengi, PositionBetasoide, PositionVulcano));

//		System.out.println("El clima esta: " + solarSystem.getWeather(24));
//
		LocalDate start = LocalDate.of(2015, 9, 1);
		LocalDate end = LocalDate.of(2105, 9, 4);
		LocalDate currentStart=LocalDate.from(start);
		LocalDate currentEnd=LocalDate.from(end.plusDays(1));//end is inclusive
		Integer count = 0;
		do{
			// do what you want with currentStart
			//....
			count += 1;
			String result = solarSystem.getWeather(count);
//			System.out.println("Imprimio: " + count);
//			System.out.println("El clima esta: " + solarSystem.getWeather(count));
//			System.out.println("El perimetro es: " + SolarSystem.getPerimeter());
//			System.out.println("-------------------------------------- ");
			currentStart=currentStart.plusDays(1);
		}while (!currentStart.equals(currentEnd));

        System.out.println("El perimetro es: " + SolarSystem.getPerimeter());
	}


}