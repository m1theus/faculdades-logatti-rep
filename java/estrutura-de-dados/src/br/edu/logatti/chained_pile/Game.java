package br.edu.logatti.chained_pile;

public class Game {

	private int id;
	
	private String name;
	
	private String genre;
	
	private Game previousGame;

	public Game(int id, String name, String genre) {
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.previousGame = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public Game getPreviousGame() {
		return previousGame;
	}

	public void setPreviousGame(Game previousGame) {
		this.previousGame = previousGame;
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
				.append("ID: ")
				.append(this.id)
				.append(" ")
				.append("Name: ")
			    .append(this.name)
			    .append(" ")
			    .append("Genre: ")
			    .append(this.genre)
			    .toString();
	}
	
}
