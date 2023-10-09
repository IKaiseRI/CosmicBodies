package com.example.springtask.entity.planet;

import com.example.springtask.entity.satellite.Satellite;
import com.example.springtask.entity.star.Star;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double diameter;
    private double radius;

    @Column(name = "distance_from_star")
    private double distanceFromStar;

    @Embedded
    @Column(name = "planet_type")
    private PlanetType planetType;

    @Column(name = "number_of_satellites")
    private int numberOfSatellites;

    @ManyToOne
    @JoinColumn(name = "star_id")
    private Star starId;

    @Column(name = "satellites")
    @OneToMany(mappedBy = "planetId", cascade = CascadeType.ALL)
    private List<Satellite> satelliteList = new ArrayList<>();

    public void addSatellite(Satellite satellite) {
        satellite.setPlanetId(this);
        satelliteList.add(satellite);
    }
}
