package udem.edu.co.miSuperHeroeSAS.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import udem.edu.co.miSuperHeroeSAS.entities.Hero;
import udem.edu.co.miSuperHeroeSAS.entities.Identification;
import udem.edu.co.miSuperHeroeSAS.entities.Power;
import udem.edu.co.miSuperHeroeSAS.repository.HeroRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HeroServiceImplTest {

    @Mock
    private HeroRepository heroRepository;

    @InjectMocks
    private HeroServiceImpl heroService;

    private Hero hero;
    private Identification identification;
    private Power power;
    private List<Power> powers;

    private AutoCloseable openMock;

    @BeforeEach
    void setUp() {
        openMock = MockitoAnnotations.openMocks(this);

        // Configuración del héroe
        hero = new Hero();
        hero.setIdHero(1L);
        hero.setNombreHero("batman");
        hero.setAliasHero("pepe");
        hero.setFechaCreacionHero(LocalDate.of(2024, 6, 9));
        hero.setEstadoHero("desaparecido");

        // Configuración de la identificación
        identification = new Identification();
        identification.setIdIdentification(1L);
        identification.setTipoIdentification("cedula");
        identification.setDescripcionIdentification("documento de identidad");
        hero.setIdentification(identification);

        // Configuración del poder
        power = new Power();
        power.setIdPower(1L);
        power.setNombrePower("correr");
        power.setHero(hero);
        powers = List.of(power);
        hero.setPowers(powers);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMock.close();
    }

    @Test
    void findAllHerosWithData() throws SQLException, IOException {
        List<Hero> heros = new ArrayList<>();
        heros.add(hero);
        when(heroRepository.findAll()).thenReturn(heros);
        assertNotNull(heroService.findAllHeros());
    }

    @Test
    void findAllHerosVacio() throws SQLException, IOException {
        List<Hero> heros = new ArrayList<>();
        heros.size();
        when(heroRepository.findAll()).thenReturn(heros);
        List<Hero> a = heroService.findAllHeros();
        assertTrue(a.isEmpty());
    }

    @Test
    void findByIdHeroWithData() throws SQLException, IOException {
        when(heroRepository.findById(hero.getIdHero())).thenReturn(Optional.of(hero));
        assertNotNull(heroService.findByIdHero(hero.getIdHero()));
    }

    @Test
    void findByIdHeroNull() throws SQLException, IOException {
        when(heroRepository.findById(hero.getIdHero())).thenReturn(null);
        assertNull(heroService.findByIdHero(hero.getIdHero()));
    }

    @Test
    void findByAliasHeroWithData() throws SQLException, IOException {
        when(heroRepository.findByAliasHero(hero.getAliasHero())).thenReturn(Optional.of(hero));
        assertNotNull(heroService.findByAliasHero(hero.getAliasHero()));
    }

    @Test
     void findByAliasHeroNull() throws SQLException, IOException {
        when(heroRepository.findByAliasHero(hero.getAliasHero())).thenReturn(null);
        assertNull(heroService.findByAliasHero(hero.getAliasHero()));
    }

    @Test
    void findByNombreHeroWithData() throws SQLException, IOException {
        when(heroRepository.findByNombreHero(hero.getNombreHero())).thenReturn(Optional.of(hero));
        assertNotNull(heroService.findByNombreHero(hero.getNombreHero()));
    }

    @Test
    void findByNombreHeroNull() throws SQLException, IOException {
        when(heroRepository.findByNombreHero(hero.getNombreHero())).thenReturn(null);
        assertNull(heroService.findByNombreHero(hero.getNombreHero()));
    }

    @Test
    void findByFechaCreacionHeroWithData() throws SQLException, IOException {
        when(heroRepository.findByFechaCreacionHero(hero.getFechaCreacionHero())).thenReturn(Optional.of(hero));
        assertNotNull(heroService.findByFechaCreacionHero(hero.getFechaCreacionHero()));
    }

    @Test
    void findByFechaCreacionHeroNull() throws SQLException, IOException {
        when(heroRepository.findByNombreHero(hero.getNombreHero())).thenReturn(null);
        assertNull(heroService.findByNombreHero(hero.getNombreHero()));
    }

    @Test
    void findByEstadoHeroWithData() throws SQLException, IOException {
        when(heroRepository.findByEstadoHero(hero.getEstadoHero())).thenReturn(Optional.of(hero));
        assertNotNull(heroService.findByEstadoHero(hero.getEstadoHero()));
    }

    @Test
    void findByEstadoHeroNull() throws SQLException, IOException {
        when(heroRepository.findByEstadoHero(hero.getEstadoHero())).thenReturn(null);
        assertNull(heroService.findByEstadoHero(hero.getEstadoHero()));
    }

    @Test
    void createHeroWithData() throws IOException {
        // Simular el comportamiento del repositorio al encontrar el héroe con el ID dado
        when(heroRepository.findById(hero.getIdHero())).thenReturn(Optional.of(hero));

        // Simular el comportamiento del repositorio al guardar el héroe
        when(heroRepository.save(any(Hero.class))).thenReturn(hero);

        // Llamar al método de servicio para actualizar el héroe
        assertDoesNotThrow(() -> heroService.updateHero(hero.getIdHero(), hero));

        // Verificar que el método del repositorio se llamó una vez con el héroe correcto
        verify(heroRepository, times(1)).save(hero);
    }

    @Test
    void createHeroNull() throws IOException {
        // Crear un héroe nulo
        Hero nullHero = null;

        // Llamar al método de servicio y esperar que lance una excepción
        assertThrows(IOException.class, () -> heroService.createHero(nullHero));

        // Verificar que el método del repositorio no se llamó
        verify(heroRepository, never()).save(any(Hero.class));
    }

    @Test
    void updateHeroWithData() throws IOException {
        // Simular el repositorio no encontrando el héroe con el ID dado
        Long idHero = 1L;
        Hero hero = new Hero(); // Asegúrate de inicializar con datos relevantes para el test
        hero.setIdHero(idHero);

        when(heroRepository.findById(idHero)).thenReturn(Optional.empty());

        // Llamar al método de servicio para actualizar el héroe y verificar que lanza una ResponseStatusException
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> heroService.updateHero(idHero, hero));

        // Verificar que el código de estado de la excepción es NOT_FOUND
        assertEquals(HttpStatus.NOT_FOUND.value(), exception.getStatusCode().value());

        // Verificar que el mensaje de la excepción contiene "Heroe no encontrado con el id 1"
        assertTrue(exception.getReason().contains("Heroe no encontrado con el id " + idHero));

        // Verificar que el método del repositorio no se llamó para guardar
        verify(heroRepository, never()).save(any(Hero.class));
    }

    @Test
    void updateHeroNull() {
        Long idHero = null;

        when(heroRepository.findById(idHero)).thenReturn(Optional.empty());

        // Llamar al método de servicio para actualizar el héroe y verificar que lanza una ResponseStatusException
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> heroService.updateHero(idHero, null));

        // Verificar que el código de estado de la excepción es NOT_FOUND
        assertEquals(HttpStatus.NOT_FOUND.value(), exception.getStatusCode().value());

        // Verificar que el mensaje de la excepción contiene "Heroe no encontrado con el id null"
        assertTrue(exception.getReason().contains("Heroe no encontrado con el id " + idHero));

        // Verificar que el método del repositorio no se llamó para guardar
        verify(heroRepository, never()).save(any(Hero.class));
    }


    @Test
    void deleteHeroWithData() throws IOException {
        // Simular el comportamiento del repositorio al buscar y borrar un héroe
        when(heroRepository.findById(hero.getIdHero())).thenReturn(Optional.of(hero));
        doNothing().when(heroRepository).delete(hero);

        // Llamar al método de servicio para borrar el héroe
        assertDoesNotThrow(() -> heroService.deleteHero(hero.getIdHero()));

        // Verificar que el método del repositorio se llamó una vez con el héroe correcto
        verify(heroRepository, times(1)).delete(hero);
    }

    @Test
    void deleteHeroNull() throws IOException {
        // Simular que el repositorio no encuentra el héroe con el ID dado
        when(heroRepository.findById(null)).thenReturn(Optional.empty());

        // Llamar al método de servicio para borrar el héroe y verificar que lanza una excepción
        assertThrows(IOException.class, () -> heroService.deleteHero(null));

        // Verificar que el método del repositorio no se llamó
        verify(heroRepository, never()).delete(any(Hero.class));
    }
}