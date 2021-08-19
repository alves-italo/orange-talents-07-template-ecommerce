package com.zupacademy.italo.mercadolivre.fechamentocompra;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private StatusTransacao status;
    private String idTransacao;
    private LocalDateTime instante;

    @ManyToOne
    private Compra compra;

    @Deprecated
    public Transacao() {
    }

    public Transacao(StatusTransacao status, String idTransacao, Compra compra) {
        this.status = status;
        this.idTransacao = idTransacao;
        this.instante = LocalDateTime.now();
        this.compra = compra;
    }

    public boolean concluidaComSucesso() {
        return this.status.equals(StatusTransacao.SUCESSO);
    }
}
