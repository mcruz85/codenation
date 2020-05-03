package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    private static final int LIMITE_VAGAS = 10;
    private static final int LIMITE_PONTOS_HABILITACAO = 20;
    private static final int LIMITE_IDADE_PRIORIDADE = 55;
    private static final int IDADE_MINIMA = 18;

    private List<Carro> carrosEstacionados = new ArrayList<>();

    public void estacionar(Carro carro) {
        validarRestricoes(carro.getMotorista());

        if (!possuiVagas()) {
            Carro carroRemover = carrosEstacionados.stream()
                    .filter(c -> c.getMotorista().getIdade() <= LIMITE_IDADE_PRIORIDADE)
                    .findFirst()
                    .orElseThrow(() -> new EstacionamentoException("Não há vagas"));
            carrosEstacionados.remove(carroRemover);
        }
        carrosEstacionados.add(carro);
    }


    private boolean possuiVagas(){
        return carrosEstacionados() < LIMITE_VAGAS;
    }

    public int carrosEstacionados() {
        return carrosEstacionados.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return carrosEstacionados.contains(carro);
    }



    private void validarRestricoes(Motorista motorista) {
        validarCondutor(motorista);
        validarMotoristaMenorDeIdade(motorista);
        validarHabilitacaoSuspensa(motorista);
    }

    private void validarCondutor(Motorista motorista) {
        validar(motorista == null, "Carro não pode ser autônomo");
    }

    private void validarMotoristaMenorDeIdade(Motorista motorista) {
        validar(motorista.getIdade() < IDADE_MINIMA, "Motorista menor de idade");
    }

    private void validarHabilitacaoSuspensa(Motorista motorista) {
        validar(motorista.getPontos() > LIMITE_PONTOS_HABILITACAO, "Carteira suspensa");
    }

    private void validar(boolean b, String s) {
        if (b) {
            throw new EstacionamentoException(s);
        }
    }
}
