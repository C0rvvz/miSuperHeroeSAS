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


    @GetMapping("/")
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

    @GetMapping("/ididentification/{ididentification}")
    public ResponseEntity<Optional<Identification>> findByIdIdentification(@PathVariable("ididentification") Long idIdentification) {
        try {
            Optional<Identification> identification = identificationService.findByIdIdentification(idIdentification);
            return ResponseEntity.ok(identification);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @GetMapping("/tipoidentification/{tipoidentification}")
    public ResponseEntity<Optional<Identification>> findByTipoIdentification(@PathVariable("tipoidentification") String tipoIdentification) {
        try {
            Optional<Identification> identification = identificationService.findByTipoIdentification(tipoIdentification);
            return ResponseEntity.ok(identification);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/descripcionidentification/{descripcionidentification}")
    public ResponseEntity<Optional<Identification>> findByDescripcionIdentification(@PathVariable("descripcionidentification") String descripcionIdentification) {
        try {
            Optional<Identification> identification = identificationService.findByDescripcionIdentification(descripcionIdentification);
            return ResponseEntity.ok(identification);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @PostMapping("/")
    public ResponseEntity<Identification> createIdentification(@RequestBody Identification identification) {
        try {
            Identification createdIdentification = identificationService.createIdentification(identification);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdIdentification);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


    @PutMapping("/{ididentification}")
    public ResponseEntity<Identification> updateIdentification(@PathVariable("ididentification") Long idIdentification, @RequestBody Identification identification) {
        try {
            Identification updatedIdentification = identificationService.updateIdentification(idIdentification, identification);
            return ResponseEntity.ok(updatedIdentification);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


    @DeleteMapping("/{ididentification}")
    public ResponseEntity<Void> deleteIdentification(@PathVariable("ididentification") Long idIdentification) {
        try {
            identificationService.deleteIdentification(idIdentification);
            return ResponseEntity.noContent().build();
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
