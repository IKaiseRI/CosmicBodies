package com.example.springtask.controller;

import com.example.springtask.entity.dto.SatelliteDto;
import com.example.springtask.entity.satellite.Satellite;
import com.example.springtask.service.SatelliteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/satellites")
public class SatelliteController {
    private final SatelliteService satelliteService;

    @PostMapping
    public Satellite createSatellite(@RequestBody Satellite satellite) {
        return satelliteService.create(satellite);
    }

    @GetMapping("/{id}")
    public Satellite getSatelliteById(@PathVariable Long id) {
        return satelliteService.findById(id);
    }

    @GetMapping
    public List<SatelliteDto> getAllSatellites() {
        return satelliteService.findAllDto();
    }

    @PutMapping("/{id}")
    public void updateSatellite(
            @PathVariable Long id,
            @RequestBody Satellite updatedSatellite
    ) {
        satelliteService.update(id, updatedSatellite);
    }

    @DeleteMapping("/{id}")
    public void deleteSatellite(@PathVariable Long id) {
        satelliteService.deleteById(id);
    }
}
