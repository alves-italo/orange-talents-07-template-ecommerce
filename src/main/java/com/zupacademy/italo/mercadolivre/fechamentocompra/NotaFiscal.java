package com.zupacademy.italo.mercadolivre.fechamentocompra;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@Service
public class NotaFiscal implements EventoCompraSucesso{

    @Override
    public void processa(Compra compra) {
        Assert.isTrue(compra.pagamentoEfetuado(),"Pagamento não foi efetuado." + compra);

        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> request = Map.of("idCompra", compra.getId(),
                "idComprador", compra.getComprador().getId());

        restTemplate.postForEntity("http://localhost:8080/notas-fiscais",
                request, String.class);
    }

}