package com.zupacademy.italo.mercadolivre.detalheproduto;

import com.zupacademy.italo.mercadolivre.cadastropergunta.Pergunta;

public class DetalhePerguntaResponse {
    private String titulo;
    private String autor;

    public DetalhePerguntaResponse(Pergunta pergunta) {
        this.titulo = pergunta.getTitulo();
        this.autor = pergunta.getAutor().getUsername();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }
}
