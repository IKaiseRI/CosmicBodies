package com.example.springtask.service;

import com.example.springtask.entity.dto.SatelliteDto;
import com.example.springtask.entity.mapper.SatelliteMapper;
import com.example.springtask.entity.satellite.Satellite;
import com.example.springtask.repository.SatelliteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SatelliteService extends BaseService<Satellite> {
    private final SatelliteRepository satelliteRepository;
    private final SatelliteMapper satelliteMapper;

    public SatelliteService(SatelliteRepository repository, SatelliteRepository satelliteRepository, SatelliteMapper satelliteMapper) {
        super(repository);
        this.satelliteRepository = satelliteRepository;
        this.satelliteMapper = satelliteMapper;
    }

    public List<SatelliteDto> findAllDto() {
        List<Satellite> satellites = satelliteRepository.findAll();
        List<SatelliteDto> dtoSatellites = new ArrayList<>();

        for (Satellite satellite : satellites) {
            dtoSatellites.add(satelliteMapper.toDto(satellite));
        }

        return dtoSatellites;
    }
}
