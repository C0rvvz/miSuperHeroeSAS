package udem.edu.co.miSuperHeroeSAS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import udem.edu.co.miSuperHeroeSAS.entities.Identification;

import java.util.Optional;

@Repository
public interface IdentificationRepository extends JpaRepository<Identification, Long> {
    @Query("SELECT i FROM Identification i WHERE i.tipoIdentification = :tipoIdentification")
    Optional<Identification> findByTipoIdentification(@Param("tipoIdentification") String tipoIdentification);

    @Query("SELECT i FROM Identification i WHERE i.numeroIdentification = :numeroIdentification")
    Optional<Identification> findByNumeroIdentification(@Param("numeroIdentification") String numeroIdentification);

    @Query("SELECT i FROM Identification i WHERE i.descripcionIdentification = :descripcionIdentification")
    Optional<Identification> findByDescripcionIdentification(@Param("descripcionIdentification") String descripcionIdentification);
}
