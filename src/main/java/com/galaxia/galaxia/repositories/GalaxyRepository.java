package com.galaxia.galaxia.repositories;

import com.galaxia.galaxia.models.Weather;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Configuration
public interface GalaxyRepository extends JpaRepository<Weather, Integer> {

    Weather findByDay(Integer day);

}
