package udem.edu.co.miSuperHeroeSAS.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import udem.edu.co.miSuperHeroeSAS.entities.Power;
import udem.edu.co.miSuperHeroeSAS.repository.PowerRepository;
import udem.edu.co.miSuperHeroeSAS.service.PowerService;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PowerServiceImpl implements PowerService {
    @Autowired
    private PowerRepository powerRepository;

    @Override
    public List<Power> findAllPowers() throws IOException, SQLException {
        try {
            return (List<Power>) powerRepository.findAll();
        } catch (Exception e) {
            throw new IOException("Error al buscar todos los poderes: " + e.getMessage());
        }
    }

    @Override
    public Optional<Power> findByIdPower(Long idPower) throws IOException, SQLException {
        try {
            return powerRepository.findById(idPower);
        } catch (Exception e) {
            throw new IOException("Error al buscar el id del poder: " + e.getMessage());
        }
    }

    @Override
    public Optional<Power> findByNombrePower(String nombrePower) throws IOException, SQLException {
        try {
            return powerRepository.findByNombrePower(nombrePower);
        } catch (Exception e) {
            throw new IOException("Error al buscar el nombre del poder: " + e.getMessage());
        }
    }

    @Override
    public Optional<Power> findByFechaAdquisicionPower(LocalDate fechaAdquisicionPower) throws IOException, SQLException {
        try {
            return powerRepository.findByFechaAdquisicionPower(fechaAdquisicionPower);
        } catch (Exception e) {
            throw new IOException("Error al buscar la fecha de creacion del poder: " + e.getMessage());
        }
    }

    @Override
    public Optional<Power> findByNivelPower(int nivelPower) throws IOException, SQLException {
        try {
            return powerRepository.findByNivelPower(nivelPower);
        } catch (Exception e) {
            throw new IOException("Error al buscar el nivel del poder: " + e.getMessage());
        }
    }

    @Override
    public Optional<Power> findByDescripcionPower(String descripcionPower) throws IOException, SQLException {
        try {
            return powerRepository.findByDescripcionPower(descripcionPower);
        } catch (Exception e) {
            throw new IOException("Error al buscar la descripcion del poder: " + e.getMessage());
        }
    }

    @Override
    public Power createPower(Power power) throws IOException {
        if (power == null) {
            throw new IOException("El Poder no puede ser nulo ");
        }
        if (power.getIdPower() != null && powerRepository.existsById(power.getIdPower())) {
            throw new IOException("Ya existe un Poder con ese ID: "  + power.getIdPower());
        }
        return powerRepository.save(power);
    }

    @Override
    public Power updatePower(Long idPower, Power powerDetails) throws IOException {
        Power power = powerRepository.findById(idPower)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Poder no encontrado con el id " + idPower));

        try {
            power.setNombrePower(powerDetails.getNombrePower());
            power.setFechaAdquisicionPower(powerDetails.getFechaAdquisicionPower());
            power.setNivelPower(powerDetails.getNivelPower());
            power.setDescripcionPower(powerDetails.getDescripcionPower());
            power.setHero(powerDetails.getHero());

            return powerRepository.save(power);
        } catch (Exception e) {
            throw new IOException("Error al actualizar el poder", e);
        }
    }


    @Override
    public void deletePower(Long idPower) throws IOException {
        Optional<Power> power = powerRepository.findById(idPower);
        if (power.isPresent()) {
            powerRepository.delete(power.get());
        } else {
            throw new IOException("No se ha encontrado un Poder con ese ID: " + idPower);
        }
    }
}
