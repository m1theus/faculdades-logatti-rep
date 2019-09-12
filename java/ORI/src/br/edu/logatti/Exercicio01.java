package br.edu.logatti;

import java.util.HashMap;
import java.util.Map;

public class Exercicio01 {
	
	public static void main(String[] args) {
		final Map<String, Integer> map1 = new HashMap<>();
		final Map<String, Integer> map2 = new HashMap<>();
		
		final int[] vetor100 = new int[100];
		final int[] vetor1000 = new int[1000];
		
		gerarVetor(vetor100, 1, 1000);
		gerarVetor(vetor1000, 1, 1000);
		
		verificarRepeticoes(vetor100, map1);
		verificarRepeticoes(vetor1000, map2);
		
		imprimirVetor(map1);
		System.out.println("__________________________________________________");
		imprimirVetor(map2);
		
		
	}
	
	private static void verificarRepeticoes(int[] vetor, final Map<String, Integer> map) {
		for (int i = 0; i < vetor.length; i++) {
			final String key = String.valueOf(vetor[i]);
			
			if (!map.containsKey(key)) {
				map.put(key, 1);
			} else {
				map.put(key, map.get(key) + 1);
			}
		}
		
	}

	private static void imprimirVetor(final Map<String, Integer> map) {
		map.entrySet().forEach(i -> {
			if (!(i.getValue() == 1) ) {
				System.out.println(String.format("O número %s repete %s vezes.", i.getKey(), i.getValue()));
			}
		});
	}

	private static void gerarVetor(final int[] vetor, final int min, final int max ) {
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = gerarNumeroAleatorio(min,  max);
		}
	}
	
	private static int gerarNumeroAleatorio(final int min, final int max) {
		return (int) (Math.random() * max + min);
	}
	
}
