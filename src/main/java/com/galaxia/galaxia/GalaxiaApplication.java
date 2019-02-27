package com.galaxia.galaxia;

import com.galaxia.galaxia.models.Planet;
import com.galaxia.galaxia.models.Point;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class GalaxiaApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(GalaxiaApplication.class);
	}

	public static void main(String[] args) {

		SpringApplication.run(GalaxiaApplication.class, args);

		Planet Ferengi = new Planet("Ferengi", 500, 1, true);
		Planet Vulcano = new Planet("Vulcano", 1000, 5, false);

		Point PositionFerengi = Ferengi.getPoint(365);
		Point PositionVulcano = Vulcano.getPoint(365);

		System.out.println("punto x es: " + PositionFerengi.getX() + " punto y es: " + PositionFerengi.getY());
		System.out.println("punto x es: " + PositionVulcano.getX() + " punto y es: " + PositionVulcano.getY());
	}


}