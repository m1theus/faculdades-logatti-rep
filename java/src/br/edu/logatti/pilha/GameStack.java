package br.edu.logatti.pilha;

public class GameStack {

	private static Game top;
	
	private static Game[] gameStack;
	
	private static int count = 0;
	
	public GameStack() {
		gameStack = new Game[5];
		System.out.println("Game Stack criada com sucesso!");
	}
	
	public static void push(Game game) {
		top = game;
		gameStack[count] = game;
		System.out.println(game.getName() + " adicionado com sucesso!");
		count++;
	}
	
	public static void pop() {
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
