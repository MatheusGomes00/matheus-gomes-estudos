package com.demo.testes.domain;

import static com.demo.testes.common.PlanetConstants.PLANET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

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
}
