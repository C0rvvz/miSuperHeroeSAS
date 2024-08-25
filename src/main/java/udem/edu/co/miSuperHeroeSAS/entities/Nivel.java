package udem.edu.co.miSuperHeroeSAS.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="nivel")
public class Nivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNivel;

    private int nivel;

    @ManyToOne
    @JoinColumn(name = "id_hero")
    @JsonBackReference
    private Hero hero;

    public Nivel() {
    }

    public Nivel(Long idNivel, int nivel, Hero hero) {
        this.idNivel = idNivel;
        this.nivel = nivel;
        this.hero = hero;
    }

    public Long getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(Long idNivel) {
        this.idNivel = idNivel;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
}
