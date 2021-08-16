package com.zupacademy.italo.mercadolivre.novousuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class NovoUsuarioController {
    @Autowired
    UsuarioRepository repo;

    @Autowired
    ProibeUsuarioComEmailDuplicadoValidator proibeUsuarioComEmailDuplicadoValidator;

    @InitBinder
    public void init(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(proibeUsuarioComEmailDuplicadoValidator);
    }

    @PostMapping
    public ResponseEntity<?> cadastrarUsuario(@RequestBody @Valid NovoUsuarioRequest request) {
        Usuario usuario = request.toModel();
        repo.save(usuario);

        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }
}
