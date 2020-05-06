package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;

import java.math.BigDecimal;

public class Teste {

    @Somar
    private BigDecimal pontos;
    @Somar
    private BigDecimal bonus;
    @Subtrair
    private BigDecimal faltas;
    @Subtrair
    private BigDecimal atrasos;

    public BigDecimal getPontos() {
        return pontos;
    }

    public void setPontos(BigDecimal pontos) {
        this.pontos = pontos;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    public BigDecimal getFaltas() {
        return faltas;
    }

    public void setFaltas(BigDecimal faltas) {
        this.faltas = faltas;
    }


    public BigDecimal getAtrasos() {
        return atrasos;
    }

    public void setAtrasos(BigDecimal atrasos) {
        this.atrasos = atrasos;
    }
}
