package com.zupacademy.italo.mercadolivre.fechamentocompra;

import com.zupacademy.italo.mercadolivre.cadastroproduto.Produto;
import com.zupacademy.italo.mercadolivre.cadastroproduto.ProdutoRepository;
import com.zupacademy.italo.mercadolivre.cadastrousuario.Usuario;
import com.zupacademy.italo.mercadolivre.utilidades.CentralDeEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
public class FechamentoCompraParte1Controller {
    @Autowired
    ProdutoRepository produtoRepository;
    @Autowired
    CentralDeEmail centralDeEmail;
    @PersistenceContext
    EntityManager manager;

    @PostMapping(value = "/compras")
    @Transactional
    public String compra(@RequestBody @Valid NovaCompraRequest request, @AuthenticationPrincipal Usuario usuarioLogado, UriComponentsBuilder uriComponentsBuilder) throws BindException {
        Produto produto = produtoRepository.findById(request.getIdProduto()).get();
        boolean abatido = produto.abaterDoEstoque(request.getQuantidade());
        GatewayPagamento gateway = request.getGateway();

        if (abatido) {
            Compra compra = new Compra(request.getQuantidade(), produto, usuarioLogado, gateway);
            manager.persist(compra);
            centralDeEmail.notificaComprador(compra);

            return gateway.criaUrlRetorno(compra, uriComponentsBuilder);
        }

        BindException problemaComEstoque = new BindException(request,
                "novaCompraRequest");
        problemaComEstoque.reject(null,
                "Estoque insuficiente para o produto");

        throw problemaComEstoque;
    }
}
