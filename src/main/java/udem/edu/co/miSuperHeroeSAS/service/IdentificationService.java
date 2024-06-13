package udem.edu.co.miSuperHeroeSAS.service;

import org.springframework.stereotype.Service;
import udem.edu.co.miSuperHeroeSAS.entities.Identification;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public interface IdentificationService {
    public List<Identification> findAllIdentifications() throws IOException, SQLException;
    public Optional<Identification> findByIdIdentification(Long idIdentification) throws IOException, SQLException;
    public Optional<Identification> findByTipoIdentification(String tipoIdentification) throws IOException, SQLException;
    public Optional<Identification> findByDescripcionIdentification(String descripcionIdentification) throws IOException, SQLException;
    public Identification createIdentification(Identification identification) throws IOException;
    public Identification updateIdentification(Long idIdentification, Identification identification) throws IOException;
    public void deleteIdentification(Long idIdentification) throws IOException;
}
