package chess.model.pieces;

import java.net.URL;

import chess.model.Case;
import chess.model.Deplacement;
import chess.model.Plateau;

public class Pion extends Piece {

	public Pion(String nom, boolean blanc) {
		super(nom, blanc);
	}

	@Override
	public String getNom() {
		return null;
	}

	@Override
	public URL getImage() {
		return null;
	}

	@Override
	public Deplacement deplacer(Plateau plateau, Case emplacement) {
		return null;
	}
}
