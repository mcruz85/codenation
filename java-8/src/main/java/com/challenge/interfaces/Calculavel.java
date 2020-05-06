package com.challenge.interfaces;

import java.math.BigDecimal;

public interface Calculavel {
    BigDecimal somar(Object object);
    BigDecimal subtrair(Object object);

    default BigDecimal totalizar(Object object) {
        return somar(object).subtract(subtrair(object));
    }
}
