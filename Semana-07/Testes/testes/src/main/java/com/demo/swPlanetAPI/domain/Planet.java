package com.demo.swPlanetAPI.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "planets")
public class Planet {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String terrain;
    private String climate;
    private String name;

    
    
    public Planet(String name, String climate, String terrain) {
        this.terrain = terrain;
        this.climate = climate;
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public String getTerrain() {
        return terrain;
    }
    public String getClimate() {
        return climate;
    }
    public String getName() {
        return name;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }
    public void setClimate(String climate) {
        this.climate = climate;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(obj, this);
    }
}
