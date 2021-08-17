package com.zupacademy.italo.mercadolivre.cadastroopiniao;

import com.zupacademy.italo.mercadolivre.cadastroproduto.Produto;
import com.zupacademy.italo.mercadolivre.cadastrousuario.Usuario;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity
public class Opiniao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Positive
    @Max(5)
    private Integer nota;
    @NotBlank
    private String titulo;
    @NotBlank
    @Length(max = 500)
    private String descricao;
    @NotNull

    @ManyToOne
    @NotNull
    private Produto produto;

    @ManyToOne
    @NotNull
    private Usuario dono;

    @Deprecated
    public Opiniao() {
    }

    public Opiniao(Integer nota, String titulo, String descricao, Produto produto, Usuario usuario) {
        this.nota = nota;
        this.titulo = titulo;
        this.descricao = descricao;
        this.produto = produto;
        this.dono = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Opiniao opiniao = (Opiniao) o;
        return id.equals(opiniao.id) && produto.equals(opiniao.produto) && dono.equals(opiniao.dono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, produto, dono);
    }
}
