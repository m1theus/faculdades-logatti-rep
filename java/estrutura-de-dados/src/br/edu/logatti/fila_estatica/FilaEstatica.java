package br.edu.logatti.fila_estatica;

public class FilaEstatica {
	
	private int head;
	
	private int tail;
	
	private Pessoa[] fila;
	
	public FilaEstatica(int tamanho) {
		this.fila = new Pessoa[tamanho];
		this.head = -1;
		this.tail = -1;
	}
	
	public void push(Pessoa pessoa) {
		if (this.isEmpty()) {
			this.head = 0;
		}
		
		if (this.isFull()) {
			System.out.println("Fila cheia!");
		} else {
			this.tail = (this.tail + 1) % this.fila.length;
			
			if (this.fila[this.tail] == null) {
				this.fila[this.tail] = pessoa;
			}
		}
	}
	
	public void pop() {
		if (this.isEmpty()) {
			System.out.println("Fila vazia!");
			return;
		}
		
		this.fila[this.head] = null;
		this.head++;

		if (this.head == this.tail) {
			this.head = -1;
			this.tail = -1;
		} else {
			this.head = (this.head + 1) % this.fila.length - 1;
		}
		
	}
	
	public void print() {
		if (this.isEmpty()) {
			System.out.println("Fila vazia!");
		} else {
			for (int i = 0; i < fila.length; i++) {
				if (this.fila[i] != null) {
					System.out.println(this.fila[i].getNome());
				}
			}

		}
	}
	
	private boolean isFull() {
		return (this.fila.length -1) == this.tail;
	}
	
	private boolean isEmpty() {
		return (this.head == -1) && (this.tail == -1);
	}

}
