package udem.edu.co.miSuperHeroeSAS.service;

import org.springframework.stereotype.Service;
import udem.edu.co.miSuperHeroeSAS.entities.Identification;
import udem.edu.co.miSuperHeroeSAS.entities.Nivel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public interface NivelService {
    public List<Nivel> findAllNiveles() throws IOException, SQLException;
    public Optional<Nivel> findByIdNivel(Long idNivel) throws IOException, SQLException;
    public Optional<Nivel> findByNivel(int nivel) throws IOException, SQLException;
    public Nivel createNivel(Nivel nivel) throws IOException;
    public Nivel updateNivel(Long idNivel, Identification identification) throws IOException;
    public void deleteNivel(Long idNivel) throws IOException;
}
