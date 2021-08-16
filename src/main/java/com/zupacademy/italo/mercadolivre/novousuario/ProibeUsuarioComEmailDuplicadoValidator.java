package com.zupacademy.italo.mercadolivre.novousuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeUsuarioComEmailDuplicadoValidator implements Validator {
    @Autowired
    UsuarioRepository repo;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoUsuarioRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        NovoUsuarioRequest request = (NovoUsuarioRequest) target;

        if(repo.existsByLogin(request.getLogin())) {
            errors.rejectValue("login",null, "Já existe um usuário com este email.");
        }
    }

}