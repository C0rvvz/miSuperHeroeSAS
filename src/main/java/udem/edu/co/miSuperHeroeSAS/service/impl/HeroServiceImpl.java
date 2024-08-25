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
    public List<Hero> findAllHeros(){

            return (List<Hero>) heroRepository.findAll();

    }

    @Override
    public Optional<Hero> findByIdHero(Long idHero){
            return heroRepository.findById(idHero);

    }

    @Override
    public Optional<Hero> findByNombreHero(String nombreHero){

            return heroRepository.findByNombreHero(nombreHero);

    }

    @Override
    public Optional<Hero> findByAliasHero(String aliasHero) {

            return heroRepository.findByAliasHero(aliasHero);

    }

    @Override
    public Optional<Hero> findByFechaCreacionHero(LocalDate fechaCreacionHero) {

            return heroRepository.findByFechaCreacionHero(fechaCreacionHero);

    }

    @Override
    public Optional<Hero> findByEstadoHero(String estadoHero)  {

            return heroRepository.findByEstadoHero(estadoHero);

    }

    @Override
    public Hero createHero(Hero hero) {

        return heroRepository.save(hero);
    }

    @Override
    public Hero updateHero(Long idHero, Hero heroDetails) {
        Optional<Hero> optionalHero = heroRepository.findById(idHero);
        if (optionalHero.isPresent()) {
            Hero hero = optionalHero.get();

            hero.setNombreHero(heroDetails.getNombreHero());
            hero.setAliasHero(heroDetails.getAliasHero());
            hero.setFechaCreacionHero(heroDetails.getFechaCreacionHero());
            hero.setEstadoHero(heroDetails.getEstadoHero());

            Identification identification = heroDetails.getIdentification();
            if (identification != null) {
                identification.setHero(hero);
                hero.setIdentification(identification);
            }

            hero.setPowers(heroDetails.getPowers());

            return heroRepository.save(hero);
        }
        return heroDetails;
    }


    @Override
    public void deleteHero(Long idHero){
        Optional<Hero> hero = heroRepository.findById(idHero);

            heroRepository.delete(hero.get());

    }
}
