package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		int i = 1;
		int number = 350;

		List<Integer> fibonacciNumbers = new ArrayList<>(Arrays.asList(0, 1));

		while (i < number) {
			i = Integer.sum(fibonacciNumbers.get(fibonacciNumbers.size() - 1), fibonacciNumbers.get(fibonacciNumbers.size() - 2));
			fibonacciNumbers.add(i);
		}

		return fibonacciNumbers;
	}

	public static Boolean isFibonacci(Integer a) {
		return fibonacci().contains(a);
	}

	public static void main(String[] args) {
		System.out.println(DesafioApplication.fibonacci());
	}

}