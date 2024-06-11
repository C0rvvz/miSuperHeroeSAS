package udem.edu.co.miSuperHeroeSAS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import udem.edu.co.miSuperHeroeSAS.entities.Hero;
import udem.edu.co.miSuperHeroeSAS.service.HeroService;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/hero")
public class HeroController {
    @Autowired
    HeroService heroService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getHero")
    public List<Hero> findAllHeros(){
        try {
            return this.heroService.findAllHeros();
        } catch (IOException e) {
            System.err.println("ERROR: informacion no valida:\n");
            return null;
        } catch (SQLException e) {
            System.err.println("ERROR: No existen heroes:\n");
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getHero/{idHero}")
    public Optional<Hero> findByIdHero(@PathVariable("idHero") Long idHero) {
        try {
            return this.heroService.findByIdHero(idHero);
        } catch (IOException e) {
            System.err.println("ERROR: informacion no valida:\n");
            return null;
        } catch (SQLException e) {
            System.err.println("ERROR: El id no existe:\n");
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getHeroe/aliasHero/{aliasHero}")
    public Optional<Hero> findHeroeByAliasHero(@PathVariable("aliasHero") String aliasHero){
        try {
            return this.heroService.findByAliasHero(aliasHero);
        } catch (IOException e) {
            System.err.println("ERROR: informacion no valida:\n");
            return null;
        } catch (SQLException e) {
            System.err.println("ERROR: El alias no existe:\n");
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getHeroe/nombreHero/{nombreHero}")
    public Optional<Hero> findHeroeByNombreHero(@PathVariable("nombreHero") String nombreHero){
        try {
            return this.heroService.findByNombreHero(nombreHero);
        } catch (IOException e) {
            System.err.println("ERROR: informacion no valida:\n");
            return null;
        } catch (SQLException e) {
            System.err.println("ERROR: El nombre no existe:\n");
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getHeroe/fechaCreacionHero/{fechaCreacionHero}")
    public Optional<Hero> findHeroeByFechaCreacionHero(@PathVariable("fechaCreacionHero") LocalDate fechaCreacionHero){
        try {
            return this.heroService.findByFechaCreacionHero(fechaCreacionHero);
        } catch (IOException e) {
            System.err.println("ERROR: informacion no valida:\n");
            return null;
        } catch (SQLException e) {
            System.err.println("ERROR: La fecha no existe:\n");
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getHeroe/estadoHero/{estadoHero}")
    public Optional<Hero> findHeroeByEstadoHero(@PathVariable("estadoHero") String estadoHero){
        try {
            return this.heroService.findByEstadoHero(estadoHero);
        } catch (IOException e) {
            System.err.println("ERROR: informacion no valida:\n");
            return null;
        } catch (SQLException e) {
            System.err.println("ERROR: El estado no existe:\n");
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getHeroe/fotoUrlHero/{fotoUrlHero}")
    public Optional<Hero> findHeroeByFotoUrlHero(@PathVariable("fotoUrlHero") String fotoUrlHero){
        try {
            return this.heroService.findByFotoUrlHero(fotoUrlHero);
        } catch (IOException e) {
            System.err.println("ERROR: informacion no valida:\n");
            return null;
        } catch (SQLException e) {
            System.err.println("ERROR:La foto no existe:\n");
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/createHero")
    public Hero createHeroe(@RequestBody() Hero hero){
        try {
            return this.heroService.createHero(hero);
        } catch (IOException e) {
            System.err.println("ERROR: informacion no valida:\n");
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/putHeroe/{idHero}")
    public Hero updateHero(@PathVariable("idHero") Long idHero , @RequestBody() Hero hero){
        try {
            return this.heroService.updateHero(idHero, hero);
        } catch (IOException e) {
            System.err.println("ERROR: informacion no valida:\n");
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/deleteHeroe/{idHero}")
    public void deleteHeroe(@PathVariable("idHero") Long idHero){
        try {
            this.heroService.deleteHero(idHero);
        } catch (IOException e) {
            System.err.println("ERROR: informacion no valida:\n");
        }
    }
}
