package udem.edu.co.miSuperHeroeSAS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import udem.edu.co.miSuperHeroeSAS.entities.Hero;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {
    @Query("SELECT h FROM Hero h WHERE h.nombreHero = :nombreHero")
    Optional<Hero> findByNombreHero(@Param("nombreHero") String nombreHero);

    @Query("SELECT h FROM Hero h WHERE h.aliasHero = :aliasHero")
    Optional<Hero> findByAliasHero(@Param("aliasHero") String aliasHero);

    @Query("SELECT h FROM Hero h WHERE h.estadoHero = :estadoHero")
    Optional<Hero> findByEstadoHero(@Param("estadoHero") String estadoHero);

    @Query("SELECT h FROM Hero h WHERE h.fotoUrlHero = :fotoUrlHero")
    Optional<Hero> findByFotoUrlHero(@Param("fotoUrlHero") String fotoUrlHeroHero);

    @Query("SELECT h FROM Hero h WHERE h.fechaCreacionHero = :fechaCreacionHero")
    Optional<Hero> findByFechaCreacionHero(@Param("fechaCreacionHero") LocalDate fechaCreacionHero);
}
