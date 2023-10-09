package com.example.springtask.controller;

import com.example.springtask.entity.dto.StarDto;
import com.example.springtask.entity.planet.Planet;
import com.example.springtask.entity.star.Star;
import com.example.springtask.service.PlanetService;
import com.example.springtask.service.StarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/stars")
public class StarController {
    private final StarService starService;
    private final PlanetService planetService;

    @PostMapping
    public Star createStar(@RequestBody Star star) {
        return starService.create(star);
    }

    @GetMapping("/{id}")
    public Star getStarById(@PathVariable Long id) {
        return starService.findById(id);
    }

    @GetMapping
    public List<StarDto> getAllStars() {
        return starService.findAllDto();
    }

    @PutMapping("/{id}")
    public void updateStar(
            @PathVariable Long id,
            @RequestBody Star updatedStar
    ) {
        starService.update(id, updatedStar);
    }

    @PutMapping("/{starId}/add-planet/{planetId}")
    public void addPlanetToStar(
            @PathVariable Long starId,
            @PathVariable Long planetId
    ) {
        Star star = starService.findById(starId);
        Planet planet = planetService.findById(planetId);

        star.addPlanet(planet);
        starService.update(star.getId(), star);
    }

    @DeleteMapping("/{id}")
    public void deleteStar(@PathVariable Long id) {
        starService.deleteById(id);
    }
}
