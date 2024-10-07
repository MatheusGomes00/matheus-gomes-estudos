package com.demo.testes.domain;

import static com.demo.testes.common.PlanetConstants.PLANET;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.demo.swPlanetAPI.domain.Planet;
import com.demo.swPlanetAPI.domain.PlanetRepository;

// @SpringBootTest(classes = PlanetRepository.class)
@DataJpaTest
public class PlanetRepositoryTest {

    @Autowired
    private PlanetRepository planetRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void createPlanet_WithValidData_ReturnsPlanet() {
        Planet planet = planetRepository.save(PLANET);

        Planet sut = testEntityManager.find(Planet.class, planet.getId());

        assertThat(sut).isNotNull();
        assertThat(sut).isEqualTo(PLANET.getName());
        assertThat(sut).isEqualTo(PLANET.getClimate());
        assertThat(sut).isEqualTo(PLANET.getTerrain());

    }  // onde está o erro
}
