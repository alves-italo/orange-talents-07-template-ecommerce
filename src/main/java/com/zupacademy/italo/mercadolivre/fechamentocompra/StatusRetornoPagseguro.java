package com.zupacademy.italo.mercadolivre.fechamentocompra;

public enum StatusRetornoPagseguro {
    SUCESSO,ERRO;

    public StatusTransacao normaliza() {
        if(this.equals(SUCESSO)) return StatusTransacao.SUCESSO;
        return StatusTransacao.ERRO;
    }
}
