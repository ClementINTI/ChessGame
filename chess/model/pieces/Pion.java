package chess.model.pieces;

import java.util.ArrayList;
import java.util.List;

import chess.model.Case;
import chess.model.Deplacement;
import chess.model.Plateau;

public class Pion extends Piece {

	public Pion(String nom, boolean blanc) {
		super(nom, blanc);
	}

	@Override
	public String getNom() {
		return "Pion";
	}

	@Override
	public String getImage() {
		if (isBlanc()) {
			return "/chess/piecesImage/white_pawn.png";
		} else {
			return "/chess/piecesImage/black_pawn.png";
		}
	}

	@Override
	public List<Deplacement> deplacer(Plateau plateau, Case emplacement) {
		List<Case> listeCase = plateau.getListeCase();
		List<Deplacement> deplacements = new ArrayList<>();

		int indexActuelle = listeCase.indexOf(emplacement);
		boolean caseEcartdroite1 = indexActuelle % 8 < 7;
		boolean caseEcartgauche1 = indexActuelle % 8 > 0;
		if (!emplacement.getPiece().isBlanc()) {
			// Noir va vers le haut
			if (indexActuelle > 7) {
				int indexPossible = indexActuelle + 8;
				if (listeCase.get(indexPossible).getPiece() == null) {
					deplacements.add(new Deplacement(emplacement, listeCase.get(indexPossible)));
				}
				if (caseEcartgauche1) {
					indexPossible = indexActuelle + 7;
					if (listeCase.get(indexPossible).getPiece() != null) {
						if (listeCase.get(indexPossible).getPiece().isBlanc() == true) {
							deplacements.add(new Deplacement(emplacement, listeCase.get(indexPossible)));
						}
					}
				}
				if (caseEcartdroite1) {
					/*
					 * for (int i = 1; i < 64; i++) { //System.out.println(listeCase.get(i)); if
					 * (emplacement.getPiece().isBlanc() == true) { if (emplacement !=
					 * listeCase.get(i)) { //if (emplacement.getPiece().isBlanc()) { if
					 * (listeCase.get(i).getPiece() != null) { if
					 * (listeCase.get(i).getPiece().isBlanc() != emplacement.getPiece().isBlanc()) {
					 * if (emplacement == listeCase.get(i + 7) || emplacement == listeCase.get(i +
					 * 9)) { deplacements.add(new Deplacement(emplacement, listeCase.get(i))); } } }
					 * else { if (listeCase.get(i).getPiece() == null)
					 */
					indexPossible = indexActuelle + 9;
					if (listeCase.get(indexPossible).getPiece() != null) {
						if (listeCase.get(indexPossible).getPiece().isBlanc() == true) {
							deplacements.add(new Deplacement(emplacement, listeCase.get(indexPossible)));
						}
					}
				}
			}
		} else {
			if (indexActuelle < 56) {
				int indexPossible = indexActuelle - 8;
				if (listeCase.get(indexPossible).getPiece() == null) {
					deplacements.add(new Deplacement(emplacement, listeCase.get(indexPossible)));
				}
				if (caseEcartgauche1) {

					indexPossible = indexActuelle - 7;
					if (listeCase.get(indexPossible).getPiece() != null) {
						if (listeCase.get(indexPossible).getPiece().isBlanc() == false) {
							deplacements.add(new Deplacement(emplacement, listeCase.get(indexPossible)));
						}
					}
				}
				if (caseEcartdroite1) {

					indexPossible = indexActuelle - 9;
					if (listeCase.get(indexPossible).getPiece() != null) {
						if (listeCase.get(indexPossible).getPiece().isBlanc() == false) {
							deplacements.add(new Deplacement(emplacement, listeCase.get(indexPossible)));
						}
					}
				}
			}
		}
		return deplacements;
	}
}
