package com.example.springtask.entity.satellite;

import com.example.springtask.entity.planet.Planet;
import com.example.springtask.entity.satellite.tipisation.Composition;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Satellite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double diameter;

    @Column(name = "distance_from_parent_planet")
    private double distanceFromParentPlanet;

    @Enumerated(EnumType.STRING)
    private Composition composition;

    @ManyToOne
    @JoinColumn(name = "planet_id")
    private Planet planetId;
}
