package com.zupacademy.italo.mercadolivre.novousuario;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank
    private String login;

    @NotBlank
    private String senha;

    @CreationTimestamp
    @PastOrPresent
    private LocalDateTime criacao;

    public Usuario(String login, SenhaSegura senha) {
        this.login = login;
        this.senha = senha.criptografa();
    }
}
