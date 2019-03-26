package br.edu.logatti.fila;

public class Fila {
	
	private Aluno head;
	private Aluno tail;
	
	public void push(Aluno aluno) {
		if (this.tail == null) {
			this.tail = aluno;
		} else {
			this.tail.setNextAluno(aluno);
			if (this.head == null) {
				this.head = tail;
			}
			this.tail = aluno;
		}
		System.out.println(aluno.getNome() + " adicionado com sucesso!");
	}
	
	public void pop() {
		if (isVazia()) {
			System.out.println("Fila está vazia.");
		} else {
			Aluno auxiliar = this.head;
			if (auxiliar != null) {
				this.head = auxiliar.getNextAluno();
				auxiliar = null;
			}
		}
	}
	
	public void print( ) {
		if (isVazia()) {
			System.out.println("Fila está vazia.");
		} else {
			Aluno auxiliar = this.head;
			do {
				System.out.println(auxiliar.getNome() + " " + auxiliar.getSobrenome());
				auxiliar = auxiliar.getNextAluno();
			} while(auxiliar != null);
		}
	}
	
	public int count() {
		int count = 1;
		if (isVazia()) {
			System.out.println("Fila está vazia.");
		} else {
			Aluno auxiliar = this.head;
			do {
				if (auxiliar.getNextAluno() == null) {
					return count;
				}
				auxiliar = auxiliar.getNextAluno();
				count++;
			} while(auxiliar != null);
		}
		return count;
	}
	
	public Aluno getByName(String name) {
		if (isVazia()) {
			System.out.println("Fila está vazia.");
		} else {
			Aluno auxiliar = this.head;
			do {
				if (name.equals(auxiliar.getNome())) {
					return auxiliar;
				}
				auxiliar = auxiliar.getNextAluno();
			} while(auxiliar != null);
		}
		return null;
	}
	
	public boolean isVazia() {
		return this.tail == null && this.head == null;
	}

}
