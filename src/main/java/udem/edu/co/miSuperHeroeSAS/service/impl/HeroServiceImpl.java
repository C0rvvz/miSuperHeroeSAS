package udem.edu.co.miSuperHeroeSAS.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import udem.edu.co.miSuperHeroeSAS.entities.Hero;
import udem.edu.co.miSuperHeroeSAS.entities.Identification;
import udem.edu.co.miSuperHeroeSAS.repository.HeroRepository;
import udem.edu.co.miSuperHeroeSAS.service.HeroService;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class HeroServiceImpl implements HeroService {
    @Autowired
    private HeroRepository heroRepository;

    @Override
    public List<Hero> findAllHeros() throws IOException, SQLException {
        try {
            return (List<Hero>) heroRepository.findAll();
        } catch (Exception e) {
            // Manejo general para otras excepciones
            throw new IOException("Error al buscar todos los heroes: " + e.getMessage());
        }
    }

    @Override
    public Optional<Hero> findByIdHero(Long idHero) throws IOException, SQLException {
        try {
            return heroRepository.findById(idHero);
        } catch (Exception e) {
            // Manejo general para otras excepciones
            throw new IOException("Error al buscar el id del heroe: " + e.getMessage());
        }
    }

    @Override
    public Optional<Hero> findByNombreHero(String nombreHero) throws IOException, SQLException {
        try {
            return heroRepository.findByNombreHero(nombreHero);
        } catch (Exception e) {
            // Manejo general para otras excepciones
            throw new IOException("Error al buscar el nombre del heroe: " + e.getMessage());
        }
    }

    @Override
    public Optional<Hero> findByAliasHero(String aliasHero) throws IOException, SQLException {
        try {
            return heroRepository.findByAliasHero(aliasHero);
        } catch (Exception e) {
            // Manejo general para otras excepciones
            throw new IOException("Error al buscar el alias del heroe: " + e.getMessage());
        }
    }

    @Override
    public Optional<Hero> findByFechaCreacionHero(LocalDate fechaCreacionHero) throws IOException, SQLException {
        try {
            return heroRepository.findByFechaCreacionHero(fechaCreacionHero);
        } catch (Exception e) {
            // Manejo general para otras excepciones
            throw new IOException("Error al buscar la fecha de creacion del heroe: " + e.getMessage());
        }
    }

    @Override
    public Optional<Hero> findByEstadoHero(String estadoHero) throws IOException, SQLException {
        try {
            return heroRepository.findByEstadoHero(estadoHero);
        } catch (Exception e) {
            // Manejo general para otras excepciones
            throw new IOException("Error al buscar estado del heroe: " + e.getMessage());
        }
    }

    @Override
    public Optional<Hero> findByFotoUrlHero(String fotoUrlHero) throws IOException, SQLException {
        try {
            return heroRepository.findByFotoUrlHero(fotoUrlHero);
        } catch (Exception e) {
            // Manejo general para otras excepciones
            throw new IOException("Error al buscar héroe por URL de foto: " + e.getMessage());
        }
    }

    @Override
    public Hero createHero(Hero hero) throws IOException {
        if (hero == null) {
            throw new IOException("El Heroe no puede ser nulo ");
        }
        if (hero.getIdHero() != null && heroRepository.existsById(hero.getIdHero())) {
            throw new IOException("Ya existe un Heroe con ese ID: "  + hero.getIdHero());
        }
        return heroRepository.save(hero);
    }

    @Override
    public Hero updateHero(Long idHero, Hero heroDetails) throws IOException {
        Hero hero = heroRepository.findById(idHero)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hero not found with id " + idHero));

        try {
            hero.setNombreHero(heroDetails.getNombreHero());
            hero.setAliasHero(heroDetails.getAliasHero());
            hero.setFechaCreacionHero(heroDetails.getFechaCreacionHero());
            hero.setEstadoHero(heroDetails.getEstadoHero());
            hero.setFotoUrlHero(heroDetails.getFotoUrlHero());

            Identification identification = heroDetails.getIdentification();
            if (identification != null) {
                identification.setHero(hero);
                hero.setIdentification(identification);
            }

            hero.setPowers(heroDetails.getPowers());

            return heroRepository.save(hero);
        } catch (Exception e) {
            throw new IOException("Error updating hero", e);
        }
    }

    @Override
    public void deleteHero(Long idHero) throws IOException {
        Optional<Hero> hero = heroRepository.findById(idHero);
        if (hero.isPresent()) {
            heroRepository.delete(hero.get());
        } else {
            throw new IOException("No se ha encontrado un Heroe con ese ID: " + idHero);
        }
    }
}
