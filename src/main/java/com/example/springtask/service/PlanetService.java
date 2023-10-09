package com.example.springtask.service;

import com.example.springtask.entity.dto.PlanetDto;
import com.example.springtask.entity.mapper.PlanetMapper;
import com.example.springtask.entity.planet.Planet;
import com.example.springtask.repository.PlanetRepository;

import java.util.ArrayList;
import java.util.List;

public class PlanetService extends BaseService<Planet> {
    private final PlanetRepository planetRepository;
    private final PlanetMapper planetMapper;

    public PlanetService(PlanetRepository planetRepository, PlanetMapper planetMapper) {
        super(planetRepository);
        this.planetRepository = planetRepository;
        this.planetMapper = planetMapper;
    }

    public List<PlanetDto> findAllDto() {
        List<Planet> planets = planetRepository.findAll();
        List<PlanetDto> dtoPlanets = new ArrayList<>();

        for (Planet planet : planets) {
            dtoPlanets.add(planetMapper.toDto(planet));
        }

        return dtoPlanets;
    }
}
