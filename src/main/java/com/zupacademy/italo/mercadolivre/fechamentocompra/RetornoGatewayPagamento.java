package com.zupacademy.italo.mercadolivre.fechamentocompra;

public interface RetornoGatewayPagamento {
    Transacao toTransacao(Compra compra);
}
