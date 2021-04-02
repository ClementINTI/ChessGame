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
		// Construction de la liste de pi�ce noir
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
		// Construction de la liste de pi�ce blanche
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
		// Construction de la liste des case avec les pi�ces attribuer
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
	 * @return Plateau � l'�tat initial
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
	 * @param position actuelle de la pi�ce
	 * @return
	 */
	public List<Deplacement> donnerDeplacement(Case position) {
		Piece pieceAdeplacer = position.getPiece();
		return pieceAdeplacer.deplacer(this, position);

	}

	/**
	 * Supprime une pi�ce de sa liste et l'ajoute � la liste des pi�ces
	 * supprimer.
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
