package br.ufrrj.acoes.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "atividade")
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column
    private String nome;

    @Column(length = 3000)
    private String descricao;
    
    @Column
    private LocalDateTime inicio;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "atividade_id")
    private List<RedeSocial> redesSociais = new ArrayList<>();


    public Atividade() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public List<RedeSocial> getRedesSociais() {
        return redesSociais;
    }

    public void setRedesSociais(List<RedeSocial> redesSociais) {
        this.redesSociais = redesSociais;
    }
}
