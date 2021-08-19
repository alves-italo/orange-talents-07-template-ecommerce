package com.zupacademy.italo.mercadolivre.cadastroproduto;

import com.zupacademy.italo.mercadolivre.cadastrocategoria.Categoria;
import com.zupacademy.italo.mercadolivre.cadastrocategoria.CategoriaRepository;
import com.zupacademy.italo.mercadolivre.cadastrousuario.Usuario;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NovoProdutoRequest {
    @NotBlank
    private final String nome;
    @NotNull
    @Positive
    private final BigDecimal valor;
    @PositiveOrZero
    private final int quantidade;
    @NotBlank
    @Length(max = 1000)
    private final String descricao;

    @NotNull
    private final Long idCategoria;

    @Size(min = 3)
    @Valid
    private final List<NovaCaracteristicaRequest> caracteristicas = new ArrayList<>();

    public NovoProdutoRequest(String nome, BigDecimal valor, int quantidade, String descricao, Long idCategoria, List<NovaCaracteristicaRequest> caracteristicas) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.idCategoria = idCategoria;
        this.caracteristicas.addAll(caracteristicas);
    }

    public Produto toModel(CategoriaRepository categoriaRepository, Usuario dono) {
        Categoria categoria = categoriaRepository.findById(this.idCategoria).get();
        return new Produto(this.nome, this.valor, this.quantidade, this.descricao, categoria, this.caracteristicas, dono);
    }
}
