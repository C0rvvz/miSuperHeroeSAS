package udem.edu.co.miSuperHeroeSAS.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="identification")
public class Identification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIdentification;

    private String tipoIdentification;
    private String descripcionIdentification;

    @OneToOne
    @JoinColumn(name = "id_hero")
    @JsonBackReference
    private Hero hero;

    public Identification() {
    }

    public Identification(Long idIdentification, String tipoIdentification, Hero hero, String descripcionIdentification) {
        this.idIdentification = idIdentification;
        this.tipoIdentification = tipoIdentification;
        this.hero = hero;
        this.descripcionIdentification = descripcionIdentification;
    }

    public Long getIdIdentification() {
        return idIdentification;
    }

    public void setIdIdentification(Long idIdentification) {
        this.idIdentification = idIdentification;
    }

    public String getTipoIdentification() {
        return tipoIdentification;
    }

    public void setTipoIdentification(String tipoIdentification) {
        this.tipoIdentification = tipoIdentification;
    }

    public String getDescripcionIdentification() {
        return descripcionIdentification;
    }

    public void setDescripcionIdentification(String descripcionIdentification) {
        this.descripcionIdentification = descripcionIdentification;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
}
