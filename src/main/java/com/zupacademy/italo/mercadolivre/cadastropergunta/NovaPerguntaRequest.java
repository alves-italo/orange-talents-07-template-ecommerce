package com.zupacademy.italo.mercadolivre.cadastropergunta;

import com.zupacademy.italo.mercadolivre.cadastroproduto.Produto;
import com.zupacademy.italo.mercadolivre.cadastrousuario.Usuario;

import javax.validation.constraints.NotBlank;

public class NovaPerguntaRequest {
    @NotBlank
    private String titulo;

    @Deprecated
    public NovaPerguntaRequest() {
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Pergunta toModel(Produto produto, Usuario usuario) {
        return new Pergunta(this.titulo, produto, usuario);
    }
}
