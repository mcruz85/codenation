package br.com.codenation.calculadora;

public class IRRF implements Imposto {

    private static final double IRRF_FAIXA_ISENTO = 3000.00;
    private static final double IRRF_LIMITE_FAIXAS = 6000.00;

    @Override
    public double aplicar(double salarioBase) {
        if (salarioBase <= IRRF_FAIXA_ISENTO ) {
            return 0.0;
        }
        if (salarioBase <= IRRF_LIMITE_FAIXAS) {
            return salarioBase *  0.075;
        }
        return salarioBase * 0.15;
    }
}
