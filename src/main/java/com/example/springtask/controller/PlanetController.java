package com.example.springtask.controller;

import com.example.springtask.entity.dto.PlanetDto;
import com.example.springtask.entity.planet.Planet;
import com.example.springtask.entity.satellite.Satellite;
import com.example.springtask.service.PlanetService;
import com.example.springtask.service.SatelliteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/planets")
public class PlanetController {
    private final PlanetService planetService;
    private final SatelliteService satelliteService;

    @PostMapping
    public Planet createPlanet(@RequestBody Planet planet) {
        return planetService.create(planet);
    }

    @GetMapping("/{id}")
    public Planet getPlanetById(@PathVariable Long id) {
        return planetService.findById(id);
    }

    @GetMapping
    public List<PlanetDto> getAllPlanets() {
        return planetService.findAllDto();
    }

    @PutMapping("/{id}")
    public void updatePlanet(
            @PathVariable Long id,
            @RequestBody Planet updatedPlanet
    ) {
        planetService.update(id, updatedPlanet);
    }

    @PutMapping("/{planetId}/add-satellite/{satelliteId}")
    public void addSatelliteToPlanet(
            @PathVariable Long planetId,
            @PathVariable Long satelliteId
    ) {
        Planet planet = planetService.findById(planetId);
        Satellite satellite = satelliteService.findById(satelliteId);

        planet.addSatellite(satellite);
        planetService.update(planet.getId(), planet);
    }

    @DeleteMapping("/{id}")
    public void deletePlanet(@PathVariable Long id) {
        planetService.deleteById(id);
    }
}
