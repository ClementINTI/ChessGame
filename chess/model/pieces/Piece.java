package chess.model.pieces;

import chess.model.Deplacement;
import chess.model.Plateau;

import java.net.URL;

public abstract class Piece {

	private String nom;
	private boolean blanc;

	public Piece(String nom, boolean blanc) {
		super();
		this.nom = nom;
		this.blanc = blanc;
	}

	public abstract String getNom();

	public abstract URL getImage();


	public boolean isBlanc() {
		return blanc;
	}

	public abstract Deplacement deplacer(Plateau plateau);

}
