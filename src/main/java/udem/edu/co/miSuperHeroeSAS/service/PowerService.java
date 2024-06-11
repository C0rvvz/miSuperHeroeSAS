package udem.edu.co.miSuperHeroeSAS.service;

import org.springframework.stereotype.Service;
import udem.edu.co.miSuperHeroeSAS.entities.Power;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public interface PowerService {
    public List<Power> findAllPowers() throws IOException, SQLException;
    public Optional<Power> findByIdPower(Long idPower) throws IOException, SQLException;
    public Optional<Power> findByNombrePower(String nombrePower) throws IOException, SQLException;
    public Optional<Power> findByFechaAdquisicionPower(LocalDate fechaAdquisicionPower) throws IOException, SQLException;
    public Optional<Power> findByNivelPower(int nivelPower) throws IOException, SQLException;
    public Optional<Power> findByDescripcionPower(String descripcionPower) throws IOException, SQLException;
    public Power createPower(Power power) throws IOException;
    public Power updatePower(Long idPower, Power power) throws IOException;
    public void deletePower(Long idPower) throws IOException;
}
