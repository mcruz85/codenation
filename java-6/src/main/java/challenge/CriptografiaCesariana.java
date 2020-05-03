package challenge;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {
       return deslocar(texto,3);
    }

    @Override
    public String descriptografar(String texto) {
        return deslocar(texto, -3);
    }

    private String deslocar(String texto, int deslocamento) {
        if ("".equals(texto)) { throw new IllegalArgumentException(); }
        texto = texto.toLowerCase();
        StringBuffer novaString = new StringBuffer();

        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);

            if (letra >= 'a' && letra <= 'z') {
                int posicaoOriginal = letra - 'a';
                int novaPosicao = (posicaoOriginal + deslocamento) % 26;
                letra = (char) ( 'a' + novaPosicao);
                novaString.append(letra);
            } else {
                novaString.append(letra);
            }
        }

        return novaString.toString();
    }

}
