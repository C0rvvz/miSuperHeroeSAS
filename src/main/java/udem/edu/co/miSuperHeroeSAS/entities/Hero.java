package udem.edu.co.miSuperHeroeSAS.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="hero")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHero;

    private String nombreHero;
    private String aliasHero;
    private LocalDate fechaCreacionHero;
    private String estadoHero;
    private String fotoUrlHero;  // Para almacenar la URL de la foto

    @OneToOne(mappedBy = "hero", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Identification identification;

    @OneToMany(mappedBy = "hero", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Power> powers;

    public Hero() {
    }

    public Hero(Long idHero, String nombreHero, String aliasHero, LocalDate fechaCreacionHero, String estadoHero, String fotoUrlHero, Identification identification, List<Power> powers) {
        this.idHero = idHero;
        this.nombreHero = nombreHero;
        this.aliasHero = aliasHero;
        this.fechaCreacionHero = fechaCreacionHero;
        this.estadoHero = estadoHero;
        this.fotoUrlHero = fotoUrlHero;
        this.identification = identification;
        this.powers = powers;
    }

    public Long getIdHero() {
        return idHero;
    }

    public void setIdHero(Long idHero) {
        this.idHero = idHero;
    }

    public String getNombreHero() {
        return nombreHero;
    }

    public void setNombreHero(String nombreHero) {
        this.nombreHero = nombreHero;
    }

    public String getAliasHero() {
        return aliasHero;
    }

    public void setAliasHero(String aliasHero) {
        this.aliasHero = aliasHero;
    }

    public LocalDate getFechaCreacionHero() {
        return fechaCreacionHero;
    }

    public void setFechaCreacionHero(LocalDate fechaCreacionHero) {
        this.fechaCreacionHero = fechaCreacionHero;
    }

    public String getEstadoHero() {
        return estadoHero;
    }

    public void setEstadoHero(String estadoHero) {
        this.estadoHero = estadoHero;
    }

    public String getFotoUrlHero() {
        return fotoUrlHero;
    }

    public void setFotoUrlHero(String fotoUrlHero) {
        this.fotoUrlHero = fotoUrlHero;
    }

    public Identification getIdentification() {
        return identification;
    }

    public void setIdentification(Identification identification) {
        this.identification = identification;
    }

    public List<Power> getPowers() {
        return powers;
    }

    public void setPowers(List<Power> powers) {
        this.powers = powers;
    }
}
