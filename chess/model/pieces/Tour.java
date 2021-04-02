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
		List<Case> listeCase  = plateau.getListeCase();
		List<Deplacement> deplacements = new ArrayList<>();
		for (int i = 0; i < 64; i++) {
			//System.out.println(listeCase.get(i));
			if (emplacement.getPiece().isBlanc()) {
				if (emplacement != listeCase.get(i)) {
					if (listeCase.get(i).getPiece() != null) {
						if (listeCase.get(i).getPiece().isBlanc() != emplacement.getPiece().isBlanc()) {
							if (emplacement == listeCase.get(i+8) || emplacement == listeCase.get(i+1)
									|| emplacement == listeCase.get(i-1) || emplacement == listeCase.get(i+8)) {
								deplacements.add(new Deplacement(emplacement, listeCase.get(i)));
							}
						} else {
							if (emplacement == listeCase.get(i+1) || emplacement == listeCase.get(i-1)
									|| emplacement == listeCase.get(i+8)|| emplacement == listeCase.get(i-8)) {
								deplacements.add(new Deplacement(emplacement, listeCase.get(i)));
							}
						}
					} else {
							if (emplacement == listeCase.get(i + 8) || emplacement == listeCase.get(i + 1)
								|| emplacement == listeCase.get(i - 1) || emplacement == listeCase.get(i - 8) ) {
								deplacements.add(new Deplacement(emplacement, listeCase.get(i)));
							}

					}
				}
			} else {
				if (emplacement != listeCase.get(i)) {
					if (listeCase.get(i).getPiece() != null) {
						if (listeCase.get(i).getPiece().isBlanc() != emplacement.getPiece().isBlanc()) {
							if ( emplacement == listeCase.get(i-8)) {
								deplacements.add(new Deplacement(emplacement, listeCase.get(i)));
							}
						}
					} else {
						if ( emplacement == listeCase.get(i-8) || emplacement == listeCase.get(i+8)
								|| emplacement == listeCase.get(i + 8) || emplacement == listeCase.get(i + 1) ) {
							deplacements.add(new Deplacement(emplacement, listeCase.get(i)));
						}
					}
				}
			}
		}
		return deplacements;
	}
}
