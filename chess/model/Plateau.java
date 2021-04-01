package chess.model;

import java.util.ArrayList;
import java.util.List;

import chess.model.pieces.Cavalier;
import chess.model.pieces.Fou;
import chess.model.pieces.Piece;
import chess.model.pieces.Pion;
import chess.model.pieces.Reine;
import chess.model.pieces.Roi;
import chess.model.pieces.Tour;

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
	private List<Piece> piecesMorte = new ArrayList<Piece>();

	private List<Case> listeCase = new ArrayList<Case>();

	/**
	 * private HashMap<Case, Piece> piecesNoir; private HashMap<Case, Piece>
	 * piecesBlanc;
	 **/

	private Plateau() {
		super();
		// Construction de la liste de pièce noir
		piecesNoir.add(new Tour("Tour1", false));
		piecesNoir.add(new Cavalier("Cavalier1", false));
		piecesNoir.add(new Fou("Fou1", false));
		piecesNoir.add(new Reine("Reine", false));
		piecesNoir.add(new Roi("Roi", false));
		piecesNoir.add(new Fou("Fou2", false));
		piecesNoir.add(new Cavalier("Cavalier2", false));
		piecesNoir.add(new Tour("Tour2", false));
		piecesNoir.add(new Pion("Pion1", false));
		piecesNoir.add(new Pion("Pion2", false));
		piecesNoir.add(new Pion("Pion3", false));
		piecesNoir.add(new Pion("Pion4", false));
		piecesNoir.add(new Pion("Pion5", false));
		piecesNoir.add(new Pion("Pion6", false));
		piecesNoir.add(new Pion("Pion7", false));
		piecesNoir.add(new Pion("Pion8", false));
		// Construction de la liste de pièce blanche
		piecesBlanc.add(new Tour("Tour1", true));
		piecesBlanc.add(new Cavalier("Cavalier1", true));
		piecesBlanc.add(new Fou("Fou1", true));
		piecesBlanc.add(new Reine("Reine", true));
		piecesBlanc.add(new Roi("Roi", true));
		piecesBlanc.add(new Fou("Fou2", true));
		piecesBlanc.add(new Cavalier("Cavalier2", true));
		piecesBlanc.add(new Tour("Tour2", true));
		piecesBlanc.add(new Pion("Pion1", true));
		piecesBlanc.add(new Pion("Pion2", true));
		piecesBlanc.add(new Pion("Pion3", true));
		piecesBlanc.add(new Pion("Pion4", true));
		piecesBlanc.add(new Pion("Pion5", true));
		piecesBlanc.add(new Pion("Pion6", true));
		piecesBlanc.add(new Pion("Pion7", true));
		piecesBlanc.add(new Pion("Pion8", true));
		// Construction de la liste des case avec les pièces attribuer
		for (int i = 0; i < 16; i++) {
			Piece pieceSurLaCase = piecesNoir.get(i);
			listeCase.add(new Case(pieceSurLaCase));
		}
		for (int i = 0; i < 32; i++) {
			listeCase.add(new Case(null));
		}
		for (int i = 15; i >= 0; i--) {
			Piece pieceSurLaCase = piecesBlanc.get(i);
			listeCase.add(new Case(pieceSurLaCase));
		}
	}

	/**
	 * !!! Finir d'implementer le constructeur !!!
	 *
	 * @return Plateau ï¿½ l'ï¿½tat initial
	 */
	public static Plateau initialiserPlateau() {

		return new Plateau();

	}

	public List<Case> getListeCase() {
		return listeCase;
	}

	/**
	 * !!! a implementer !!!
	 *
	 * @param piece
	 * @param position actuelle de la piï¿½ce
	 * @return
	 */
	public List<Deplacement> donnerDeplacement(Piece piece, Case position) {
		List<Deplacement> deplacementsPossible = new ArrayList<Deplacement>();
		// listeCase
		return piece.deplacer(this, position);

	}

	/**
	 * Supprime une pièce de sa liste et l'ajoute à la liste des pièces supprimer.
	 * 
	 * @param pieceSupprimer
	 */
	public void supprimerPiece(Piece pieceSupprimer) {
		if (pieceSupprimer.isBlanc()) {
			piecesMorte.add(pieceSupprimer);
			piecesBlanc.remove(pieceSupprimer);
		} else {
			piecesMorte.add(pieceSupprimer);
			piecesNoir.remove(pieceSupprimer);
		}
	}
}
