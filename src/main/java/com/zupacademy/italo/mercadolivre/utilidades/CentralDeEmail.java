package com.zupacademy.italo.mercadolivre.utilidades;

import com.zupacademy.italo.mercadolivre.cadastropergunta.Pergunta;
import org.springframework.stereotype.Component;

@Component
public class CentralDeEmail {
    public void notificaVendedorSobrePergunta(Pergunta pergunta) {
        System.out.println("Email para o vendedor");
    }
}
