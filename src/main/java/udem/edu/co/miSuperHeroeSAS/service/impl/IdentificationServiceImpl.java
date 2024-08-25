package udem.edu.co.miSuperHeroeSAS.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import udem.edu.co.miSuperHeroeSAS.entities.Hero;
import udem.edu.co.miSuperHeroeSAS.entities.Identification;
import udem.edu.co.miSuperHeroeSAS.repository.IdentificationRepository;
import udem.edu.co.miSuperHeroeSAS.service.IdentificationService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class IdentificationServiceImpl implements IdentificationService {
    @Autowired
    private IdentificationRepository identificationRepository;

    @Override
    public List<Identification> findAllIdentifications()  {

            return (List<Identification>) identificationRepository.findAll();

    }

    @Override
    public Optional<Identification> findByIdIdentification(Long idIdentification) {

            return identificationRepository.findById(idIdentification);

    }

    @Override
    public Optional<Identification> findByTipoIdentification(String tipoIdentification)  {

            return identificationRepository.findByTipoIdentification(tipoIdentification);

    }

    public Optional<Identification> findByDescripcionIdentification(String descripcionIdentification) {

            return identificationRepository.findByDescripcionIdentification(descripcionIdentification);

    }

    @Override
    public Identification createIdentification(Identification identification) {


        return identificationRepository.save(identification);
    }

    @Override
    public Identification updateIdentification(Long idIdentification, Identification identificationD) {
        Optional<Identification> optionalIdentification = identificationRepository.findById(idIdentification);
        if (optionalIdentification.isPresent()) {
            Identification identification = optionalIdentification.get();

            identification.setTipoIdentification(identificationD.getTipoIdentification());
            identification.setDescripcionIdentification(identificationD.getDescripcionIdentification());

            return identificationRepository.save(identification);
        }
        return identificationD;
    }
    @Override
    public void deleteIdentification(Long idIdentification) {
        Optional<Identification> identification = identificationRepository.findById(idIdentification);
            identificationRepository.delete(identification.get());

    }
}
