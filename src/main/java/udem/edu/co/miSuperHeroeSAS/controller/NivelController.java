package udem.edu.co.miSuperHeroeSAS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import udem.edu.co.miSuperHeroeSAS.service.IdentificationService;
import udem.edu.co.miSuperHeroeSAS.service.NivelService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/nivel")
public class NivelController {
    @Autowired
    NivelService nivelService;
}
