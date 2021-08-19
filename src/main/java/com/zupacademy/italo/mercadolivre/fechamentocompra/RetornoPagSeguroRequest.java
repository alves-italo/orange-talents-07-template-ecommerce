package com.zupacademy.italo.mercadolivre.fechamentocompra;

public class RetornoPagSeguroRequest implements RetornoGatewayPagamento {
    private final String idTransacao;
    private final StatusRetornoPagseguro status;

    public RetornoPagSeguroRequest(String idTransacao, StatusRetornoPagseguro status) {
        this.idTransacao = idTransacao;
        this.status = status;
    }

    public Transacao toTransacao(Compra compra) {
        return new Transacao(this.status.normaliza(), this.idTransacao, compra);
    }
}
