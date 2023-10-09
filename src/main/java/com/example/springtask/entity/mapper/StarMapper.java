package com.example.springtask.entity.mapper;

import com.example.springtask.entity.dto.StarDto;
import com.example.springtask.entity.planet.Planet;
import com.example.springtask.entity.star.Star;

import java.util.List;
import java.util.stream.Collectors;

public class StarMapper {

    public StarDto toDto(Star star) {
        List<String> planetNames = star.getListOfPlanets().stream()
                .map(Planet::getName)
                .collect(Collectors.toList());

        return new StarDto(
                star.getId(),
                star.getName(),
                star.getSize(),
                star.getType(),
                star.getColor(),
                star.getNumberOfPlanets(),
                planetNames
        );
    }

    public Star toEntity(StarDto starDto) {
        Star star = new Star();
        star.setId(starDto.id());
        star.setName(starDto.name());
        star.setSize(starDto.size());
        star.setType(starDto.type());
        star.setColor(starDto.color());
        star.setNumberOfPlanets(starDto.numberOfPlanets());

        return star;
    }
}
