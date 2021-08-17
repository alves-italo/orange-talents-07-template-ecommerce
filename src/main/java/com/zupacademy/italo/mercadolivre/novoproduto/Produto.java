package com.zupacademy.italo.mercadolivre.novoproduto;

import com.zupacademy.italo.mercadolivre.novacategoria.Categoria;
import com.zupacademy.italo.mercadolivre.novousuario.Usuario;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @ManyToOne
    private Categoria categoria;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.PERSIST)
    private Set<CaracteristicaProduto> caracteristicas;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.MERGE)
    private Set<ImagemProduto> imagens = new HashSet<>();

    @ManyToOne
    private Usuario dono;

    @CreationTimestamp
    private LocalDateTime criacao;

    @Deprecated
    public Produto() {
    }

    public Produto(String nome, Double valor, int quantidade, String descricao, Categoria categoria, Collection<NovaCaracteristicaRequest> caracteristicas, Usuario dono) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.categoria = categoria;
        this.caracteristicas = caracteristicas.stream()
                .map(caracteristica -> caracteristica.toModel(this))
                .collect(Collectors.toSet());
        this.dono = dono;
    }

    public void associaImagens(Set<String> links) {
        Set<ImagemProduto> imagens = links.stream().map(url -> new ImagemProduto(url, this)).collect(Collectors.toSet());
        this.imagens.addAll(imagens);
    }

    public boolean pertenceA(Usuario usuario) {
        return this.dono.equals(usuario);
    }
}
