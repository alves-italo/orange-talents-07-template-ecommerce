package com.zupacademy.italo.mercadolivre.cadastroproduto;

import javax.validation.constraints.NotBlank;

public class NovaCaracteristicaRequest {
    @NotBlank
    private final String nome;
    @NotBlank
    private final String descricao;

    public NovaCaracteristicaRequest(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public CaracteristicaProduto toModel(Produto produto) {
        return new CaracteristicaProduto(this.nome, this.descricao, produto);
    }
}
