package com.zupacademy.italo.mercadolivre.detalheproduto;

import com.zupacademy.italo.mercadolivre.cadastroproduto.ImagemProduto;

public class DetalheImagemProdutoResponse {
    private final String url;

    public DetalheImagemProdutoResponse(ImagemProduto imagemProduto) {
        this.url = imagemProduto.getUrl();
    }

    public String getUrl() {
        return url;
    }
}
