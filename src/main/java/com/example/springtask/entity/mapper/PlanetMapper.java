package com.example.springtask.entity.mapper;

import com.example.springtask.entity.dto.PlanetDto;
import com.example.springtask.entity.planet.Planet;

public class PlanetMapper {

    public PlanetDto toDto(Planet planet) {
        return new PlanetDto(
                planet.getId(),
                planet.getName(),
                planet.getDiameter(),
                planet.getRadius(),
                planet.getDistanceFromStar(),
                planet.getPlanetType(),
                planet.getNumberOfSatellites(),
                planet.getStarId() != null ? planet.getStarId().getName() : null
        );
    }

    public Planet toEntity(PlanetDto planetDto) {
        Planet planet = new Planet();
        planet.setId(planetDto.id());
        planet.setName(planetDto.name());
        planet.setDiameter(planetDto.diameter());
        planet.setRadius(planetDto.radius());
        planet.setDistanceFromStar(planetDto.distanceFromStar());
        planet.setPlanetType(planetDto.planetType());
        planet.setNumberOfSatellites(planetDto.numberOfSatellites());

        return planet;
    }
}
