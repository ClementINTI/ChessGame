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
		return "/chess/piecesImage/white_rook.png";
	}

	@Override
	public List<Deplacement> deplacer(Plateau plateau, Case emplacement) {
		List<Case> listeCase  = plateau.getListeCase();
		List<Deplacement> deplacements = new ArrayList<>();
		for (int i = 0; i < 64; i++) {
			System.out.println(listeCase.get(i));
			if (emplacement.getPiece().isBlanc() == true) {
				if (emplacement != listeCase.get(i)) {
					//if (emplacement.getPiece().isBlanc()) {
					if (listeCase.get(i).getPiece() != null) {
						if (listeCase.get(i).getPiece().isBlanc() != emplacement.getPiece().isBlanc()) {
							if (emplacement == listeCase.get(i + 1) ||  emplacement == listeCase.get(i + 8) ) {
								deplacements.add(new Deplacement(emplacement, listeCase.get(i)));
							}
						}
					} else {
						if (emplacement == listeCase.get(i + 8) ||
								emplacement == listeCase.get(i + 16) ||
								emplacement == listeCase.get(i + 24) ||
								emplacement == listeCase.get(i + 32) ||
								emplacement == listeCase.get(i + 40) ||
								//emplacement == listeCase.get(i + 48) ||
								emplacement == listeCase.get(i + 52) ) {
							deplacements.add(new Deplacement(emplacement, listeCase.get(i)));
						}
					}
					//}
				}
			} else {
				if (emplacement != listeCase.get(i)) {
					if (listeCase.get(i).getPiece() != null) {
						if (listeCase.get(i).getPiece().isBlanc() != emplacement.getPiece().isBlanc()) {
							if ( emplacement == listeCase.get(i-7) || emplacement == listeCase.get(i-9)) {
								deplacements.add(new Deplacement(emplacement, listeCase.get(i)));
							}
						}
					} else {
						if ( emplacement == listeCase.get(i-8)) {
							deplacements.add(new Deplacement(emplacement, listeCase.get(i)));
						}
					}
				}
			}
		}
		return deplacements;
	}
}
