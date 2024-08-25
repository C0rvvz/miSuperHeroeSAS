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


    @GetMapping("/")
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

    @GetMapping("/idpower/{idpower}")
    public ResponseEntity<Optional<Power>> findByIdPower(@PathVariable("idpower") Long idPower) {
        try {
            Optional<Power> power = powerService.findByIdPower(idPower);
            return ResponseEntity.ok(power);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/nombrepower/{nombrepower}")
    public ResponseEntity<Optional<Power>> findByNombrePower(@PathVariable("nombrepower") String nombrePower) {
        try {
            Optional<Power> power = powerService.findByNombrePower(nombrePower);
            return ResponseEntity.ok(power);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/fechaadquisicionpower/{fechaadquisicionpower}")
    public ResponseEntity<Optional<Power>> findByFechaAdquisicionPower(@PathVariable("fechaadquisicionpower") LocalDate fechaAdquisicionPower) {
        try {
            Optional<Power> power = powerService.findByFechaAdquisicionPower(fechaAdquisicionPower);
            return ResponseEntity.ok(power);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/nivelpower/{nivelpower}")
    public ResponseEntity<Optional<Power>> findByNivelPower(@PathVariable("nivelpower") int nivelPower) {
        try {
            Optional<Power> power = powerService.findByNivelPower(nivelPower);
            return ResponseEntity.ok(power);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/descripcionpower/{descripcionpower}")
    public ResponseEntity<Optional<Power>> findByDescripcionPower(@PathVariable("descripcionpower") String descripcionPower) {
        try {
            Optional<Power> power = powerService.findByDescripcionPower(descripcionPower);
            return ResponseEntity.ok(power);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Power> createPower(@RequestBody Power power) {
        try {
            Power createdPower = powerService.createPower(power);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPower);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/{idpower}")
    public ResponseEntity<Power> updatePower(@PathVariable("idpower") Long idPower, @RequestBody Power power) {
        try {
            Power updatedPower = powerService.updatePower(idPower, power);
            return ResponseEntity.ok(updatedPower);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{idpower}")
    public ResponseEntity<Void> deletePower(@PathVariable("idpower") Long idPower) {
        try {
            powerService.deletePower(idPower);
            return ResponseEntity.noContent().build();
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
