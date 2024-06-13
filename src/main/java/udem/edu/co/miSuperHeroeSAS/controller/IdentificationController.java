package udem.edu.co.miSuperHeroeSAS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udem.edu.co.miSuperHeroeSAS.entities.Identification;
import udem.edu.co.miSuperHeroeSAS.service.IdentificationService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/identification")
public class IdentificationController {
    @Autowired
    IdentificationService identificationService;


    @GetMapping("/getIdentification")
    public ResponseEntity<List<Identification>> findAllIdentifications() {
        try {
            List<Identification> identifications = identificationService.findAllIdentifications();
            return ResponseEntity.ok(identifications);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/getIdentification/idIdentification/{idIdentification}")
    public ResponseEntity<Optional<Identification>> findByIdIdentification(@PathVariable("idIdentification") Long idIdentification) {
        try {
            Optional<Identification> identification = identificationService.findByIdIdentification(idIdentification);
            return ResponseEntity.ok(identification);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @GetMapping("/getIdentification/tipoIdentification/{tipoIdentification}")
    public ResponseEntity<Optional<Identification>> findByTipoIdentification(@PathVariable("tipoIdentification") String tipoIdentification) {
        try {
            Optional<Identification> identification = identificationService.findByTipoIdentification(tipoIdentification);
            return ResponseEntity.ok(identification);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/getIdentification/descripcionIdentification/{descripcionIdentification}")
    public ResponseEntity<Optional<Identification>> findByDescripcionIdentification(@PathVariable("descripcionIdentification") String descripcionIdentification) {
        try {
            Optional<Identification> identification = identificationService.findByDescripcionIdentification(descripcionIdentification);
            return ResponseEntity.ok(identification);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @PostMapping("/postIdentification")
    public ResponseEntity<Identification> createIdentification(@RequestBody Identification identification) {
        try {
            Identification createdIdentification = identificationService.createIdentification(identification);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdIdentification);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


    @PutMapping("/putIdentification/{idIdentification}")
    public ResponseEntity<Identification> updateIdentification(@PathVariable("idIdentification") Long idIdentification, @RequestBody Identification identification) {
        try {
            Identification updatedIdentification = identificationService.updateIdentification(idIdentification, identification);
            return ResponseEntity.ok(updatedIdentification);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


    @DeleteMapping("/deleteIdentification/{idIdentification}")
    public ResponseEntity<Void> deleteIdentification(@PathVariable("idIdentification") Long idIdentification) {
        try {
            identificationService.deleteIdentification(idIdentification);
            return ResponseEntity.noContent().build();
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
