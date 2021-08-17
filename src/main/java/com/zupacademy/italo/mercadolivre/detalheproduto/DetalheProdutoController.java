package com.zupacademy.italo.mercadolivre.detalheproduto;

import com.zupacademy.italo.mercadolivre.cadastroproduto.Produto;
import com.zupacademy.italo.mercadolivre.cadastroproduto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetalheProdutoController {
    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping(value = "/produtos/{id}")
    public DetalheProdutoResponse detalharProduto(@PathVariable Long id){
        Produto produto =  produtoRepository.getById(id);
        return new DetalheProdutoResponse(produto);
    }
}
