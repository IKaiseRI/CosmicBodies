package com.example.springtask.repository;

import com.example.springtask.entity.planet.Planet;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends BaseRepository<Planet> {
}
