package chess.model.pieces;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import chess.model.Case;
import chess.model.Deplacement;
import chess.model.Plateau;

public class Fou extends Piece {

	public Fou(String nom, boolean blanc) {
		super(nom, blanc);
	}

	@Override
	public String getNom() {
		return "Fou";
	}

	@Override
	public String getImage() {
		return "/src/chess/piecesImage/white_bishop.png";
	}

	@Override
	public List<Deplacement> deplacer(Plateau plateau, Case emplacement) {
		List<Case> listeCase  = plateau.getListeCase();
		List<Deplacement> deplacements = new ArrayList<>();
		for (int i = 0; i < 64; i++) {
			if (emplacement != listeCase.get(i)) {
				deplacements.add(new Deplacement(emplacement, listeCase.get(i)));
			}
		}
		return deplacements;


	}
}
