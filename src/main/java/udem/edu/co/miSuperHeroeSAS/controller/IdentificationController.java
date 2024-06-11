package udem.edu.co.miSuperHeroeSAS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import udem.edu.co.miSuperHeroeSAS.entities.Identification;
import udem.edu.co.miSuperHeroeSAS.service.IdentificationService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/identification")
public class IdentificationController {
    @Autowired
    IdentificationService identificationService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getIdentification")
    public List<Identification> findAllIdentifications(){
        try {
            return this.identificationService.findAllIdentifications();
        } catch (IOException e) {
            System.err.println("ERROR: informacion no valida:\n");
            return null;
        } catch (SQLException e) {
            System.err.println("ERROR: No existen identificaciones:\n");
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getIdentification/{idIdentification}")
    public Optional<Identification> findByIdIdentification(@PathVariable("idIdentification") Long idIdentification) {
        try {
            return this.identificationService.findByIdIdentification(idIdentification);
        } catch (IOException e) {
            System.err.println("ERROR: informacion no valida:\n");
            return null;
        } catch (SQLException e) {
            System.err.println("ERROR: El id no existe:\n");
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getIdentification/tipoIdentification/{tipoIdentification}")
    public Optional<Identification> findByTipoIdentification(@PathVariable("tipoIdentification") String tipoIdentification){
        try {
            return this.identificationService.findByTipoIdentification(tipoIdentification);
        } catch (IOException e) {
            System.err.println("ERROR: informacion no valida:\n");
            return null;
        } catch (SQLException e) {
            System.err.println("ERROR: El tipo no existe:\n");
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getIdentification/numeroIdentification/{numeroIdentification}")
    public Optional<Identification> findByNumeroIdentification(@PathVariable("numeroIdentification") String numeroIdentification){
        try {
            return this.identificationService.findByNumeroIdentification(numeroIdentification);
        } catch (IOException e) {
            System.err.println("ERROR: informacion no valida:\n");
            return null;
        } catch (SQLException e) {
            System.err.println("ERROR: El numero no existe:\n");
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getIdentification/descripcionIdentification/{descripcionIdentification}")
    public Optional<Identification> findByDescripcionIdentification(@PathVariable("descripcionIdentification") String descripcionIdentification){
        try {
            return this.identificationService.findByDescripcionIdentification(descripcionIdentification);
        } catch (IOException e) {
            System.err.println("ERROR: informacion no valida:\n");
            return null;
        } catch (SQLException e) {
            System.err.println("ERROR: La descripcion no existe:\n");
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/createIdentification")
    public Identification createIdentification(@RequestBody() Identification identification){
        try {
            return this.identificationService.createIdentification(identification);
        } catch (IOException e) {
            System.err.println("ERROR: informacion no valida:\n");
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/putIdentification/{idIdentification}")
    public Identification updateIdentification(@PathVariable("id") Long idIdentification , @RequestBody() Identification identification){
        try {
            return this.identificationService.updateIdentification(idIdentification, identification);
        } catch (IOException e) {
            System.err.println("ERROR: informacion no valida:\n");
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/deleteIdentification/{idIdentification}")
    public void deleteIdentification(@PathVariable("idIdentification") Long idIdentification){
        try {
            this.identificationService.deleteIdentification(idIdentification);
        } catch (IOException e) {
            System.err.println("ERROR: informacion no valida:\n");
        }
    }
}
