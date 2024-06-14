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

    @GetMapping("/getHeros")
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

    @GetMapping("/getHero/idHero/{idHero}")
    public ResponseEntity<Optional<Hero>> findByIdHero(@PathVariable("idHero") Long idHero) {
        try {
            Optional<Hero> hero = heroService.findByIdHero(idHero);
            return ResponseEntity.ok(hero);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/getHero/aliasHero/{aliasHero}")
    public ResponseEntity<Optional<Hero>> findHeroeByAliasHero(@PathVariable("aliasHero") String aliasHero) {
        try {
            Optional<Hero> hero = heroService.findByAliasHero(aliasHero);
            return ResponseEntity.ok(hero);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/getHero/nombreHero/{nombreHero}")
    public ResponseEntity<Optional<Hero>> findHeroeByNombreHero(@PathVariable("nombreHero") String nombreHero) {
        try {
            Optional<Hero> hero = heroService.findByNombreHero(nombreHero);
            return ResponseEntity.ok(hero);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/getHero/fechaCreacionHero/{fechaCreacionHero}")
    public ResponseEntity<Optional<Hero>> findHeroeByFechaCreacionHero(@PathVariable("fechaCreacionHero") LocalDate fechaCreacionHero) {
        try {
            Optional<Hero> hero = heroService.findByFechaCreacionHero(fechaCreacionHero);
            return ResponseEntity.ok(hero);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/getHero/estadoHero/{estadoHero}")
    public ResponseEntity<Optional<Hero>> findHeroeByEstadoHero(@PathVariable("estadoHero") String estadoHero) {
        try {
            Optional<Hero> hero = heroService.findByEstadoHero(estadoHero);
            return ResponseEntity.ok(hero);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/postHero")
    public ResponseEntity<?> createHeroe(@RequestBody Hero hero) {
        try {
            Hero createdHero = heroService.createHero(hero);
            return new ResponseEntity<>(createdHero, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>("ERROR: informacion no valida: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/putHero/{idHero}")
    public ResponseEntity<Hero> updateHero(@PathVariable("idHero") Long idHero, @RequestBody Hero heroDetails) {
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

    @DeleteMapping("/deleteHero/{idHero}")
    public ResponseEntity<?> deleteHeroe(@PathVariable("idHero") Long idHero) {
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
