package br.edu.logatti.chained_pile;

public class GamePile {

	private Game top;
	
	public GamePile() {
		System.out.println("Game pile criada com sucesso!");
	}
	
	public void push(Game game) {
		game.setPreviousGame(this.top);
		this.top = game;
		System.out.println(game.getName() + " adicionado com sucesso!");
	}
	
	public GamePile pop() {
		if (this.top == null) {
			System.out.println("Pile is empty");
		} else {
			Game gameToRemove = this.top;
			this.top = this.top.getPreviousGame();
			System.out.println(gameToRemove.getName() + " removido com sucesso!");
			gameToRemove = null;
		}
		return this;
	}
	
	public GamePile print() {
		if (this.top == null) {
			System.out.println("Pile is empty");
		} else {
			Game auxiliary = this.top;
			do {
				System.out.println(auxiliary);
				auxiliary = auxiliary.getPreviousGame();
			} while(auxiliary != null);
		}
		return this;
	}
	
}
