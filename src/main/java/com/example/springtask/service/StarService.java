package com.example.springtask.service;

import com.example.springtask.entity.dto.StarDto;
import com.example.springtask.entity.mapper.StarMapper;
import com.example.springtask.entity.star.Star;
import com.example.springtask.repository.StarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StarService extends BaseService<Star> {
    private final StarRepository starRepository;
    private final StarMapper starMapper;

    public StarService(StarRepository starRepository, StarMapper starMapper) {
        super(starRepository);
        this.starRepository = starRepository;
        this.starMapper = starMapper;
    }

    public List<StarDto> findAllDto() {
        List<Star> stars = starRepository.findAll();
        List<StarDto> dtoStars = new ArrayList<>();

        for (Star star : stars) {
            dtoStars.add(starMapper.toDto(star));
        }

        return dtoStars;
    }
}
