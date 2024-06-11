package udem.edu.co.miSuperHeroeSAS.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="power")
public class Power {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPower;

    private String nombrePower;
    private LocalDate fechaAdquisicionPower;
    private int nivelPower;
    private String descripcionPower;

    @ManyToOne
    @JoinColumn(name = "heroe_id")
    @JsonBackReference
    private Hero hero;

    public Power() {
    }

    public Power(Long idPower, String nombrePower, LocalDate fechaAdquisicionPower, int nivelPower, String descripcionPower, Hero hero) {
        this.idPower = idPower;
        this.nombrePower = nombrePower;
        this.fechaAdquisicionPower = fechaAdquisicionPower;
        this.nivelPower = nivelPower;
        this.descripcionPower = descripcionPower;
        this.hero = hero;
    }

    public Long getIdPower() {
        return idPower;
    }

    public void setIdPower(Long idPower) {
        this.idPower = idPower;
    }

    public String getNombrePower() {
        return nombrePower;
    }

    public void setNombrePower(String nombrePower) {
        this.nombrePower = nombrePower;
    }

    public LocalDate getFechaAdquisicionPower() {
        return fechaAdquisicionPower;
    }

    public void setFechaAdquisicionPower(LocalDate fechaAdquisicionPower) {
        this.fechaAdquisicionPower = fechaAdquisicionPower;
    }

    public int getNivelPower() {
        return nivelPower;
    }

    public void setNivelPower(int nivelPower) {
        this.nivelPower = nivelPower;
    }

    public String getDescripcionPower() {
        return descripcionPower;
    }

    public void setDescripcionPower(String descripcionPower) {
        this.descripcionPower = descripcionPower;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
}
