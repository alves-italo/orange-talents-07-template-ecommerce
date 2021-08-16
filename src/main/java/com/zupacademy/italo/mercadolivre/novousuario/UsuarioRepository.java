package com.zupacademy.italo.mercadolivre.novousuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByLogin(String login);
}
