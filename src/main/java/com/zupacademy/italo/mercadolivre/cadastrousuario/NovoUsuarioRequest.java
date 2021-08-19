package com.zupacademy.italo.mercadolivre.cadastrousuario;

import com.zupacademy.italo.mercadolivre.utilidades.ValorUnico;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NovoUsuarioRequest {
    @NotBlank
    @Email
    @ValorUnico(target = Usuario.class, field = "login")
    private final String login;

    @NotBlank
    @Length(min = 6)
    private final String senha;

    public NovoUsuarioRequest(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public Usuario toModel() {
        return new Usuario(login, new SenhaSegura(senha));
    }
}
