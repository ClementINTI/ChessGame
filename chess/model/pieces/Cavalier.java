package chess.model.pieces;

import java.util.ArrayList;
import java.util.List;

import chess.model.Case;
import chess.model.Plateau;

public class Cavalier extends Piece {

	public Cavalier(String nom, boolean blanc) {
		super(nom, blanc);
	}

	@Override
	public String getNom() {
		return "Cavalier";
	}

	@Override
	public String getImage() {
		if (isBlanc()) {
			return "/chess/piecesImage/white_knight.png";
		} else {
			return "/chess/piecesImage/black_knight.png";
		}
	}

	@Override
	public List<Integer> deplacer(Plateau plateau, Case emplacement) {
		List<Case> listeCase = plateau.getListeCase();
		List<Integer> deplacements = new ArrayList<>();
		int indexActuelle = listeCase.indexOf(emplacement);
		boolean caseEcartTop1 = indexActuelle > 7;
		boolean caseEcartTop2 = indexActuelle > 15;
		boolean caseEcartBas1 = indexActuelle < 56;
		boolean caseEcartBas2 = indexActuelle < 48;
		boolean caseEcartdroite1 = indexActuelle % 8 < 7;
		boolean caseEcartdroite2 = indexActuelle % 8 < 6;
		boolean caseEcartgauche1 = indexActuelle % 8 > 0;
		boolean caseEcartgauche2 = indexActuelle % 8 > 1;
		if (caseEcartBas1 && caseEcartgauche2)
			deplacementPossible(deplacements, indexActuelle + 6, listeCase);
		if (caseEcartBas2 && caseEcartgauche1)
			deplacementPossible(deplacements, indexActuelle + 15, listeCase);
		if (caseEcartBas1 && caseEcartdroite2)
			deplacementPossible(deplacements, indexActuelle + 10, listeCase);
		if (caseEcartBas2 && caseEcartdroite1)
			deplacementPossible(deplacements, indexActuelle + 17, listeCase);
		if (caseEcartTop1 && caseEcartdroite2)
			deplacementPossible(deplacements, indexActuelle - 6, listeCase);
		if (caseEcartTop2 && caseEcartdroite1)
			deplacementPossible(deplacements, indexActuelle - 15, listeCase);
		if (caseEcartTop1 && caseEcartgauche2)
			deplacementPossible(deplacements, indexActuelle - 10, listeCase);
		if (caseEcartTop2 && caseEcartgauche1)
			deplacementPossible(deplacements, indexActuelle - 17, listeCase);
		return deplacements;
	}

	private void deplacementPossible(List<Integer> deplacements, int indexPossible, List<Case> listeCase) {
		Case casePossible = listeCase.get(indexPossible);
		if (casePossible.getPiece() != null) {
			if (casePossible.getPiece().isBlanc() != isBlanc()) {
				deplacements.add(indexPossible);
			}
		} else {
			deplacements.add(indexPossible);
		}
	}
}
