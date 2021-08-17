package com.zupacademy.italo.mercadolivre.novoproduto;

import com.zupacademy.italo.mercadolivre.novacategoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class NovoProdutoController {
    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrarProduto(@RequestBody @Valid NovoProdutoRequest request) {
        Produto produto = request.toModel(categoriaRepository);

        produtoRepository.save(produto);

        return new ResponseEntity<>(produto, HttpStatus.CREATED);
    }
}
