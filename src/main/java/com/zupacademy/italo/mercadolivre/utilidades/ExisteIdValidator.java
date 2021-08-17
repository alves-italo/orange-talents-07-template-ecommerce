package com.zupacademy.italo.mercadolivre.utilidades;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExisteIdValidator implements ConstraintValidator<ExisteId, Long>{
    @PersistenceContext
    private EntityManager manager;

    private String domainAttribute;
    private Class<?> aClass;

    @Override
    public void initialize(ExisteId params) {
        domainAttribute = params.fieldName();
        aClass = params.domainClass();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        Query query = manager.createQuery("select 1 from "+ aClass.getName()+" where "+ domainAttribute + "=:value");
        query.setParameter("value", value);

        List<?> list = query.getResultList();
        Assert.isTrue(list.size() <=1, "[BUG] Classe: "+ aClass +" duplicada com o atributo "+domainAttribute+" de valor = " + value);

        return !list.isEmpty();
    }
}
