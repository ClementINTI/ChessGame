package chess.model.pieces;

import java.util.ArrayList;
import java.util.List;

import chess.model.Case;
import chess.model.Plateau;

public class Piece {
	private String image;
	private String nom;
	private boolean blanc;
	protected boolean aBouger;

	/**
	 * 
	 * @param nom
	 * @param blanc true pour blanc ; false pour noir
	 */
	public Piece(String nom, boolean blanc) {
		super();
		this.nom = nom;
		this.blanc = blanc;
		aBouger = false;
		this.image = "/src/chess/piecesImage/white_king.png";
	}

	public void setaBouger() {
		this.aBouger = true;
	}

	public String getNom() {
		return nom;

	}

	public String getImage() {
		return image;

	}

	public boolean isBlanc() {
		return blanc;
	}

	/**
	 * Donne tout les index des cases possibles
	 * 
	 * @return
	 */
	public List<Integer> deplacer(Plateau plateau, Case emplacement) {
		List<Case> listeCase = plateau.getListeCase();
		List<Integer> deplacements = new ArrayList<>();
		for (int i = 0; i < 64; i++) {
			if (emplacement != listeCase.get(i)) {
				if (listeCase.get(i).getPiece() != null) {
					if (listeCase.get(i).getPiece().isBlanc() != emplacement.getPiece().isBlanc()) {

						deplacements.add(i);
					}
				} else {
					deplacements.add(i);
				}
			}
		}

		return deplacements;
	}

}
