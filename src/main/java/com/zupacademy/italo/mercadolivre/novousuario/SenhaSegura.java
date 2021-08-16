package com.zupacademy.italo.mercadolivre.novousuario;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaSegura {
    private String senha;

    public SenhaSegura(String senha) {
        this.senha = senha;
    }

    public String criptografa() {
        return new BCryptPasswordEncoder().encode(this.senha);
    }
}
