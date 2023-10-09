package com.example.springtask.entity.mapper;

import com.example.springtask.entity.dto.SatelliteDto;
import com.example.springtask.entity.satellite.Satellite;
import org.springframework.stereotype.Component;

@Component
public class SatelliteMapper {

    public SatelliteDto toDto(Satellite satellite) {
        return new SatelliteDto(
                satellite.getId(),
                satellite.getName(),
                satellite.getDiameter(),
                satellite.getDistanceFromParentPlanet(),
                satellite.getComposition(),
                satellite.getPlanetId() != null ? satellite.getPlanetId().getName() : null
        );
    }

    public Satellite toEntity(SatelliteDto satelliteDto) {
        Satellite satellite = new Satellite();
        satellite.setId(satelliteDto.id());
        satellite.setName(satelliteDto.name());
        satellite.setDiameter(satelliteDto.diameter());
        satellite.setDistanceFromParentPlanet(satelliteDto.distanceFromParentPlanet());
        satellite.setComposition(satelliteDto.composition());

        return satellite;
    }
}
