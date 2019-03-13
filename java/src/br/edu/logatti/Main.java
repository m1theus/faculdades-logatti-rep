package br.edu.logatti;

import br.edu.logatti.pilha.Game;
import br.edu.logatti.pilha.GameStack;

public class Main {

	public static void main(String[] args) {
		GameStack gameStack = new GameStack();
		GameStack.push(new Game(1, "Teste 1", "Teste 1"));
		GameStack.push(new Game(2, "Teste 2", "Teste 2"));
		GameStack.push(new Game(3, "Teste 3", "Teste 3"));
		GameStack.push(new Game(4, "Teste 4", "Teste 4"));
		GameStack.push(new Game(5, "Teste 5", "Teste 5"));
		
		System.out.println("--------------------\nPrintando Pilha");
		gameStack.printStack();
		System.out.println("--------------------");
		GameStack.pop();
		System.out.println("--------------------\nPrintando Pilha com pop");
		gameStack.printStack();
	}

}
