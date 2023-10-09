package com.example.springtask.entity.dto;

import com.example.springtask.entity.planet.PlanetType;

public record PlanetDto(
        Long id,
        String name,
        double diameter,
        double radius,
        double distanceFromStar,
        PlanetType planetType,
        int numberOfSatellites,
        String starName
) {
}
