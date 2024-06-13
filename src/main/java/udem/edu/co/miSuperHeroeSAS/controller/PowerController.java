package udem.edu.co.miSuperHeroeSAS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udem.edu.co.miSuperHeroeSAS.entities.Power;
import udem.edu.co.miSuperHeroeSAS.service.PowerService;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/power")
public class PowerController {
    @Autowired
    PowerService powerService;


    @GetMapping("/getPower")
    public ResponseEntity<List<Power>> findAllPowers() {
        try {
            List<Power> powers = powerService.findAllPowers();
            return ResponseEntity.ok(powers);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/getPower/idPower/{idPower}")
    public ResponseEntity<Optional<Power>> findByIdPower(@PathVariable("idPower") Long idPower) {
        try {
            Optional<Power> power = powerService.findByIdPower(idPower);
            return ResponseEntity.ok(power);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/getPower/nombrePower/{nombrePower}")
    public ResponseEntity<Optional<Power>> findByNombrePower(@PathVariable("nombrePower") String nombrePower) {
        try {
            Optional<Power> power = powerService.findByNombrePower(nombrePower);
            return ResponseEntity.ok(power);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/getPower/fechaAdquisicionPower/{fechaAdquisicionPower}")
    public ResponseEntity<Optional<Power>> findByFechaAdquisicionPower(@PathVariable("fechaAdquisicionPower") LocalDate fechaAdquisicionPower) {
        try {
            Optional<Power> power = powerService.findByFechaAdquisicionPower(fechaAdquisicionPower);
            return ResponseEntity.ok(power);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/getPower/nivelPower/{nivelPower}")
    public ResponseEntity<Optional<Power>> findByNivelPower(@PathVariable("nivelPower") int nivelPower) {
        try {
            Optional<Power> power = powerService.findByNivelPower(nivelPower);
            return ResponseEntity.ok(power);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/getPower/descripcionPower/{descripcionPower}")
    public ResponseEntity<Optional<Power>> findByDescripcionPower(@PathVariable("descripcionPower") String descripcionPower) {
        try {
            Optional<Power> power = powerService.findByDescripcionPower(descripcionPower);
            return ResponseEntity.ok(power);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/postPower")
    public ResponseEntity<Power> createPower(@RequestBody Power power) {
        try {
            Power createdPower = powerService.createPower(power);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPower);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/putPower/{idPower}")
    public ResponseEntity<Power> updatePower(@PathVariable("idPower") Long idPower, @RequestBody Power power) {
        try {
            Power updatedPower = powerService.updatePower(idPower, power);
            return ResponseEntity.ok(updatedPower);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/deletePower/{idPower}")
    public ResponseEntity<Void> deletePower(@PathVariable("idPower") Long idPower) {
        try {
            powerService.deletePower(idPower);
            return ResponseEntity.noContent().build();
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
