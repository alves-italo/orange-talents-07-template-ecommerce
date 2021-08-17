package com.zupacademy.italo.mercadolivre.cadastrousuario;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class NovoUsuarioController {
    @PersistenceContext
    EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrarUsuario(@RequestBody @Valid NovoUsuarioRequest request) {
        Usuario usuario = request.toModel();
        manager.persist(usuario);

        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }
}
