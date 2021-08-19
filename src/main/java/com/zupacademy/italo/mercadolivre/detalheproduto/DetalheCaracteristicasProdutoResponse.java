package com.zupacademy.italo.mercadolivre.detalheproduto;

import com.zupacademy.italo.mercadolivre.cadastroproduto.CaracteristicaProduto;

public class DetalheCaracteristicasProdutoResponse {
    private final String nome;
    private final String descricao;

    public DetalheCaracteristicasProdutoResponse(CaracteristicaProduto caracteristicaProduto) {
        this.nome = caracteristicaProduto.getNome();
        this.descricao = caracteristicaProduto.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
