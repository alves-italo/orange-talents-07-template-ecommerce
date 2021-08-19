package com.zupacademy.italo.mercadolivre.cadastrousuario;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaSegura {
    private final String senha;

    public SenhaSegura(String senha) {
        this.senha = senha;
    }

    public String criptografa() {
        return new BCryptPasswordEncoder().encode(this.senha);
    }
}
