package br.com.codenation;

import br.com.codenation.desafio.contexto.Assert;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;

public class Teste {

    public static void main(String[] args) {

        DesafioMeuTimeApplication desafio = new DesafioMeuTimeApplication();

        System.out.println("Times: " + desafio.buscarTimes());

        long idTimeA = 100l;
        LocalDate dataAtual = LocalDate.now();
        desafio.incluirTime(idTimeA, "Time A", dataAtual, "AZUL", "BRANCO");

        try {
            desafio.incluirTime(idTimeA, "Time A", dataAtual, "AZUL", "BRANCO");
        } catch (IdentificadorUtilizadoException e) {
            System.out.println("TESTE 1 ok!");
        }

//        Caso o identificador já exista, retornar br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException
//        Caso o time informado não exista, retornar br.com.codenation.desafio.exceptions.TimeNaoEncontradoException
        long idJogador = 100;
        desafio.incluirJogador(idJogador,idTimeA, "JOGADOR A", dataAtual, 50, new BigDecimal(999.99));
        try {
            desafio.incluirJogador(idJogador,idTimeA, "JOGADOR A", dataAtual, 99, new BigDecimal(999.99));
        } catch (IdentificadorUtilizadoException e) {
            System.out.println(e);
        }

        try {
            desafio.incluirJogador(idJogador, 9999L, "JOGADOR A", dataAtual, 99, new BigDecimal(999.99));
        } catch (TimeNaoEncontradoException e) {
            System.out.println(e);
        }

        long idJogador101 = 101;
        desafio.incluirJogador(idJogador101,idTimeA, "JOGADOR A 101", dataAtual, 100, new BigDecimal(1999.99));


        long idJogador50 = 50;
        LocalDate localDate = dataAtual.minusYears(10);
        desafio.incluirJogador(idJogador50, idTimeA, "JOGADOR A 50", localDate, 50, new BigDecimal(999.99));
        desafio.incluirJogador(25l, idTimeA, "JOGADOR A 50", localDate, 50, new BigDecimal(999.99));

        try {
            desafio.buscarCapitaoDoTime(idTimeA);
        } catch (CapitaoNaoInformadoException e) {
            System.out.println("CapitaoNaoInformadoException 1 ok!");
        }


        try {
            desafio.buscarNomeTime(99111l);
        } catch (TimeNaoEncontradoException e){

            System.out.println("BUSCAR NOME TimeNaoEncontradoException 1 ok!");
        }


            desafio.definirCapitao(idJogador101);
        System.out.println("capitão: " + desafio.buscarCapitaoDoTime(idTimeA));

        desafio.definirCapitao(idJogador);
        System.out.println("capitão: " + desafio.buscarCapitaoDoTime(idTimeA));


        System.out.println("Jogadores do time " + desafio.buscarJogadoresDoTime(idTimeA));


        System.out.println("Times: " + desafio.buscarTimes());


        System.out.println("buscarJogadorMaisVelho: " + desafio.buscarJogadorMaisVelho(idTimeA));
        System.out.println("buscarJogadorMaiorSalario: " + desafio.buscarJogadorMaiorSalario(idTimeA));

        System.out.println(desafio.buscarNomeTime(idTimeA));


    }
}
