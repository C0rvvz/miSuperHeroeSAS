package udem.edu.co.miSuperHeroeSAS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import udem.edu.co.miSuperHeroeSAS.entities.Power;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface PowerRepository extends JpaRepository<Power, Long> {
    @Query("SELECT p FROM Power p WHERE p.nombrePower = :nombrePower")
    Optional<Power> findByNombrePower(@Param("nombrePower") String nombrePower);

    @Query("SELECT p FROM Power p WHERE p.fechaAdquisicionPower = :fechaAdquisicionPower")
    Optional<Power> findByFechaAdquisicionPower(@Param("fechaAdquisicionPower") LocalDate fechaAdquisicionPower);

    @Query("SELECT p FROM Power p WHERE p.nivelPower = :nivelPower")
    Optional<Power> findByNivelPower(@Param("nivelPower") int nivelPower);

    @Query("SELECT p FROM Power p WHERE p.descripcionPower = :descripcionPower")
    Optional<Power> findByDescripcionPower(@Param("descripcionPower") String descripcionPower);
}
