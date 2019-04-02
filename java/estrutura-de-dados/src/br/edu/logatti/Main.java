package br.edu.logatti;

import java.util.Scanner;

import br.edu.logatti.chained_pile.Game;
import br.edu.logatti.chained_pile.GamePile;
import br.edu.logatti.fila.Aluno;
import br.edu.logatti.fila.Fila;
import br.edu.logatti.fila_estatica.FilaEstatica;
import br.edu.logatti.fila_estatica.Pessoa;

public class Main {

	public static void main(String[] args) {
		
		
		FilaEstatica filaEstatica = new FilaEstatica(5);
		for (int i = 1; i < 6; i++) {
			filaEstatica.push(new Pessoa("Matheus " + i, "Martins " + i, "66-" + i, 'M'));
		}
		filaEstatica.print();
		filaEstatica.pop();
		filaEstatica.print();
		filaEstatica.pop();
		filaEstatica.print();
		filaEstatica.pop();
		filaEstatica.print();
		filaEstatica.pop();
		filaEstatica.print();
		filaEstatica.pop();
		filaEstatica.print();
		filaEstatica.pop();
		filaEstatica.push(new Pessoa("Matheus ", "Martins ", "66-", 'M'));
		filaEstatica.print();
		
		
		/*Fila fila = new Fila();
		for (int i = 0; i < 10; i++) {
			fila.push(new Aluno((i + 1), "Aluno " + (i + 1), "Silva " + (i + 1)));
		}
		fila.print();
		System.out.println(fila.count());
		fila.pop();
		System.out.println(fila.count());
		fila.print();
		System.out.println(fila.getByName("Aluno 2").getNome());*/
		
		/*@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		GamePile pile = new GamePile();
		boolean showMenu = true;
		int selected;
		
		do {
			System.out.println("\nInforme uma opção.");
			System.out.println("[1] INSERIR.");
			System.out.println("[2] REMOVER.");
			System.out.println("[3] IMPRIMIR");
			System.out.println("[4] QUANTIDADE DA PILHA");
			System.out.println("[5] BUSCAR POR NOME");
			System.out.println("[0] SAIR\n");
			selected = scanner.nextInt();
			switch(selected) {
				case 1:
					pile.push(createGame());
					break;
				case 2:
					pile.pop();
					break;
				case 3:
					pile.print();
					break;
				case 4:
					printHasPile(pile.countPile());
					break;
				case 5:
					printGame(pile);
					break;
				case 0:
					showMenu = false;
					break;
				default: System.out.println("Opção inválida!\n");
			}
		} while (showMenu != false);*/
		
	}
	
	@SuppressWarnings("resource")
	public static Game createGame() {
		Game game = new Game();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Informe o nome do Jogo! ");
		game.setName(scanner.nextLine());
		System.out.println("Informe o genero do Jogo! ");
		game.setGenre((scanner.nextLine()));
		game.setId((int)(Math.random() * 33) + 1);
		return game;
	}
	
	public static void printHasPile(int qtd) {
		if (qtd > 0) {
			System.out.println("Pile has " + qtd + " elements.");
		} else {
			System.out.println("Pile is empty.");
		}
	}
	
	public static void printGame(GamePile pile) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Informe o nome para busca!");
		String name = scanner.nextLine();
		Game game = pile.getByName(name);
		if (game != null) {
			System.out.println(game.getName() + " encontrado com sucesso!");
		} else {
			System.out.println("O jogo " + name + " não foi encontrado na pilha!");
		}
	}

}
