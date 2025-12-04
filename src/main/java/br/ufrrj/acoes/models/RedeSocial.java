package br.ufrrj.acoes.models;

import jakarta.persistence.*;

@Entity
@Table(name = "rede_social")
public class RedeSocial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private RedeSocialEnum tipo;
    
    @Column(nullable = false)
    private String link;

    public RedeSocial() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RedeSocialEnum getTipo() {
        return tipo;
    }

    public void setTipo(RedeSocialEnum tipo) {
        this.tipo = tipo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
