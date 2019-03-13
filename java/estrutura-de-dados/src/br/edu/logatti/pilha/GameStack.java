package br.edu.logatti.pilha;

public class GameStack {

	private Game top;
	
	private Game[] gameStack;
	
	private int count = 0;
	
	public GameStack() {
		gameStack = new Game[5];
		System.out.println("Game Stack criada com sucesso!");
	}
	
	public void push(Game game) {
		game.setPreviousGame(top);
		top = game;
		gameStack[count] = game;
		System.out.println(game.getName() + " adicionado com sucesso!");
		count++;
	}
	
	public void pop() {
		Game gameToRemove = gameStack[count - 1];
		gameStack[count - 1] = null;
		System.out.println(gameToRemove.getName() + " removido com sucesso!");
		gameToRemove = null;
	}
	
	public void printStack() {
		for (int i = gameStack.length - 1; i >= 0 ; i--) {
			if (gameStack[i] != null) {
				System.out.println(gameStack[i]);
			}
		}
	}
	
}
