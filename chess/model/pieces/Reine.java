package chess.model.pieces;

import java.net.URL;
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
		return "/src/chess/piecesImage/white_queen.png";
	}

	@Override
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
