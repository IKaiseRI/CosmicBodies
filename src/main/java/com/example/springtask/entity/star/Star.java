package com.example.springtask.entity.star;

import com.example.springtask.entity.planet.Planet;
import com.example.springtask.entity.star.characteristic.Color;
import com.example.springtask.entity.star.characteristic.Size;
import com.example.springtask.entity.star.characteristic.Type;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Star {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Size size;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private Color color;

    @Column(name = "number_of_planets")
    private int numberOfPlanets;

    @Column(name = "planets")
    @OneToMany(mappedBy = "starId", cascade = CascadeType.ALL)
    private List<Planet> listOfPlanets = new ArrayList<>();

    public void addPlanet(Planet planet) {
        listOfPlanets.add(planet);
        planet.setStarId(this);
    }
}
