package udem.edu.co.miSuperHeroeSAS.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import udem.edu.co.miSuperHeroeSAS.entities.Hero;
import udem.edu.co.miSuperHeroeSAS.entities.Power;
import udem.edu.co.miSuperHeroeSAS.repository.PowerRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PowerServiceImplTest {
    @Mock
    private PowerRepository powerRepository;

    @InjectMocks
    private PowerServiceImpl powerService;

    private Power power;
    private Hero hero;

    private AutoCloseable openMock;

    @BeforeEach
    void setUp() {
        openMock = MockitoAnnotations.openMocks(this);

        // Inicializa el héroe
        hero = new Hero();
        hero.setIdHero(1L);
        hero.setNombreHero("batman");
        hero.setAliasHero("pepe");
        hero.setEstadoHero("activo");
        hero.setFotoUrlHero("https://www.seekpng.com/png/detail/30-302355_batman-pepe.png");
        hero.setFechaCreacionHero(LocalDate.of(2024, 6, 9));

        // Configura el poder
        power = new Power();
        power.setIdPower(1L);
        power.setNombrePower("correr");
        power.setDescripcionPower("Gives the hero superhuman strength");
        power.setNivelPower(5);
        power.setFechaAdquisicionPower(LocalDate.of(2024, 1, 1));
        power.setHero(hero);
    }

    @AfterEach
    void tearDown() throws Exception {
        if (openMock != null) {
            openMock.close();
        }
    }

    @Test
    void findAllPowersWithData() throws SQLException, IOException {
        List<Power> powers = new ArrayList<>();
        powers.add(power);
        when(powerRepository.findAll()).thenReturn(powers);
        assertNotNull(powerService.findAllPowers());
    }

    @Test
    void findAllPowersNull() throws SQLException, IOException{
        List<Power> powers = new ArrayList<>();
        powers.size();
        when(powerRepository.findAll()).thenReturn(powers);
        List<Power> a = powerService.findAllPowers();
        assertTrue(a.isEmpty());
    }

    @Test
    void findByIdPowerWithData() throws SQLException, IOException{
        when(powerRepository.findById(power.getIdPower())).thenReturn(Optional.of(power));
        assertNotNull(powerService.findByIdPower(power.getIdPower()));
    }

    @Test
    void findByIdPowerNull() throws SQLException, IOException{
        when(powerRepository.findById(power.getIdPower())).thenReturn(null);
        assertNull(powerService.findByIdPower(power.getIdPower()));
    }

    @Test
    void findByNombrePowerWithData() throws SQLException, IOException{
        when(powerRepository.findByNombrePower(power.getNombrePower())).thenReturn(Optional.of(power));
        assertNotNull(powerService.findByNombrePower(power.getNombrePower()));
    }

    @Test
    void findByNombrePowerNull() throws SQLException, IOException{
        when(powerRepository.findByNombrePower(power.getNombrePower())).thenReturn(null);
        assertNull(powerService.findByNombrePower(power.getNombrePower()));
    }

    @Test
    void findByFechaAdquisicionPowerWithData() throws SQLException, IOException{
        when(powerRepository.findByFechaAdquisicionPower(power.getFechaAdquisicionPower())).thenReturn(Optional.of(power));
        assertNotNull(powerService.findByFechaAdquisicionPower(power.getFechaAdquisicionPower()));
    }

    @Test
    void findByFechaAdquisicionPowerNull() throws SQLException, IOException{
        when(powerRepository.findByFechaAdquisicionPower(power.getFechaAdquisicionPower())).thenReturn(null);
        assertNull(powerService.findByFechaAdquisicionPower(power.getFechaAdquisicionPower()));
    }

    @Test
    void findByNivelPowerWithData() throws SQLException, IOException{
        when(powerRepository.findByNivelPower(power.getNivelPower())).thenReturn(Optional.of(power));
        assertNotNull(powerService.findByNivelPower(power.getNivelPower()));
    }

    @Test
    void findByNivelPowerNull() throws SQLException, IOException{
        when(powerRepository.findByNivelPower(power.getNivelPower())).thenReturn(null);
        assertNull(powerService.findByNivelPower(power.getNivelPower()));
    }

    @Test
    void findByDescripcionPowerWithData() throws SQLException, IOException{
        when(powerRepository.findByDescripcionPower(power.getDescripcionPower())).thenReturn(Optional.of(power));
        assertNotNull(powerService.findByDescripcionPower(power.getDescripcionPower()));
    }

    @Test
    void findByDescripcionPowerNull() throws SQLException, IOException{
        when(powerRepository.findByDescripcionPower(power.getDescripcionPower())).thenReturn(null);
        assertNull(powerService.findByDescripcionPower(power.getDescripcionPower()));
    }

    @Test
    void createPowerWithData() throws IOException{
        when(powerRepository.findById(power.getIdPower())).thenReturn(Optional.of(power));
        when(powerRepository.save(any(Power.class))).thenReturn(power);
        assertDoesNotThrow(() -> powerService.updatePower(power.getIdPower(), power));
        verify(powerRepository, times(1)).save(power);
    }

    @Test
    void createPowerNull() throws IOException{
        Power nullPower = null;
        assertThrows(IOException.class, () -> powerService.createPower(nullPower));
        verify(powerRepository, never()).save(any(Power.class));
    }

    @Test
    void updatePowerWithData() throws IOException{
        when(powerRepository.findById(power.getIdPower())).thenReturn(Optional.empty());
        assertThrows(IOException.class, () -> powerService.updatePower(power.getIdPower(), power));
        verify(powerRepository, never()).save(any(Power.class));
    }

    @Test
    void updatePowerNull() throws IOException{
        when(powerRepository.findById(null)).thenReturn(Optional.empty());
        assertThrows(IOException.class, () -> powerService.updatePower(null, null));
        verify(powerRepository, never()).save(any(Power.class));
    }

    @Test
    void deletePowerWithData() throws IOException {
        when(powerRepository.findById(power.getIdPower())).thenReturn(Optional.of(power));
        doNothing().when(powerRepository).delete(power);
        assertDoesNotThrow(() -> powerService.deletePower(power.getIdPower()));
        verify(powerRepository, times(1)).delete(power);
    }

    @Test
    void deletePowerNull() throws IOException {
        when(powerRepository.findById(null)).thenReturn(Optional.empty());
        assertThrows(IOException.class, () -> powerService.deletePower(null));
        verify(powerRepository, never()).delete(any(Power.class));
    }
}