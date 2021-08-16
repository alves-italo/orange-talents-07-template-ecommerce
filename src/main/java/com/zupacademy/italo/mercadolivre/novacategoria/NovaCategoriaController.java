package com.zupacademy.italo.mercadolivre.novacategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class NovaCategoriaController {
    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<?> cadastrarCategoria(@RequestBody @Valid NovaCategoriaRequest request) {
        Categoria categoria = request.toModel(categoriaRepository);
        categoriaRepository.save(categoria);

        return new ResponseEntity<>(categoria, HttpStatus.CREATED);
    }
}
