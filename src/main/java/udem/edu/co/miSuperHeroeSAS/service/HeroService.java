package udem.edu.co.miSuperHeroeSAS.service;

import org.springframework.stereotype.Service;
import udem.edu.co.miSuperHeroeSAS.entities.Hero;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public interface HeroService {
    public List<Hero> findAllHeros() throws IOException, SQLException;
    public Optional<Hero> findByIdHero(Long idHero) throws IOException, SQLException;
    public Optional<Hero> findByNombreHero(String nombreHero) throws IOException, SQLException;
    public Optional<Hero> findByAliasHero(String aliasHero) throws IOException, SQLException;
    public Optional<Hero> findByFechaCreacionHero(LocalDate fechaCreacionHero) throws IOException, SQLException;
    public Optional<Hero> findByEstadoHero(String estadoHero) throws IOException, SQLException;
    public Optional<Hero> findByFotoUrlHero(String fotoUrlHero) throws IOException, SQLException;
    public Hero createHero(Hero hero) throws IOException;
    public Hero updateHero(Long idHero, Hero heroe) throws IOException;
    public void deleteHero(Long idHero) throws IOException;
}
