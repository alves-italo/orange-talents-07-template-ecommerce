package com.zupacademy.italo.mercadolivre.fechamentocompra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
public class FechamentoCompraParte2Controller {
    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private EventosNovaCompra eventosNovaCompra;


    @PostMapping("/retorno-pagseguro/{id}")
    @Transactional
    public String processamentoPagSeguro(@PathVariable("id") Long id, @Valid RetornoPagSeguroRequest request) {
        return this.processaTransacao(id, request);
    }

    @PostMapping("/retorno-paypal/{id}")
    @Transactional
    public String processamentoPaypal(@PathVariable("id") Long id, @Valid RetornoPagSeguroRequest request) {
        return this.processaTransacao(id, request);
    }

    private String processaTransacao(Long id, RetornoGatewayPagamento request) {
        Compra compra = manager.find(Compra.class, id);
        compra.adicionaTransacao(request);
        manager.merge(compra);

        eventosNovaCompra.processa(compra);

        return request.toString();
    }
}
