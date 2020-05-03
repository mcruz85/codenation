package challenge;


import java.util.Objects;

public class Motorista {

    private final String nome;

    private final int idade;

    private final int pontos;

    private final String habilitacao;

    private Motorista(String nome, int idade, int pontos, String habilitacao) {
        validarMotorista(nome, idade, pontos, habilitacao);
        this.nome = nome;
        this.idade = idade;
        this.pontos = pontos;
        this.habilitacao = habilitacao;
    }

    private void validarMotorista(String nome, int idade, int pontos, String habilitacao) {
        validarPontos(pontos);
        validarIdade(idade);
        validarNomeMotorista(nome);
        validarHabilitacao(habilitacao);
    }

    private void validarHabilitacao(String habilitacao) {
        if(habilitacao == null || habilitacao.isEmpty()){
            throw new NullPointerException("Habilitação em branco");
        }
    }

    private void validarNomeMotorista(String nome) {
        if(nome == null || nome.isEmpty()){
            throw new NullPointerException("Nome em branco");
        }
    }

    private void validarIdade(int idade) {
        if(idade < 0){
            throw new IllegalArgumentException("Idade não pode ser negativa");
        }
    }

    private void validarPontos(int pontos) {
        if(pontos < 0){
            throw new IllegalArgumentException("Quantidade de pontos não pode ser negativa");
        }
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getPontos() {
        return pontos;
    }

    public String getHabilitacao() {
        return habilitacao;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Motorista motorista = (Motorista) o;
        return Objects.equals(habilitacao, motorista.habilitacao);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(habilitacao);
    }

    @Override
    public String toString() {
        return "Motorista{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", pontos=" + pontos +
                ", habilitacao='" + habilitacao + '\'' +
                '}';
    }

    public static MotoristaBuilder builder() {
        return new MotoristaBuilder();
    }


    public static class MotoristaBuilder {

        private String nome;

        private int idade;

        private int pontos;

        private String habilitacao;

        private MotoristaBuilder() {
        }

        public MotoristaBuilder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public MotoristaBuilder withIdade(int idade) {
            validarIdade(idade);
            this.idade = idade;
            return this;
        }

        public MotoristaBuilder withPontos(int pontos) {
            validarPontos(pontos);
            this.pontos = pontos;
            return this;
        }

        public MotoristaBuilder withHabilitacao(String habilitacao) {
            this.habilitacao = habilitacao;
            return this;
        }


        public Motorista build() {
            return new Motorista(nome, idade, pontos, habilitacao);
        }

        private void validarIdade(int idade) {
            if(idade < 0){
                throw new IllegalArgumentException("Idade não pode ser negativa");
            }
        }

        private void validarPontos(int pontos) {
            if(pontos < 0){
                throw new IllegalArgumentException("Quantidade de pontos não pode ser negativa");
            }
        }
    }
}
