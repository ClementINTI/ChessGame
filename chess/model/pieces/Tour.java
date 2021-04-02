package chess.model.pieces;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import chess.model.Case;
import chess.model.Deplacement;
import chess.model.Plateau;

public class Tour extends Piece {

	public Tour(String nom, boolean blanc) {
		super(nom, blanc);
	}

	@Override
	public String getNom() {
		return "Tour";
	}

	@Override
	public String getImage() {
		if (isBlanc()) {
			return "/chess/piecesImage/white_rook.png";
		} else {
			return "/chess/piecesImage/black_rook.png";
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
				indexPossible = indexPossible + 8;
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
