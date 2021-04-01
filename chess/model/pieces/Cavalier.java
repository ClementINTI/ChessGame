package chess.model.pieces;

import java.net.URL;
import java.util.List;

import chess.model.Case;
import chess.model.Deplacement;
import chess.model.Plateau;

public class Cavalier extends Piece {

	public Cavalier(String nom, boolean blanc) {
		super(nom, blanc);
	}

	@Override
	public String getNom() {
		return null;
	}

	@Override
	public String getImage() {
		return "/src/chess/piecesImage/white_king.png";
	}

	@Override
	public List<Deplacement> deplacer(Plateau plateau, Case emplacement) {
		return null;
	}
}
