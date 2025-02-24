package com.zupacademy.italo.mercadolivre.cadastroproduto;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class NovaImagemRequest {
    @Size(min = 1)
    @NotNull
    private List<MultipartFile> imagens = new ArrayList<>();

    public List<MultipartFile> getImagens() {
        return this.imagens;
    }

    public void setImagens(List<MultipartFile> imagens) {
        this.imagens = imagens;
    }
}
