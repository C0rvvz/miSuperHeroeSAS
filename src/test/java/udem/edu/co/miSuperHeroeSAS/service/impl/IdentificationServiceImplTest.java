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
import udem.edu.co.miSuperHeroeSAS.entities.Identification;
import udem.edu.co.miSuperHeroeSAS.repository.IdentificationRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class IdentificationServiceImplTest {
    @Mock
    private IdentificationRepository identificationRepository;

    @InjectMocks
    private IdentificationServiceImpl identificationService;

    private Hero hero;
    private Identification identification;

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

        // Configuración de la identificación
        identification = new Identification();
        identification.setIdIdentification(1L);
        identification.setNumeroIdentification("123456");
        identification.setTipoIdentification("cedula");
        identification.setDescripcionIdentification("documento de identidad");

        // Asigna la identificación al héroe
        hero.setIdentification(identification);

    }

    @AfterEach
    void tearDown() throws Exception {
        if (openMock != null) {
            openMock.close();
        }
    }

    @Test
    void findAllIdentificationsWithData() throws SQLException, IOException {
        List<Identification> identifications = new ArrayList<>();
        identifications.add(identification);
        when(identificationRepository.findAll()).thenReturn(identifications);
        assertNotNull(identificationService.findAllIdentifications());
    }

    @Test
    void findAllIdentificationsNull() throws SQLException, IOException {
        List<Identification> identifications = new ArrayList<>();
        identifications.size();
        when(identificationRepository.findAll()).thenReturn(identifications);
        List<Identification> a = identificationService.findAllIdentifications();
        assertTrue(a.isEmpty());
    }

    @Test
    void findByIdIdentificationWithData() throws SQLException, IOException {
        when(identificationRepository.findById(identification.getIdIdentification())).thenReturn(Optional.of(identification));
        assertNotNull(identificationService.findByIdIdentification(identification.getIdIdentification()));
    }

    @Test
    void findByIdIdentificationNull() throws SQLException, IOException {
        when(identificationRepository.findById(identification.getIdIdentification())).thenReturn(null);
        assertNull(identificationService.findByIdIdentification(identification.getIdIdentification()));
    }

    @Test
    void findByTipoIdentificationWithData() throws SQLException, IOException {
        when(identificationRepository.findByTipoIdentification(identification.getTipoIdentification())).thenReturn(Optional.of(identification));
        assertNotNull(identificationService.findByTipoIdentification(identification.getTipoIdentification()));
    }

    @Test
    void findByTipoIdentificationNull() throws SQLException, IOException {
        when(identificationRepository.findByTipoIdentification(identification.getTipoIdentification())).thenReturn(null);
        assertNull(identificationService.findByTipoIdentification(identification.getTipoIdentification()));
    }

    @Test
    void findByNumeroIdentificationWithData() throws SQLException, IOException {
        when(identificationRepository.findByNumeroIdentification(identification.getNumeroIdentification())).thenReturn(Optional.of(identification));
        assertNotNull(identificationService.findByNumeroIdentification(identification.getNumeroIdentification()));
    }

    @Test
    void findByNumeroIdentificationNull() throws SQLException, IOException {
        when(identificationRepository.findByNumeroIdentification(identification.getNumeroIdentification())).thenReturn(null);
        assertNull(identificationService.findByNumeroIdentification(identification.getNumeroIdentification()));
    }

    @Test
    void findByDescripcionIdentificationWithData() throws SQLException, IOException {
        when(identificationRepository.findByDescripcionIdentification(identification.getDescripcionIdentification())).thenReturn(Optional.of(identification));
        assertNotNull(identificationService.findByDescripcionIdentification(identification.getDescripcionIdentification()));
    }

    @Test
    void findByDescripcionIdentificationNull() throws SQLException, IOException {
        when(identificationRepository.findByDescripcionIdentification(identification.getDescripcionIdentification())).thenReturn(null);
        assertNull(identificationService.findByDescripcionIdentification(identification.getDescripcionIdentification()));
    }

    @Test
    void createIdentificationWithData() throws IOException{
        when(identificationRepository.findById(identification.getIdIdentification())).thenReturn(Optional.of(identification));
        when(identificationRepository.save(any(Identification.class))).thenReturn(identification);
        assertDoesNotThrow(() -> identificationService.updateIdentification(identification.getIdIdentification(), identification));
        verify(identificationRepository, times(1)).save(identification);
    }

    @Test
    void createIdentificationNull() throws IOException{
        Identification nullIdentification = null;
        assertThrows(IOException.class, () -> identificationService.createIdentification(nullIdentification));
        verify(identificationRepository, never()).save(any(Identification.class));
    }

    @Test
    void updateIdentificationWithData() throws IOException{
        when(identificationRepository.findById(identification.getIdIdentification())).thenReturn(Optional.empty());
        assertThrows(IOException.class, () -> identificationService.updateIdentification(identification.getIdIdentification(), identification));
        verify(identificationRepository, never()).save(any(Identification.class));
    }

    @Test
    void updateIdentificationNull() throws IOException{
        when(identificationRepository.findById(null)).thenReturn(Optional.empty());
        assertThrows(IOException.class, () -> identificationService.updateIdentification(null, null));
        verify(identificationRepository, never()).save(any(Identification.class));
    }

    @Test
    void deleteIdentificationWithData() throws IOException{
        when(identificationRepository.findById(identification.getIdIdentification())).thenReturn(Optional.of(identification));
        doNothing().when(identificationRepository).delete(identification);
        assertDoesNotThrow(() -> identificationService.deleteIdentification(identification.getIdIdentification()));
        verify(identificationRepository, times(1)).delete(identification);
    }

    @Test
    void deleteIdentificationNull() throws IOException{
        when(identificationRepository.findById(null)).thenReturn(Optional.empty());
        assertThrows(IOException.class, () -> identificationService.deleteIdentification(null));
        verify(identificationRepository, never()).delete(any(Identification.class));
    }
}