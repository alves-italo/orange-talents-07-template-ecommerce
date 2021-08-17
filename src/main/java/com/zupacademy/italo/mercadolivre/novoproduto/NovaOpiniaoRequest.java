package com.zupacademy.italo.mercadolivre.novoproduto;

import com.zupacademy.italo.mercadolivre.novousuario.Usuario;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class NovaOpiniaoRequest {
    @NotNull
    @Positive
    @Max(5)
    private Integer nota;
    @NotBlank
    private String titulo;
    @NotBlank
    @Length(max = 500)
    private String descricao;

    public NovaOpiniaoRequest(Integer nota, String titulo, String descricao) {
        this.nota = nota;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public Opiniao toModel(Produto produto, Usuario usuario){
        return new Opiniao(this.nota, this.titulo, this.descricao, produto, usuario);
    }
}
