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
    public BigDecimal somar(Object o) {


        BigDecimal soma =
                getCamposByAnnotation(o, Somar.class)
                .stream()
                .map(f -> {

                    if (f.getType().isAssignableFrom(BigDecimal.class)) {
                        try {
                            f.setAccessible(true);
                            return (BigDecimal) f.get(o);
                        } catch (IllegalAccessException | IllegalArgumentException e) { e.printStackTrace(); }
                    }

                    return BigDecimal.ZERO;
                })
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);

        System.out.println("result: " + soma);

        return soma;
    }

    @Override
    public BigDecimal subtrair(Object o) {
        BigDecimal subtracao =
                getCamposByAnnotation(o, Subtrair.class)
                        .stream()
                        .map(f -> {

                            if (f.getType().isAssignableFrom(BigDecimal.class)) {
                                try {
                                    f.setAccessible(true);
                                    return (BigDecimal) f.get(o);
                                } catch (IllegalAccessException | IllegalArgumentException e) { e.printStackTrace(); }
                            }

                            return BigDecimal.ZERO;
                        })
                        .reduce(BigDecimal::add)
                        .orElse(BigDecimal.ZERO);

        return subtracao;

    }


    private List<Field> getCamposByAnnotation(Object object, Class<? extends Annotation> annotationClass) {

        return Arrays.stream(object.getClass().getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(annotationClass) )
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
