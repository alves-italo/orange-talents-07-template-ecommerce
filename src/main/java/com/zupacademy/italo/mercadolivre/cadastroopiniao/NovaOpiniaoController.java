package com.zupacademy.italo.mercadolivre.cadastroopiniao;

import com.zupacademy.italo.mercadolivre.cadastroproduto.Produto;
import com.zupacademy.italo.mercadolivre.cadastroproduto.ProdutoRepository;
import com.zupacademy.italo.mercadolivre.cadastrousuario.Usuario;
import com.zupacademy.italo.mercadolivre.utilidades.ExisteId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class NovaOpiniaoController {
    @Autowired
    ProdutoRepository produtoRepository;

    @PostMapping(value = "/produtos/{id}/opinioes")
    @Transactional
    public ResponseEntity<?> adicionaOpiniao(@PathVariable("id") Long id, @RequestBody @Valid NovaOpiniaoRequest request, @AuthenticationPrincipal Usuario usuarioLogado) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto de id" + id + "não encontrado"));
        Opiniao opiniao = request.toModel(produto, usuarioLogado);

        produto.adiciona(opiniao);
        produtoRepository.save(produto);

        return ResponseEntity.ok().build();
    }
}
