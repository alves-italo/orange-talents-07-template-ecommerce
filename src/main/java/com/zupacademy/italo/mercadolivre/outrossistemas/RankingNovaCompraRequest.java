package com.zupacademy.italo.mercadolivre.outrossistemas;

import javax.validation.constraints.NotNull;

public class RankingNovaCompraRequest {
    @NotNull
    private final Long idCompra;
    @NotNull
    private final Long idVendedor;

    public RankingNovaCompraRequest(Long idCompra, Long idVendedor) {
        this.idCompra = idCompra;
        this.idVendedor = idVendedor;
    }

    @Override
    public String toString() {
        return "RankingNovaCompraRequest{" +
                "idCompra=" + idCompra +
                ", idVendedor=" + idVendedor +
                '}';
    }
}
