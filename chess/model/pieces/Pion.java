package chess.model.pieces;

import java.util.ArrayList;
import java.util.List;

import chess.model.Case;
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
	public List<Integer> deplacer(Plateau plateau, Case emplacement) {
		List<Case> listeCase = plateau.getListeCase();
		List<Integer> deplacements = new ArrayList<>();

		int indexActuelle = listeCase.indexOf(emplacement);
		boolean caseEcartdroite1 = indexActuelle % 8 < 7;
		boolean caseEcartgauche1 = indexActuelle % 8 > 0;
		if (!emplacement.getPiece().isBlanc()) {
			// Noir va vers le haut
			if (indexActuelle > 7) {
				int indexPossible = indexActuelle + 8;
				if (listeCase.get(indexPossible).getPiece() == null) {
					deplacements.add(indexPossible);
				}
				if (!aBouger) {
					indexPossible = indexActuelle + 16;
					if (listeCase.get(indexPossible).getPiece() == null) {
						deplacements.add(indexPossible);
					}
				}
				if (caseEcartgauche1) {
					indexPossible = indexActuelle + 7;
					if (listeCase.get(indexPossible).getPiece() != null) {
						if (listeCase.get(indexPossible).getPiece().isBlanc() == true) {
							deplacements.add(indexPossible);
						}
					}
				}
				if (caseEcartdroite1) {
					indexPossible = indexActuelle + 9;
					if (listeCase.get(indexPossible).getPiece() != null) {
						if (listeCase.get(indexPossible).getPiece().isBlanc() == true) {
							deplacements.add(indexPossible);
						}
					}
				}
			}
		} else {
			if (indexActuelle < 56) {
				int indexPossible = indexActuelle - 8;
				if (listeCase.get(indexPossible).getPiece() == null) {
					deplacements.add(indexPossible);
				}
				if (!aBouger) {
					indexPossible = indexActuelle - 16;
					if (listeCase.get(indexPossible).getPiece() == null) {
						deplacements.add(indexPossible);
					}
				}
				if (caseEcartgauche1) {

					indexPossible = indexActuelle - 7;
					if (listeCase.get(indexPossible).getPiece() != null) {
						if (listeCase.get(indexPossible).getPiece().isBlanc() == false) {
							deplacements.add(indexPossible);
						}
					}
				}
				if (caseEcartdroite1) {

					indexPossible = indexActuelle - 9;
					if (listeCase.get(indexPossible).getPiece() != null) {
						if (listeCase.get(indexPossible).getPiece().isBlanc() == false) {
							deplacements.add(indexPossible);
						}
					}
				}
			}
		}
		return deplacements;
	}
}
