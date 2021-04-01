package chess.model.pieces;

import java.awt.Image;
import java.net.URL;
import java.util.List;

import chess.model.Case;
import chess.model.Deplacement;
import chess.model.Plateau;

public class Piece {
	private Image image;
	private String nom;
	private boolean blanc;

	/**
	 * 
	 * @param nom
	 * @param blanc true pour blanc ; false pour noir
	 */
	public Piece(String nom, boolean blanc) {
		super();
		this.nom = nom;
		this.blanc = blanc;
	}

	public String getNom() {
		return nom;

	}

	public URL getImage() {
		return null;

	}

	public boolean isBlanc() {
		return blanc;
	}

	/**
	 * Donne tout les déplacement
	 * 
	 * @return
	 */
	public List<Deplacement> deplacer(Plateau plateau, Case emplacement) {
		// plateau.getListeCase();
		return null;

	}

}
