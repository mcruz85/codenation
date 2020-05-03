package br.com.codenation;

import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Time {

    private final Long id;
    private final String nome;
    private final LocalDate dataCriacao;
    private final String corUniformePrincipal;
    private final String corUniformeSecundario;

    public Set<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(Set<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    private Set<Jogador> jogadores = new HashSet<Jogador>();
    private Jogador capitao;

    public Jogador getCapitao() {
        if (Objects.isNull(capitao)) {
            throw new CapitaoNaoInformadoException("Time não possui um capitão!");
        }
        return this.capitao;
    }

    public void setCapitao(Jogador capitao) {
        this.capitao = capitao;
    }

    public Time(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario){
        this.id = id;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.corUniformePrincipal = corUniformePrincipal;
        this.corUniformeSecundario = corUniformeSecundario;
    }

    public void adicionarJogador(Jogador jogador){
        jogadores.add(jogador);
    }
    public void definirCapitao(Jogador jogador) {
        this.capitao = jogador;
    }


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public String getCorUniformePrincipal() {
        return corUniformePrincipal;
    }

    public String getCorUniformeSecundario() {
        return corUniformeSecundario;
    }
}
