package br.com.codenation;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import br.com.codenation.suite.teste.Detonado;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	HashMap<Long, Time> times = new HashMap<Long, Time>();
	HashMap<Long, Jogador> jogadores = new HashMap<Long, Jogador>();

	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		if (times.containsKey(id)) { throw new IdentificadorUtilizadoException("Já existe um time com id: " + id); }

		times.put(id, new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));
	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		if (!times.containsKey(idTime)) { throw new TimeNaoEncontradoException("Time não encontrado id: "+ idTime); }

		if (jogadores.containsKey(id)) { throw new IdentificadorUtilizadoException("Já existe um jogador com id: "+ id); }

		Time time = times.get(idTime);
		Jogador jogador = new Jogador(id, nome, dataNascimento, nivelHabilidade, salario, time);
		time.adicionarJogador(jogador);

		jogadores.put(id, jogador);
	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {
		Jogador jogador = buscarJogador(idJogador);
		jogador.getTime().definirCapitao(jogador);
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {
		Time time = buscarTime(idTime);
		return time.getCapitao().getId();
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {
		Jogador jogador = buscarJogador(idJogador);
		return jogador.getNome();
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {

		return buscarTime(idTime).getNome();
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		Time time = buscarTime(idTime);

		return time.getJogadores().stream()
				.map(Jogador::getId)
				.sorted()
				.collect(Collectors.toList());
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		Time time = buscarTime(idTime);
		
		Comparator<Jogador> comparator = Comparator.comparing(Jogador::getNivelHabilidade).reversed();
		comparator = comparator.thenComparing(Jogador::getId);

		return time.getJogadores().stream()
				.sorted(comparator)
				.limit(1)
				.map(Jogador::getId)
				.findFirst()
				.orElseThrow(JogadorNaoEncontradoException::new);
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		Time time = buscarTime(idTime);

		Comparator<Jogador> comparator = Comparator.comparing(Jogador::getDataNascimento);
		comparator = comparator.thenComparing(Jogador::getId);

		return time.getJogadores().stream()
				.min(comparator)
				.map(Jogador::getId)
				.orElseThrow(JogadorNaoEncontradoException::new);
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		return times.values()
				.stream()
				.map(Time::getId)
				.sorted(Long::compareTo)
				.collect(Collectors.toList());

	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		Time time = buscarTime(idTime);

		Comparator<Jogador> comparator = Comparator.comparing(Jogador::getSalario);
		comparator = comparator.thenComparing(Comparator.comparing(Jogador::getId).reversed());

		return time.getJogadores().stream()
				.max(comparator)
				.map(Jogador::getId)
				.orElseThrow(JogadorNaoEncontradoException::new);
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		return buscarJogador(idJogador).getSalario();
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {

		Comparator<Jogador> comparator = Comparator.comparing(Jogador::getNivelHabilidade).reversed();
		comparator = comparator.thenComparing(Jogador::getId);

		return this.jogadores.values()
				.stream()
				.sorted(comparator)
				.limit(top)
				.map(Jogador::getId)
				.collect(Collectors.toList());
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
		Time casa = buscarTime(timeDaCasa);
		Time fora = buscarTime(timeDeFora);

		boolean corUniformePrincialIgual = casa.getCorUniformePrincipal().equals(fora.getCorUniformePrincipal());
		return corUniformePrincialIgual ? fora.getCorUniformeSecundario() : fora.getCorUniformePrincipal();
	}

	private Time buscarTime(Long idTime){
		if (!times.containsKey(idTime)) { throw new TimeNaoEncontradoException(); }
		return times.get(idTime);
	}

	private Jogador buscarJogador(Long idJogador) {
		if (!jogadores.containsKey(idJogador)) { throw new JogadorNaoEncontradoException(); }
		return this.jogadores.get(idJogador);
	}

}