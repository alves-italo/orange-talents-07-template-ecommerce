package com.zupacademy.italo.mercadolivre.fechamentocompra;

import com.zupacademy.italo.mercadolivre.utilidades.CentralDeEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailCompraFinalizada implements EventoCompraSucesso{

    @Autowired
    private CentralDeEmail centralDeEmail;

    @Override
    public void processa(Compra compra) {
        centralDeEmail.notificaCompradorPagamentoEfetuado(compra);
    }
}
