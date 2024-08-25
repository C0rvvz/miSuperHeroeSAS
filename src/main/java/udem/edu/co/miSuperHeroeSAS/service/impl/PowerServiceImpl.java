package udem.edu.co.miSuperHeroeSAS.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import udem.edu.co.miSuperHeroeSAS.entities.Power;
import udem.edu.co.miSuperHeroeSAS.repository.PowerRepository;
import udem.edu.co.miSuperHeroeSAS.service.PowerService;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PowerServiceImpl implements PowerService {
    @Autowired
    private PowerRepository powerRepository;

    @Override
    public List<Power> findAllPowers() {

            return (List<Power>) powerRepository.findAll();

    }

    @Override
    public Optional<Power> findByIdPower(Long idPower) {

            return powerRepository.findById(idPower);

    }

    @Override
    public Optional<Power> findByNombrePower(String nombrePower) {
            return powerRepository.findByNombrePower(nombrePower);

    }

    @Override
    public Optional<Power> findByFechaAdquisicionPower(LocalDate fechaAdquisicionPower)  {

            return powerRepository.findByFechaAdquisicionPower(fechaAdquisicionPower);

    }

    @Override
    public Optional<Power> findByNivelPower(Long idNivel, int nivel) {
        return nivelRepository.findByNivel(nivel);
    }

    @Override
    public Optional<Power> findByDescripcionPower(String descripcionPower){

            return powerRepository.findByDescripcionPower(descripcionPower);

    }

    @Override
    public Power createPower(Power power)  {

        return powerRepository.save(power);
    }

    @Override
    public Power updatePower(Long idPower, Power powerDetails) {
        Optional<Power> optionalPower = powerRepository.findById(idPower);
        if (optionalPower.isPresent()) {
            Power power = optionalPower.get();

            power.setNombrePower(powerDetails.getNombrePower());
            power.setFechaAdquisicionPower(powerDetails.getFechaAdquisicionPower());
            power.setDescripcionPower(powerDetails.getDescripcionPower());
            power.setHero(powerDetails.getHero());

            return powerRepository.save(power);
        }
        return powerDetails;
    }

    @Override
    public void deletePower(Long idPower) {
        Optional<Power> power = powerRepository.findById(idPower);
            powerRepository.delete(power.get());

    }
}
