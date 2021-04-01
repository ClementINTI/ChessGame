package chess.model.pieces;

import java.net.URL;
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
		return "/src/chess/piecesImage/white_king.png";
	}

	@Override
	public List<Deplacement> deplacer(Plateau plateau, Case emplacement) {
		return null;
	}

}
