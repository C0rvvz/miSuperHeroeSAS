package udem.edu.co.miSuperHeroeSAS.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udem.edu.co.miSuperHeroeSAS.repository.NivelRepository;
import udem.edu.co.miSuperHeroeSAS.service.NivelService;

@Service
public class NivelServiceImpl implements NivelService {
    @Autowired
    private NivelRepository nievelRepository;
}
