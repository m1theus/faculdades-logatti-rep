package br.edu.logatti;

import java.util.Arrays;
import java.util.stream.Collectors;

import br.edu.logatti.classe.Vetor;

public class Main {

	public static void main(String[] args) {
		Vetor vetor1 = new Vetor(); // VETOR PADRÃO -> [5, 1, 6, 2, 4, 3] (8 trocas)
		Vetor vetor2 = new Vetor(new int[10], 1, 100);
		Vetor vetor3 = new Vetor(new int[100], 1, 1000);
		Vetor vetor4 = new Vetor(new int[500], 1, 5000);
		Vetor vetor5 = new Vetor(new int[1000], 1, 10000);
		
		gerarVetor(vetor2);
		gerarVetor(vetor3);
		gerarVetor(vetor4);
		gerarVetor(vetor5);
		
		bubbleSort(vetor1);
		bubbleSort(vetor2);
		bubbleSort(vetor3);
		bubbleSort(vetor4);
		bubbleSort(vetor5);
		
	}
	
	public static void bubbleSort(Vetor vetor) {
		int trocas = 0;
		
		System.out.println("\n--------| Desordenado |--------");
		imprimirVetor(vetor.getVetor());
		
		for(int i = 0; i < vetor.getVetor().length; i++){
	        for(int j = 0; j < vetor.getVetor().length -1; j++){
	            if(vetor.getVetor()[j] > vetor.getVetor()[j + 1]){
	                int aux = vetor.getVetor()[j];
	                vetor.getVetor()[j] = vetor.getVetor()[j + 1];
	                vetor.getVetor()[j + 1] = aux;
	                trocas++;
	            }
	        }
	    }
		
		System.out.println("\n--------| Ordenado |--------");
		imprimirVetor(vetor.getVetor());
		System.out.println(String.format("\nBubble Sort -> Trocas: %s", trocas));
	}

	public static void gerarVetor(Vetor vetor) {
		// POPULAR VETOR
		for (int i = 0; i < vetor.getVetor().length; i++) {
			int numeroGerado = gerarNumeroAleatorio(vetor.getMin(), vetor.getMax());

			do {
				numeroGerado = gerarNumeroAleatorio(vetor.getMin(), vetor.getMax());
			} while (vetor.contains(numeroGerado));

			vetor.getVetor()[i] = numeroGerado;
		}
	}
	
	private static void imprimirVetor(int[] array) {
		System.out.println(Arrays.stream(array)
				  .mapToObj(String::valueOf)
				  .collect(Collectors.joining(",")));
	}

	private static int gerarNumeroAleatorio(int min, int max) {
		return (int) (Math.random() * max + min);
	}

}
