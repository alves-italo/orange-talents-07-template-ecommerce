package com.zupacademy.italo.mercadolivre.detalheproduto;

import com.zupacademy.italo.mercadolivre.cadastroproduto.Produto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class DetalheProdutoResponse {
    private String nome;
    private BigDecimal preco;
    private String descricao;

    private Double mediaNotas;
    private Integer quantidadeOpinioes;

    private List<DetalheCaracteristicasProdutoResponse> caracteristicas;
    private List<DetalheImagemProdutoResponse> imagens;
    private List<DetalheOpiniaoResponse> opinioes;
    private List<DetalhePerguntaResponse> perguntas;

    public DetalheProdutoResponse(Produto produto) {
        this.nome = produto.getNome();
        this.preco = produto.getValor();
        this.descricao = produto.getDescricao();
        this.quantidadeOpinioes = produto.getOpinioes().size();
        this.mediaNotas = produto.getOpinioes().stream()
                .reduce(0, (soma, opiniao) -> soma + opiniao.getNota(), Integer::sum)
                    .doubleValue() / this.quantidadeOpinioes;
        this.caracteristicas = produto.getCaracteristicas().stream().map(DetalheCaracteristicasProdutoResponse::new).collect(Collectors.toList());
        this.imagens = produto.getImagens().stream().map(DetalheImagemProdutoResponse::new).collect(Collectors.toList());
        this.opinioes = produto.getOpinioes().stream().map(DetalheOpiniaoResponse::new).collect(Collectors.toList());
        this.perguntas = produto.getPerguntas().stream().map(DetalhePerguntaResponse::new).collect(Collectors.toList());
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getMediaNotas() {
        return mediaNotas;
    }

    public Integer getQuantidadeOpinioes() {
        return quantidadeOpinioes;
    }

    public List<DetalheCaracteristicasProdutoResponse> getCaracteristicas() {
        return caracteristicas;
    }

    public List<DetalheImagemProdutoResponse> getImagens() {
        return imagens;
    }

    public List<DetalheOpiniaoResponse> getOpinioes() {
        return opinioes;
    }

    public List<DetalhePerguntaResponse> getPerguntas() {
        return perguntas;
    }
}
