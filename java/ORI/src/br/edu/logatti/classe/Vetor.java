package br.edu.logatti.classe;

public class Vetor {
	
	private int vetor[] = {5, 1, 6, 2, 4, 3 };
	
	private int min;
	
	private int max;

	public Vetor(int vetor[], int min, int max) {
		this.vetor = vetor;
		this.min = min;
		this.max = max;
	}
	
	public Vetor() { }
	
	public boolean contains(int a) {
		for (int i = 0; i < this.vetor.length; i++) {
			if (this.vetor[i] == a) {
				return true;
			}
		}
		return false;
	}

	public int[] getVetor() {
		return vetor;
	}

	public void setVetor(int[] vetor) {
		this.vetor = vetor;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
	
}
