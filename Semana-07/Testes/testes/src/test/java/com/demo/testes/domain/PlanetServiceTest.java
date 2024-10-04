package com.demo.testes.domain;


import static com.demo.testes.common.PlanetConstants.PLANET;
import static com.demo.testes.common.PlanetConstants.INVALID_PLANET;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Example;

import com.demo.swPlanetAPI.domain.Planet;
import com.demo.swPlanetAPI.domain.PlanetRepository;
import com.demo.swPlanetAPI.domain.PlanetService;
import com.demo.swPlanetAPI.domain.QueryBuilder;

@ExtendWith(MockitoExtension.class)
//@SpringBootTest(classes = PlanetService.class)  gera muito log e verificações desnecessárias, para apenas uma classe ou método
public class PlanetServiceTest {

    //@Autowired anotação do spring
    @InjectMocks
    public PlanetService planetService;

    //@MockBean
    @Mock
    PlanetRepository planetRepository;
    
    // padrão para nomear os métodos: operacao_estado_retorno
    @Test
    public void createPlanet_WithValidData_ReturnsPlanet() {
        // stub
        when(planetRepository.save(PLANET)).thenReturn(PLANET);

        // system under test
        Planet sut = planetService.create(PLANET);

        assertThat(sut).isEqualTo(PLANET);
    }

    @Test
    public void createPlanet_WithiNValidData_ThrowsException() {
        // stub
        when(planetRepository.save(INVALID_PLANET)).thenThrow(RuntimeException.class);

        assertThatThrownBy(() -> planetService.create(INVALID_PLANET)).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void getPlanet_ByExistingId_ReturnsPlanet() {
        
        when(planetRepository.findById(1L)).thenReturn(Optional.of(PLANET));

        Optional<Planet> sut = planetService.getById(1L);

        assertThat(sut).isNotEmpty();
        assertThat(sut.get()).isEqualTo(PLANET);
    }

    @Test
    public void getPlanet_ByUnexistingId_ReturnsPlanet() {
        // AAA - ARRANGE, ACT, ASSERT
        when(planetRepository.findById(1L)).thenReturn(Optional.empty());  // ARRANGE

        Optional<Planet> sut = planetService.getById(1L);  // ACT

        assertThat(sut).isEmpty();  // ASSERT
    }

    @Test
    public void getPlanet_ByExistingName_ReturnsPlanet() {
        
        when(planetRepository.findByName(PLANET.getName())).thenReturn(Optional.of(PLANET));

        Optional<Planet> sut = planetService.getByName(PLANET.getName());

        assertThat(sut).isNotEmpty();
        assertThat(sut.get()).isEqualTo(PLANET);
    }

    @Test
    public void getPlanet_ByUnexistingName_ReturnsPlanet() {
        final String name = "Unexisting name";
        when(planetRepository.findByName(name)).thenReturn(Optional.empty());  // stub

        Optional<Planet> sut = planetService.getByName(name); 

        assertThat(sut).isEmpty(); 
    }


    @Test
    public void listPlanets_ReturnsAllPlanets() {
        List<Planet> planets = new ArrayList<>() {
            {
                add(PLANET);
            }
        };
        Example<Planet> query = QueryBuilder.makeQuery(new Planet(PLANET.getClimate(), PLANET.getTerrain()));
        
        when(planetRepository.findAll(query)).thenReturn(planets);
        
        List<Planet> sut = planetService.list(PLANET.getTerrain(), PLANET.getClimate());

        assertThat(sut).isNotEmpty();
        assertThat(sut).hasSize(1);
        assertThat(sut.get(0)).isEqualTo(PLANET);
    }

    @Test
    public void listPlanets_ReturnsNoPlanets() {
        when(planetRepository.findAll(any())).thenReturn(Collections.emptyList());

        List<Planet> sut = planetService.list(PLANET.getTerrain(), PLANET.getClimate());

        assertThat(sut).isEmpty();
    }

    @Test
    public void removePlanet_WithExistingID_doesNotThrowAnyExceptions() {
        assertThatCode(() -> planetService.remove(1L)).doesNotThrowAnyException();
    }

    @Test
    public void removePlanet_WithUnexistingID_doesNotThrowAnyExceptions() {
        doThrow(new RuntimeException()).when(planetRepository).deleteById(99L);
        
        assertThatThrownBy(() -> planetService.remove(99L)).isInstanceOf(RuntimeException.class);
    }
}
