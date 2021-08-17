package com.zupacademy.italo.mercadolivre.cadastrocategoria;

import javax.persistence.*;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    private Categoria mae;

    @Deprecated
    public Categoria() {
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public void setMae(Categoria mae) {
        this.mae = mae;
    }
}
