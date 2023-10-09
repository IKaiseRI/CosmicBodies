package com.example.springtask.entity.dto;

import com.example.springtask.entity.star.characteristic.*;

import java.util.List;

public record StarDto(
        Long id,
        String name,
        Size size,
        Type type,
        Color color,
        int numberOfPlanets,
        List<String> listOfPlanetNames

) {}
