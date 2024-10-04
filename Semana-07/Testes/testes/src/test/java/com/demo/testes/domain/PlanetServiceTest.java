package com.demo.testes.domain;


import static com.demo.testes.common.PlanetConstants.PLANET;
import static com.demo.testes.common.PlanetConstants.INVALID_PLANET;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.swPlanetAPI.domain.Planet;
import com.demo.swPlanetAPI.domain.PlanetRepository;
import com.demo.swPlanetAPI.domain.PlanetService;

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


}
