package challenge;

public class Alfabeto {

    private static final char INICIO_ALFABETO = 'a';
    private static final char FIM_ALFABETO = 'z';

    @Override
    public boolean hasLetra(char letra) {
        return letra >= INICIO_ALFABETO && letra <= FIM_ALFABETO;
    }

    @Override
    public char somar(char letra, int valor) {
        validar(letra);

        return normalizar((char) ((int) letra + valor));
    }

    private char normalizar(char letra) {
        char normalizado = letra;

        if (letra > FIM_ALFABETO) {
            normalizado = (char) (letra % FIM_ALFABETO + (INICIO_ALFABETO - 1));
        }

        if (letra < INICIO_ALFABETO) {
            normalizado = (char) (letra - INICIO_ALFABETO + (FIM_ALFABETO + 1));
        }

        return normalizado;
    }


    private void validar(char letra) {
        if (!this.hasLetra(letra)) {
            throw new IllegalArgumentException("A letra informada não existe no alfabeto!");
        }
    }
}