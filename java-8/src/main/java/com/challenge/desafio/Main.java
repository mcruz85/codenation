package com.challenge.desafio;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        Teste teste = new Teste();
        teste.setPontos(new BigDecimal(200.00));
        teste.setBonus(new BigDecimal(50.00));

        teste.setFaltas(new BigDecimal(20.00));
        teste.setAtrasos(new BigDecimal(20.00));

        CalculadorDeClasses calculadorDeClasses = new CalculadorDeClasses();
        System.out.println(calculadorDeClasses.somar(teste));

        System.out.println(calculadorDeClasses.subtrair(teste));

    }
}
