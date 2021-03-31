package chess.model;

public class Piece {

	private String nom;
	private boolean blanc;

	public Piece(String nom, boolean blanc) {
		super();
		this.nom = nom;
		this.blanc = blanc;
	}

	public String getNom() {
		return nom;
	}

	public boolean isBlanc() {
		return blanc;
	}

	public Deplacement deplacer(Plateau plateau) {
		return null;
	}

}
