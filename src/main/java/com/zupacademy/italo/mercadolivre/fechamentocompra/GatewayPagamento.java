package com.zupacademy.italo.mercadolivre.fechamentocompra;

import org.springframework.web.util.UriComponentsBuilder;

public enum GatewayPagamento {
    pagseguro {
        @Override
        String criaUrlRetorno(Compra compra, UriComponentsBuilder uriComponentsBuilder) {
            String uriRetornoPagSeguro = uriComponentsBuilder.path("/retorno-pagseguro/{id}").buildAndExpand(compra.getId()).toString();
            return "pagseguro.com/" + compra.getId() + "?RedirectUrl=" + uriRetornoPagSeguro;
        }
    },
    paypal {
        @Override
        String criaUrlRetorno(Compra compra, UriComponentsBuilder uriComponentsBuilder) {
            String uriRetornoPaypal = uriComponentsBuilder.path("/retorno-paypal/{id}").buildAndExpand(compra.getId()).toString();
            return "paypal.com/" + compra.getId() + "?RedirectUrl=" + uriRetornoPaypal;
        }
    };

    abstract String criaUrlRetorno(Compra compra,
                                   UriComponentsBuilder uriComponentsBuilder);
}
