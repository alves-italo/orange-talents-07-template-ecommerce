package com.zupacademy.italo.mercadolivre.outrossistemas;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class OutrosSistemasController {

    @PostMapping(value = "/notas-fiscais")
    public void criaNota(@Valid @RequestBody NotaFiscalRequest request) throws InterruptedException {
        System.out.println("Gerando nota fiscal "+ request);
    }

    @PostMapping(value = "/ranking")
    public void ranking(@Valid @RequestBody RankingNovaCompraRequest request) throws InterruptedException {
        System.out.println("Atualizando ranking" + request);
    }

}
