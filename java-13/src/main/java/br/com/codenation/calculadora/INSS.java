package br.com.codenation.calculadora;

public class INSS implements Imposto {

    private static final double INSS_FAIXA_MINIMO =1500.00;
    private static final double INSS_LIMITE_FAIXAS =4000.00;

    //	Até R$ 1.500,00	8%
    //	De R$ 1.500,01 até R$ 4.000,00	9%
    //	Acima de R$ 4.000,00	11%
    @Override
    public double aplicar(double salarioBase) {
        if (salarioBase <= INSS_FAIXA_MINIMO) {
            return salarioBase *  0.08;
        }
        if ( salarioBase <= INSS_LIMITE_FAIXAS) {
            return salarioBase *  0.09;
        }

         return salarioBase *  0.11;
    }

}
