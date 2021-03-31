package chess.model;

import java.util.ArrayList;
import java.util.List;

import chess.model.pieces.Piece;

public class Plateau {
	private Case colonne0ligne0, colonne1ligne0, colonne2ligne0, colonne3ligne0, colonne4ligne0, colonne5ligne0,
			colonne6ligne0, colonne7ligne0;
	private Case colonne0ligne2, colonne1ligne2, colonne2ligne2, colonne3ligne2, colonne4ligne2, colonne5ligne2,
			colonne6ligne2, colonne7ligne2;
	private Case colonne0ligne3, colonne1ligne3, colonne2ligne3, colonne3ligne3, colonne4ligne3, colonne5ligne3,
			colonne6ligne3, colonne7ligne3;
	private Case colonne0ligne4, colonne1ligne4, colonne2ligne4, colonne3ligne4, colonne4ligne4, colonne5ligne4,
			colonne6ligne4, colonne7ligne4;
	private Case colonne0ligne5, colonne1ligne5, colonne2ligne5, colonne3ligne5, colonne4ligne5, colonne5ligne5,
			colonne6ligne5, colonne7ligne5;
	private Case colonne0ligne6, colonne1ligne6, colonne2ligne6, colonne3ligne6, colonne4ligne6, colonne5ligne6,
			colonne6ligne6, colonne7ligne6;
	private Case colonne0ligne7, colonne1ligne7, colonne2ligne7, colonne3ligne7, colonne4ligne7, colonne5ligne7,
			colonne6ligne7, colonne7ligne7;
	private List<Piece> piecesNoir = new ArrayList<Piece>();
	private List<Piece> piecesBlanc = new ArrayList<Piece>();

	private Plateau() {
		super();
	}

	/**
	 * !!! Finir d'implementer le constructeur !!!
	 * 
	 * @return Plateau à l'état initial
	 */
	public static Plateau initialiserPlateau() {
		return new Plateau();

	}

	/**
	 * !!! a implementer !!!
	 * 
	 * @param piece
	 * @param position actuelle de la pièce
	 * @return
	 */
	public static Deplacement donnerDeplacement(Piece piece, Case position) {
		return null;

	}

}
