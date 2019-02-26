package com.galaxia.galaxia;

import com.galaxia.galaxia.models.Planeta;
import com.galaxia.galaxia.models.Point;
import javafx.application.Application;
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

		Planeta Ferengi = new Planeta("Ferengi", 500, 1, true);
		Planeta Vulcano = new Planeta("Vulcano", 1000, 5, false);

		Point PositionFerengi = Ferengi.getPoint(5);
		Point PositionVulcano = Vulcano.getPoint(5);

		System.out.println("punto x es: " + PositionFerengi.getX() + " punto y es: " + PositionFerengi.getY());
		System.out.println("punto x es: " + PositionVulcano.getX() + " punto y es: " + PositionVulcano.getY());
	}


}