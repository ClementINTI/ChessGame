package chess.model.pieces;

import java.util.ArrayList;
import java.util.List;

import chess.model.Case;
import chess.model.Deplacement;
import chess.model.Plateau;

public class Roi extends Piece {

	public Roi(String nom, boolean blanc) {
		super(nom, blanc);
	}

	@Override
	public String getNom() {
		return "Roi";
	}

	@Override
	public String getImage() {
		if (isBlanc()) {
			return "/chess/piecesImage/white_king.png";
		} else {
			return "/chess/piecesImage/black_king.png";
		}
	}

	@Override
	public List<Deplacement> deplacer(Plateau plateau, Case emplacement) {
		List<Case> listeCase = plateau.getListeCase();
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
