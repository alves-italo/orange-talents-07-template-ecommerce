package com.zupacademy.italo.mercadolivre.cadastroproduto;

import com.zupacademy.italo.mercadolivre.cadastrocategoria.CategoriaRepository;
import com.zupacademy.italo.mercadolivre.cadastroopiniao.NovaOpiniaoRequest;
import com.zupacademy.italo.mercadolivre.cadastroopiniao.Opiniao;
import com.zupacademy.italo.mercadolivre.cadastrousuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/produtos")
public class NovoProdutoController {
    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ImageUploader imageUploader;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrarProduto(@RequestBody @Valid NovoProdutoRequest request, @AuthenticationPrincipal Usuario usuarioLogado) {
        Produto produto = request.toModel(categoriaRepository, usuarioLogado);
        produtoRepository.save(produto);
        return new ResponseEntity<>(produto, HttpStatus.CREATED);
    }

    @PostMapping(value = "/{id}/imagens")
    @Transactional
    public ResponseEntity<?> adicionaImagens(@PathVariable("id") Long id, @Valid NovaImagemRequest imagensRequest, @AuthenticationPrincipal Usuario usuarioLogado) {
        Set<String> urlImagens = imageUploader.enviar(imagensRequest.getImagens());
        Produto produto = produtoRepository.findById(id).get();

        if (!produto.pertenceA(usuarioLogado)) throw new ResponseStatusException(HttpStatus.FORBIDDEN);

        produto.associaImagens(urlImagens);
        produtoRepository.save(produto);

        return ResponseEntity.ok().build();
    }
}
