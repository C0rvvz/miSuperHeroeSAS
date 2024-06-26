package udem.edu.co.miSuperHeroeSAS.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import udem.edu.co.miSuperHeroeSAS.entities.Identification;
import udem.edu.co.miSuperHeroeSAS.repository.IdentificationRepository;
import udem.edu.co.miSuperHeroeSAS.service.IdentificationService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class IdentificationServiceImpl implements IdentificationService {
    @Autowired
    private IdentificationRepository identificationRepository;

    @Override
    public List<Identification> findAllIdentifications() throws IOException, SQLException {
        try {
            return (List<Identification>) identificationRepository.findAll();
        } catch (Exception e) {
            throw new IOException("Error al buscar todas las identificaciones: " + e.getMessage());
        }
    }

    @Override
    public Optional<Identification> findByIdIdentification(Long idIdentification) throws IOException, SQLException {
        try {
            return identificationRepository.findById(idIdentification);
        } catch (Exception e) {
            throw new IOException("Error al buscar el id de la identificacion: " + e.getMessage());
        }
    }

    @Override
    public Optional<Identification> findByTipoIdentification(String tipoIdentification) throws IOException, SQLException {
        try {
            return identificationRepository.findByTipoIdentification(tipoIdentification);
        } catch (Exception e) {
            throw new IOException("Error al buscar el tipo de la identificacion: " + e.getMessage());
        }
    }

    public Optional<Identification> findByDescripcionIdentification(String descripcionIdentification) throws IOException, SQLException {
        try {
            return identificationRepository.findByDescripcionIdentification(descripcionIdentification);
        } catch (Exception e) {
            throw new IOException("Error al buscar la descripcion de la identificacion: " + e.getMessage());
        }
    }

    @Override
    public Identification createIdentification(Identification identification) throws IOException {
        if (identification == null) {
            throw new IOException("La identificacion no puede ser nulo ");
        }
        if (identification.getIdIdentification() != null && identificationRepository.existsById(identification.getIdIdentification())) {
            throw new IOException("Ya existe una identifiacion con ese ID: "  + identification.getIdIdentification());
        }
        return identificationRepository.save(identification);
    }

    @Override
    public Identification updateIdentification(Long idIdentification, Identification identificationDetails) throws IOException {
        Identification identification = identificationRepository.findById(idIdentification)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Identaficacion no encontrada con el id " + idIdentification));

        try {
            identification.setTipoIdentification(identificationDetails.getTipoIdentification());
            identification.setDescripcionIdentification(identificationDetails.getDescripcionIdentification());

            return identificationRepository.save(identification);
        } catch (Exception e) {
            throw new IOException("Error al actualizar la identificacion", e);
        }
    }

    @Override
    public void deleteIdentification(Long idIdentification) throws IOException {
        Optional<Identification> identification = identificationRepository.findById(idIdentification);
        if (identification.isPresent()) {
            identificationRepository.delete(identification.get());
        } else {
            throw new IOException("No se ha encontrado una identificacion con ese ID: " + idIdentification);
        }
    }
}
