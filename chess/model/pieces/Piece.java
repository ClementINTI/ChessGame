package chess.model.pieces;

import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import chess.model.Case;
import chess.model.Deplacement;
import chess.model.Partie;
import chess.model.Plateau;

public class Piece {
	private String image;
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
		this.image = "/src/chess/piecesImage/white_king.png";
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
	 * Donne tout les d�placement
	 * 
	 * @return
	 */
	public List<Deplacement> deplacer(Plateau plateau, Case emplacement) {
		List<Case> listeCase  = plateau.getListeCase();
		List<Deplacement> deplacements = new ArrayList<>();
		for (int i = 0; i < 64; i++) {
			if (emplacement != listeCase.get(i)) {
				if (listeCase.get(i).getPiece() != null) {
					if (listeCase.get(i).getPiece().isBlanc() != emplacement.getPiece().isBlanc()) {

						deplacements.add(new Deplacement(emplacement, listeCase.get(i)));
					}
				} else {
					deplacements.add(new Deplacement(emplacement, listeCase.get(i)));
				}
			}
		}



		return deplacements;
	}

}
