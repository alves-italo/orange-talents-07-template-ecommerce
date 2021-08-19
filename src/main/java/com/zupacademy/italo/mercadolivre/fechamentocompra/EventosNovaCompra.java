package com.zupacademy.italo.mercadolivre.fechamentocompra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class EventosNovaCompra {

    @Autowired
    private Set<EventoCompraSucesso> eventosCompraSucesso;

    public void processa(Compra compra) {
        if(compra.pagamentoEfetuado()) eventosCompraSucesso.forEach(evento -> evento.processa(compra));
    }

}