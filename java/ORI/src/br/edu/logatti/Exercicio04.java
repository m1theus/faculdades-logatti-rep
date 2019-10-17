package br.edu.logatti;

import java.util.Arrays;

public class Exercicio04 {

	public static void main(String[] args) {

		int vetor[] = { 3, 4, 5, 7, 1, 2, 6, 9 };

		System.out.print("Vetor desordenado: ");
		System.out.println(Arrays.toString(vetor));

		mergeSort(vetor);

		System.out.print("Vetor ordenado: ");
		System.out.println(Arrays.toString(vetor));

	}

	public static void mergeSort(int vetor[]) {
		int n = vetor.length;
		if (n < 2)
			return;
		int meio = n / 2;
		int esquerda[] = new int[meio];
		int direita[] = new int[n - meio];
		for (int i = 0; i < meio; i++)
			esquerda[i] = vetor[i];
		for (int i = meio; i < n; i++)
			direita[i - meio] = vetor[i];
		mergeSort(esquerda);
		mergeSort(direita);
		merge(vetor, esquerda, direita);
	}

	public static void merge(int vetor[], int esquerda[], int direita[]) {
		int numeroEsquerda = esquerda.length;
		int numeroDireita = direita.length;
		int i = 0, j = 0, k = 0;
		while (i < numeroEsquerda && j < numeroDireita) {
			if (esquerda[i] <= direita[j]) {
				vetor[k] = esquerda[i];
				i++;
			} else {
				vetor[k] = direita[j];
				j++;
			}
			k++;
		}
		while (i < numeroEsquerda) {
			vetor[k] = esquerda[i];
			i++;
			k++;
		}
		while (j < numeroDireita) {
			vetor[k] = direita[j];
			j++;
			k++;
		}
	}

}
