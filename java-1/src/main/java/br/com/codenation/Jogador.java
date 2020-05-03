package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Jogador {

    private final Long id;
    private final String nome;
    private final LocalDate dataNascimento;
    private final Integer nivelHabilidade;
    private final BigDecimal salario;
    private Time time;

    public Jogador(Long id, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario, Time time) {
        if (nivelHabilidade < 0 || nivelHabilidade > 100) {
            throw new IllegalArgumentException("nivelHabilidade não está no range [0..100]: " + nivelHabilidade);
        }

        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nivelHabilidade = nivelHabilidade;
        this.salario = salario;
        this.time = time;
    }

    public Time getTime() { return time; }

    public void setTime(Time time) { this.time = time; }

    public Long getId() { return id; }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Integer getNivelHabilidade() {
        return nivelHabilidade;
    }

    public BigDecimal getSalario() {
        return salario;
    }
}
