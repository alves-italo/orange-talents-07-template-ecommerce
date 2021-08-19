package com.zupacademy.italo.mercadolivre.cadastroproduto;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ImageUploader {

    public Set<String> enviar(List<MultipartFile> imagens) {
        return imagens.stream().map(imagem -> "https://bucket.io/" + imagem.getOriginalFilename() + UUID.randomUUID()).collect(Collectors.toSet());
    }
}
