package udem.edu.co.miSuperHeroeSAS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import udem.edu.co.miSuperHeroeSAS.entities.Hero;
import udem.edu.co.miSuperHeroeSAS.service.HeroService;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/hero")
public class HeroController {
    @Autowired
    HeroService heroService;

    @GetMapping("/")
    public ResponseEntity<List<Hero>> findAllHeros() {
        try {
            List<Hero> heroes = heroService.findAllHeros();
            return ResponseEntity.ok(heroes);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/idhero/{idhero}")
    public ResponseEntity<Optional<Hero>> findByIdHero(@PathVariable("idhero") Long idHero) {
        try {
            Optional<Hero> hero = heroService.findByIdHero(idHero);
            return ResponseEntity.ok(hero);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/aliashero/{aliashero}")
    public ResponseEntity<Optional<Hero>> findHeroeByAliasHero(@PathVariable("aliashero") String aliasHero) {
        try {
            Optional<Hero> hero = heroService.findByAliasHero(aliasHero);
            return ResponseEntity.ok(hero);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/nombrehero/{nombrehero}")
    public ResponseEntity<Optional<Hero>> findHeroeByNombreHero(@PathVariable("nombrehero") String nombreHero) {
        try {
            Optional<Hero> hero = heroService.findByNombreHero(nombreHero);
            return ResponseEntity.ok(hero);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/fechacreacionhero/{fechacreacionhero}")
    public ResponseEntity<Optional<Hero>> findHeroeByFechaCreacionHero(@PathVariable("fechacreacionhero") LocalDate fechaCreacionHero) {
        try {
            Optional<Hero> hero = heroService.findByFechaCreacionHero(fechaCreacionHero);
            return ResponseEntity.ok(hero);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/estadohero/{estadohero}")
    public ResponseEntity<Optional<Hero>> findHeroeByEstadoHero(@PathVariable("estadohero") String estadoHero) {
        try {
            Optional<Hero> hero = heroService.findByEstadoHero(estadoHero);
            return ResponseEntity.ok(hero);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> createHeroe(@RequestBody Hero hero) {
        try {
            Hero createdHero = heroService.createHero(hero);
            return new ResponseEntity<>(createdHero, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>("ERROR: informacion no valida: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{idhero}")
    public ResponseEntity<Hero> updateHero(@PathVariable("idhero") Long idHero, @RequestBody Hero heroDetails) {
        try {
            Hero updatedHero = heroService.updateHero(idHero, heroDetails);
            return ResponseEntity.ok(updatedHero);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(null);
        } catch (IOException e) {
            System.err.println("ERROR: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{idhero}")
    public ResponseEntity<?> deleteHeroe(@PathVariable("idhero") Long idHero) {
        try {
            heroService.deleteHero(idHero);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IOException e) {
            return new ResponseEntity<>("ERROR: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>("ERROR: " + e.getReason(), e.getStatusCode());
        }
    }
}
