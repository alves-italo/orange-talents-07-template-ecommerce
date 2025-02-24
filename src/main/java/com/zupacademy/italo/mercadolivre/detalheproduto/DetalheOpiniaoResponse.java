package com.zupacademy.italo.mercadolivre.detalheproduto;

import com.zupacademy.italo.mercadolivre.cadastroopiniao.Opiniao;
import com.zupacademy.italo.mercadolivre.detalheusuario.UsuarioResponse;

public class DetalheOpiniaoResponse {
    private final Integer nota;
    private final String titulo;
    private final String descricao;

    private final UsuarioResponse usuario;

    public DetalheOpiniaoResponse(Opiniao opiniao) {
        this.nota = opiniao.getNota();
        this.titulo = opiniao.getTitulo();
        this.descricao = opiniao.getDescricao();
        this.usuario = new UsuarioResponse(opiniao.getUsuario());
    }

    public Integer getNota() {
        return nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public UsuarioResponse getUsuario() {
        return usuario;
    }
}
