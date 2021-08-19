package com.zupacademy.italo.mercadolivre.fechamentocompra;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class RetornoPaypalRequest implements RetornoGatewayPagamento{
    @Min(0)
    @Max(1)
    private final int status;
    private final String idTransacao;

    public RetornoPaypalRequest(int status, String idTransacao) {
        this.status = status;
        this.idTransacao = idTransacao;
    }

    public Transacao toTransacao(Compra compra) {
        StatusTransacao statusNormalizado = this.status == 0? StatusTransacao.ERRO: StatusTransacao.SUCESSO;
        return new Transacao(statusNormalizado, idTransacao, compra);
    }
}
