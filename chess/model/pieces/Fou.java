package chess.model.pieces;

import java.net.URL;
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
		return null;
	}

	@Override
	public URL getImage() {
		return null;
	}

	@Override
	public List<Deplacement> deplacer(Plateau plateau, Case emplacement) {
		return null;
	}
}
