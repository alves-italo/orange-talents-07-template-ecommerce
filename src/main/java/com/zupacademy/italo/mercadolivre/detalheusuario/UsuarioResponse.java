package com.zupacademy.italo.mercadolivre.detalheusuario;

import com.zupacademy.italo.mercadolivre.cadastrousuario.Usuario;

public class UsuarioResponse {
    private final String username;

    public UsuarioResponse(Usuario usuario) {
        this.username = usuario.getUsername();
    }

    public String getUsername() {
        return username;
    }
}
