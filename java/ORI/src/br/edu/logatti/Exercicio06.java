package br.edu.logatti;

import java.util.Arrays;

public class Exercicio06 {

	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();
		int[] vetor = new int[1000];
		fill(vetor);
		mergeSort(vetor);
		int searchNumber = 5020;
		int index = linearSearch(vetor, searchNumber);
		long fim = System.currentTimeMillis();
		if (index == -1) {
			System.out.println(String.format("O número %s não foi encontrado no vetor", searchNumber));
		} else {
			System.out.println(String.format("O número %s está na posição %s", searchNumber, index));
		}
		System.out.println(String.format("time: %sms", (fim - inicio)));
		System.out.println(Arrays.toString(vetor));
	}
	
	static int linearSearch(int[] vetor, int n) {
		
		for (int i = 0; i < vetor.length; i++) {
			int aux = vetor[i];
			if (aux > n) {
				return -1;
			}
			
			if (aux == n) {
				return i;
			}
		
		}
		
		return -1;
	}

	static void fill(int[] vetor) {

		for (int i = 0; i < vetor.length; i++) {
			int n = generateNumber();
			do {
				n = generateNumber();
			} while (contains(vetor, n));

			vetor[i] = n;
		}

	}

	static boolean contains(int[] vetor, int n) {
		return linearSearch(vetor, n)  == -1 ? false : true;
	}

	static int generateNumber() {
		return (int) (Math.random() * 10000 + 1);
	}
	
	static void mergeSort(int vetor[]) {
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

	static void merge(int vetor[], int esquerda[], int direita[]) {
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
