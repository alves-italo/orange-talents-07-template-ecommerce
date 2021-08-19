package com.zupacademy.italo.mercadolivre.utilidades;

import com.zupacademy.italo.mercadolivre.cadastropergunta.Pergunta;
import com.zupacademy.italo.mercadolivre.fechamentocompra.Compra;
import org.springframework.stereotype.Component;

@Component
public class CentralDeEmail {
    public void notificaVendedorSobrePergunta(Pergunta pergunta) {
        System.out.println("Email para o vendedor");
    }

    public void notificaComprador(Compra compra) {
        System.out.println("Email para o comprador com os dados da compra");
    }

    public void notificaCompradorPagamentoEfetuado(Compra compra) {
        System.out.println("Email de pagamento efetuado com sucesso");
    }
}
