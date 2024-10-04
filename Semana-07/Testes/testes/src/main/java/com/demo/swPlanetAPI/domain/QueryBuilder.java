package com.demo.swPlanetAPI.domain;

import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Example;

public class QueryBuilder {
    public static Example<Planet> makeQuery(Planet planet){
        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase().withIgnoreNullValues();
        return Example.of(planet, exampleMatcher);
    }
}
