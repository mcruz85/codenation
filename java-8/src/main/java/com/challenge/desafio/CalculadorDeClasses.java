package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalculadorDeClasses implements Calculavel {
    @Override
    public BigDecimal somar(Object object) {
        return calcular(object, Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object object) {
        return calcular(object, Subtrair.class);
    }


    private BigDecimal calcular(Object objeto, Class<? extends Annotation> annotationClass) {
        validarObjeto(objeto);
        BigDecimal total = BigDecimal.ZERO;

        for (Field field : getCamposByAnnotation(objeto, annotationClass)) {
            if (field.getType().equals(BigDecimal.class)) {
                try {
                    field.setAccessible(true);
                    total = total.add((BigDecimal) field.get(objeto));
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return total;
    }

    private void validarObjeto(Object objeto) {
        if (objeto == null) {
            throw new IllegalArgumentException("o objeto nulo");
        }
    }

    private List<Field> getCamposByAnnotation(Object object, Class<? extends Annotation> annotationClass) {
        return Arrays.stream(object.getClass().getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(annotationClass))
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
