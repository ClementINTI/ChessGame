package chess.model.pieces;

import java.util.ArrayList;
import java.util.List;

import chess.model.Case;
import chess.model.Deplacement;
import chess.model.Plateau;

public class Reine extends Piece {

	public Reine(String nom, boolean blanc) {
		super(nom, blanc);
	}

	@Override
	public String getNom() {
		return "Reine";
	}

	@Override
	public String getImage() {
		if (isBlanc()) {
			return "/chess/piecesImage/white_queen.png";
		} else {
			return "/chess/piecesImage/black_queen.png";
		}
	}

	@Override
	public List<Deplacement> deplacer(Plateau plateau, Case emplacement) {
		List<Case> listeCase = plateau.getListeCase();
		List<Deplacement> deplacements = new ArrayList<>();
		int indexActuelle = listeCase.indexOf(emplacement);
		int indexPossible = indexActuelle;
		boolean continuerIteration = true;
//deplacement vers le haut et la gauche
		do {
			if ((indexPossible % 8 > 0) && indexPossible > 7) {
				indexPossible = indexPossible - 9;
				Case casePossible = listeCase.get(indexPossible);
				if (casePossible.getPiece() != null) {
					continuerIteration = false;
					if (casePossible.getPiece().isBlanc() != isBlanc()) {
						deplacements.add(new Deplacement(emplacement, casePossible));
					}
				} else {
					deplacements.add(new Deplacement(emplacement, casePossible));
				}
			} else {
				continuerIteration = false;
			}
		} while (continuerIteration);
		indexPossible = indexActuelle;
		continuerIteration = true;
		// deplacement vers le haut et la droite
		do {
			if ((indexPossible % 8 < 7) && indexPossible > 7) {
				indexPossible = indexPossible - 7;
				Case casePossible = listeCase.get(indexPossible);
				if (casePossible.getPiece() != null) {
					continuerIteration = false;
					if (casePossible.getPiece().isBlanc() != isBlanc()) {
						deplacements.add(new Deplacement(emplacement, casePossible));
					}
				} else {
					deplacements.add(new Deplacement(emplacement, casePossible));
				}
			} else {
				continuerIteration = false;
			}
		} while (continuerIteration);
		indexPossible = indexActuelle;
		continuerIteration = true;
		// deplacement vers le bas et la gauche
		do {
			if ((indexPossible % 8 > 0) && indexPossible < 56) {
				indexPossible = indexPossible + 7;
				Case casePossible = listeCase.get(indexPossible);
				if (casePossible.getPiece() != null) {
					continuerIteration = false;
					if (casePossible.getPiece().isBlanc() != isBlanc()) {
						deplacements.add(new Deplacement(emplacement, casePossible));
					}
				} else {
					deplacements.add(new Deplacement(emplacement, casePossible));
				}
			} else {
				continuerIteration = false;
			}
		} while (continuerIteration);
		indexPossible = indexActuelle;
		continuerIteration = true;
		// deplacement vers le bas et la droite
		do {
			if ((indexPossible % 8 < 7) && indexPossible < 56) {
				indexPossible = indexPossible + 9;
				Case casePossible = listeCase.get(indexPossible);
				if (casePossible.getPiece() != null) {
					continuerIteration = false;
					if (casePossible.getPiece().isBlanc() != isBlanc()) {
						deplacements.add(new Deplacement(emplacement, casePossible));
					}
				} else {
					deplacements.add(new Deplacement(emplacement, casePossible));
				}
			} else {
				continuerIteration = false;
			}
		} while (continuerIteration);
		return deplacements;
	}

}
