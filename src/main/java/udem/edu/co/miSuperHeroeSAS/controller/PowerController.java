package udem.edu.co.miSuperHeroeSAS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import udem.edu.co.miSuperHeroeSAS.entities.Power;
import udem.edu.co.miSuperHeroeSAS.service.PowerService;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/power")
public class PowerController {
    @Autowired
    PowerService powerService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getPower")
    public List<Power> findAllPowers(){
        try {
            return this.powerService.findAllPowers();
        } catch (IOException e) {
            System.err.println("ERROR: informacion no valida:\n");
            return null;
        } catch (SQLException e) {
            System.err.println("ERROR: No existen poderes:\n");
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getPower/{idPower}")
    public Optional<Power> findByIdPower(@PathVariable("idPower") Long idPower) {
        try {
            return this.powerService.findByIdPower(idPower);
        } catch (IOException e) {
            System.err.println("ERROR: informacion no valida:\n");
            return null;
        } catch (SQLException e) {
            System.err.println("ERROR: El id no existe:\n");
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getPower/nombrePower/{nombrePower}")
    public Optional<Power> findByNombrePower(@PathVariable("nombrePower") String nombrePower){
        try {
            return this.powerService.findByNombrePower(nombrePower);
        } catch (IOException e) {
            System.err.println("ERROR: informacion no valida:\n");
            return null;
        } catch (SQLException e) {
            System.err.println("ERROR: El alias no existe:\n");
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getPower/fechaAdquisicionPower/{fechaAdquisicionPower}")
    public Optional<Power> findByFechaAdquisicionPower(@PathVariable("fechaAdquisicionPower") LocalDate fechaAdquisicionPower){
        try {
            return this.powerService.findByFechaAdquisicionPower(fechaAdquisicionPower);
        } catch (IOException e) {
            System.err.println("ERROR: informacion no valida:\n");
            return null;
        } catch (SQLException e) {
            System.err.println("ERROR: El alias no existe:\n");
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getPower/nivelPower/{nivelPower}")
    public Optional<Power> findByNivelPower(@PathVariable("nivelPower") int nivelPower){
        try {
            return this.powerService.findByNivelPower(nivelPower);
        } catch (IOException e) {
            System.err.println("ERROR: informacion no valida:\n");
            return null;
        } catch (SQLException e) {
            System.err.println("ERROR: El alias no existe:\n");
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getPower/descripcionPower/{descripcionPower}")
    public Optional<Power> findByDescripcionPower(@PathVariable("descripcionPower") String descripcionPower){
        try {
            return this.powerService.findByDescripcionPower(descripcionPower);
        } catch (IOException e) {
            System.err.println("ERROR: informacion no valida:\n");
            return null;
        } catch (SQLException e) {
            System.err.println("ERROR: El alias no existe:\n");
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/createPower")
    public Power createPower(@RequestBody() Power power){
        try {
            return this.powerService.createPower(power);
        } catch (IOException e) {
            System.err.println("ERROR: informacion no valida:\n");
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/putPower/{idPower}")
    public Power updatePower(@PathVariable("idPower") Long idPower , @RequestBody() Power power){
        try {
            return this.powerService.updatePower(idPower, power);
        } catch (IOException e) {
            System.err.println("ERROR: informacion no valida:\n");
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/deletePower/{idPower}")
    public void deletePower(@PathVariable("idPower") Long idPower){
        try {
            this.powerService.deletePower(idPower);
        } catch (IOException e) {
            System.err.println("ERROR: informacion no valida:\n");
        }
    }
}
