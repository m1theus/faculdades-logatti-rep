package br.edu.logatti;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Exercicio02 {

	public static void main(String[] args) {

		final int[] vetor = { 5, 10, 12, 6, 94, 67, 63 };
		bubbleSort(vetor);
		
	}

	public static void bubbleSort(int[] vetor) {
		@SuppressWarnings("unused")
		int trocas = 0;
		int passo = 1;
		System.out.println(String.format("passo %s", passo++));
		System.out.println(Arrays.stream(vetor)
				  .mapToObj(String::valueOf)
				  .collect(Collectors.joining(",")));
		for (int i = 0; i < vetor.length; i++) {
			for (int j = 0; j < vetor.length - 1; j++) {
				if (vetor[j] > vetor[j + 1]) {
					final int aux = vetor[j];
					System.err.println(String.format("trocando %s por %s", vetor[j], vetor[j + 1]));
					vetor[j] = vetor[j + 1];
					vetor[j + 1] = aux;
					System.out.println(String.format("passo %s", passo++));
					System.out.println(Arrays.stream(vetor)
							  .mapToObj(String::valueOf)
							  .collect(Collectors.joining(",")));
					trocas++;
				}
			}
		}
	}

}
