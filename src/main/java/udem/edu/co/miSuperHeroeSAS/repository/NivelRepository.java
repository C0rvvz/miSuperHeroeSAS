package udem.edu.co.miSuperHeroeSAS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import udem.edu.co.miSuperHeroeSAS.entities.Nivel;
import udem.edu.co.miSuperHeroeSAS.entities.Power;

import java.util.Optional;

@Repository
public interface NivelRepository extends JpaRepository<Nivel, Long> {
    @Query("SELECT p FROM Nivel p WHERE p.nivel = :nivel")
    Optional<Nivel> findByNivel(@Param("nivel") int nivel);
}
