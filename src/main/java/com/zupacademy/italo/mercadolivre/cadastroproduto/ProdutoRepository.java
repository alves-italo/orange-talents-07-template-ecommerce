package com.zupacademy.italo.mercadolivre.cadastroproduto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
