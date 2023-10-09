package com.example.springtask.entity.dto;

import com.example.springtask.entity.satellite.tipisation.Composition;

public record SatelliteDto(
        Long id,
        String name,
        double diameter,
        double distanceFromParentPlanet,
        Composition composition,
        String parentPlanetName
) {}
