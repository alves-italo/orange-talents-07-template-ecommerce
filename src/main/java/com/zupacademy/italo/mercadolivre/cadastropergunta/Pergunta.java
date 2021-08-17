package com.zupacademy.italo.mercadolivre.cadastropergunta;

import com.zupacademy.italo.mercadolivre.cadastroproduto.Produto;
import com.zupacademy.italo.mercadolivre.cadastrousuario.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Pergunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String titulo;

    @ManyToOne
    private Produto produto;

    @ManyToOne
    private Usuario autor;

    @Deprecated
    public Pergunta() {
    }

    public Pergunta(String titulo, Produto produto, Usuario autor) {
        this.titulo = titulo;
        this.produto = produto;
        this.autor = autor;
    }
}
