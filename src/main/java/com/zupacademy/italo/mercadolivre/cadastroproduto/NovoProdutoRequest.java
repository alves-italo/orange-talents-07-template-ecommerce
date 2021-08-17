package com.zupacademy.italo.mercadolivre.cadastroproduto;

import com.zupacademy.italo.mercadolivre.cadastrocategoria.Categoria;
import com.zupacademy.italo.mercadolivre.cadastrocategoria.CategoriaRepository;
import com.zupacademy.italo.mercadolivre.cadastrousuario.Usuario;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

public class NovoProdutoRequest {
    @NotBlank
    private String nome;
    @NotNull
    @Positive
    private Double valor;
    @PositiveOrZero
    private int quantidade;
    @NotBlank
    @Length(max = 1000)
    private String descricao;

    @NotNull
    private Long idCategoria;

    @Size(min = 3)
    @Valid
    private List<NovaCaracteristicaRequest> caracteristicas = new ArrayList<>();

    public NovoProdutoRequest(String nome, Double valor, int quantidade, String descricao, Long idCategoria, List<NovaCaracteristicaRequest> caracteristicas) {
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
