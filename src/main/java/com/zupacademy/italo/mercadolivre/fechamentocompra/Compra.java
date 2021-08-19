package com.zupacademy.italo.mercadolivre.fechamentocompra;

import com.zupacademy.italo.mercadolivre.cadastroproduto.Produto;
import com.zupacademy.italo.mercadolivre.cadastrousuario.Usuario;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Positive
    private int quantidade;
    @ManyToOne
    @NotNull
    @Valid
    private Produto produto;
    @ManyToOne
    @NotNull
    @Valid
    private Usuario comprador;

    @Enumerated
    @NotNull
    private GatewayPagamento gatewayPagamento;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.MERGE)
    private final Set<Transacao> transacoes = new HashSet<>();

    @Deprecated
    public Compra() {
    }

    public Compra(int quantidade, Produto produto, Usuario comprador, GatewayPagamento gatewayPagamento) {
        this.quantidade = quantidade;
        this.produto = produto;
        this.comprador = comprador;
        this.gatewayPagamento = gatewayPagamento;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", quantidade=" + quantidade +
                ", produto=" + produto +
                ", comprador=" + comprador +
                '}';
    }

    public void adicionaTransacao(RetornoGatewayPagamento request) {
        Transacao transacao = request.toTransacao(this);

        Assert.isTrue(!this.transacoes.contains(transacao), "Já existe essa transação na compra.");
        Assert.isTrue(!this.pagamentoEfetuado(), "Eita! Já pagaram essa compra.");

        this.transacoes.add(transacao);
    }

    public boolean pagamentoEfetuado() {
        List<Transacao> concluidas = this.transacoes.stream().filter(transacao -> transacao.concluidaComSucesso()).collect(Collectors.toList());
        Assert.isTrue(concluidas.size() <= 1, "Essa compra foi paga mais de uma vez");

        return !concluidas.isEmpty();
    }

    public Usuario getComprador() {
        return this.comprador;
    }

    public Usuario getVendedor() {
        return this.produto.getDono();
    }
}
