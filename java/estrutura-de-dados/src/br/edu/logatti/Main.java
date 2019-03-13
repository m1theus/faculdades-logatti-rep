package br.edu.logatti;

import br.edu.logatti.pilha.Game;
import br.edu.logatti.pilha.GameStack;

public class Main {

	public static void main(String[] args) {
		GameStack gameStack = new GameStack();
		gameStack.push(new Game(1, "Fortnite", "BattleRoyale"));
		gameStack.push(new Game(2, "Resident Evil", "Terror"));
		gameStack.push(new Game(3, "League of Legends", "MOBA"));
		gameStack.push(new Game(4, "Grand Theft Auto V", "Action/Adventure"));
		gameStack.push(new Game(5, "God of War", "Action/Adventure"));
		
		System.out.println("--------------------\nPrinting stack");
		gameStack.printStack();
		System.out.println("--------------------");
		gameStack.pop();
		System.out.println("--------------------\nPrinting stack with pop");
		gameStack.printStack();
	}

}
