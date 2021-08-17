package com.zupacademy.italo.mercadolivre.cadastrocategoria;

import com.zupacademy.italo.mercadolivre.utilidades.ExisteId;
import com.zupacademy.italo.mercadolivre.utilidades.ValorUnico;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {
    @NotBlank
    @ValorUnico(target = Categoria.class, field = "nome")
    private String nome;

    @ExisteId(domainClass = Categoria.class, fieldName = "id")
    private Long idCategoriaMae;

    public NovaCategoriaRequest(String nome, Long idCategoriaMae) {
        this.nome = nome;
        this.idCategoriaMae = idCategoriaMae;
    }

    public Categoria toModel(CategoriaRepository categoriaRepository) {
        Categoria categoria = new Categoria(this.nome);

        if(this.idCategoriaMae != null) {
            System.out.print(this.idCategoriaMae);
            Categoria mae = categoriaRepository.findById(idCategoriaMae).get();
            categoria.setMae(mae);
        }

        return categoria;
    }
}
