package br.edu.logatti;

import br.edu.logatti.chained_pile.Game;
import br.edu.logatti.chained_pile.GamePile;

public class Main {

	public static void main(String[] args) {
		GamePile gameStack = new GamePile();
		gameStack.push(new Game(1, "Fortnite", "BattleRoyale"));
		gameStack.push(new Game(2, "Resident Evil", "Terror"));
		gameStack.push(new Game(3, "League of Legends", "MOBA"));
		gameStack.push(new Game(4, "Grand Theft Auto V", "Action/Adventure"));
		gameStack.push(new Game(5, "God of War", "Action/Adventure"));
		
		System.out.println("--------------------\nPrinting stack");
		gameStack.print();
		System.out.println("--------------------");
		gameStack.pop();
		System.out.println("--------------------\nPrinting stack with pop");
		gameStack.print();
		System.out.println("--------------------");
		gameStack.print()
				 .pop()
				 .print()
				 .pop()
				 .print()
				 .pop()
				 .print()
				 .pop()
				 .print();
	}

}
