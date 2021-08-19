package com.zupacademy.italo.mercadolivre.fechamentocompra;

import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class NovaCompraRequest {
    @Positive
    private final int quantidade;
    @NotNull
    private final Long idProduto;

    @NotNull
    private final GatewayPagamento gateway;

    public NovaCompraRequest(int quantidade, Long idProduto, GatewayPagamento gateway) {
        this.quantidade = quantidade;
        this.idProduto = idProduto;
        this.gateway = gateway;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public GatewayPagamento getGateway() {
        return gateway;
    }
}
