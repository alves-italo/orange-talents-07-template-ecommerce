package com.zupacademy.italo.mercadolivre.cadastropergunta;


import com.zupacademy.italo.mercadolivre.cadastroproduto.Produto;
import com.zupacademy.italo.mercadolivre.cadastroproduto.ProdutoRepository;
import com.zupacademy.italo.mercadolivre.cadastrousuario.Usuario;
import com.zupacademy.italo.mercadolivre.utilidades.CentralDeEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
public class NovaPerguntaController {
    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    CentralDeEmail centralDeEmail;

    @PostMapping(path = "/produtos/{id}/perguntas")
    @Transactional
    public ResponseEntity<?> adicionaPergunta(@PathVariable("id") Long id, @RequestBody @Valid NovaPerguntaRequest request, @AuthenticationPrincipal Usuario usuarioLogado) {
        Produto produto = produtoRepository.findById(id).get();
        Pergunta pergunta = request.toModel(produto, usuarioLogado);

        produto.adiciona(pergunta);
        produtoRepository.save(produto);

        centralDeEmail.notificaVendedorSobrePergunta(pergunta);

        return ResponseEntity.ok().build();
    }
}
