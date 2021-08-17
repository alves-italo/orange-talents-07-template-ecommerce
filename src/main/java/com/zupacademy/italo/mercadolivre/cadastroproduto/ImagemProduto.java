package com.zupacademy.italo.mercadolivre.cadastroproduto;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class ImagemProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @URL
    @NotBlank
    private String url;
    @ManyToOne
    @NotNull
    @Valid
    private Produto produto;

    @Deprecated
    public ImagemProduto() {
    }

    public ImagemProduto(String url, @Valid @NotNull Produto produto) {
        this.url = url;
        this.produto = produto;
    }

    public String getUrl() {
        return url;
    }
}
