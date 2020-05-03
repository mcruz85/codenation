package br.com.codenation.calculadora;


public class CalculadoraSalario {

	private static final double SALARIO_MINIMO = 1_039.00;

	public long calcularSalarioLiquido(double salarioBase) {
		if (salarioBase < SALARIO_MINIMO) {
			return 0;
		}

		Imposto inss = new INSS();
		Imposto irrf = new IRRF();

		return aplicarImpostos(salarioBase, inss, irrf);
	}

	private long aplicarImpostos(double salarioBase, Imposto... impostos) {

		double salarioLiquido = salarioBase;
		Imposto[] listaImpostos = impostos;

		for (Imposto imposto: listaImpostos) {
			salarioLiquido = salarioLiquido - imposto.aplicar(salarioLiquido);
		}

		return Math.round(salarioLiquido);
	}
	

}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar!
*/