package chess.model;

import java.util.ArrayList;
import java.util.List;

import chess.model.pieces.Piece;

public class Partie {

	private Plateau plateau;
	private List<Deplacement> deplacements = new ArrayList<Deplacement>();
	private boolean tourDesBlanc;

	/**
	 * Instancie une partie a l'état initial tour des blanc = true deplacements vide
	 * plateau a implementer
	 */
	private Partie() {
		super();
		this.tourDesBlanc = true;
		plateau = Plateau.initialiserPlateau();
	}

	/**
	 * Retourne une Partie à l'état initial !!!!Finir d'implementer le constructeur
	 * !!!!
	 * 
	 * @return
	 */
	public static Partie demmarrerPartie() {
		return new Partie();
	}

	public boolean isTourDesBlanc() {
		return tourDesBlanc;
	}

	public void setTourDesBlanc(boolean tourDesBlanc) {
		this.tourDesBlanc = tourDesBlanc;
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public List<Deplacement> getDeplacements() {
		return deplacements;
	}

	/**
	 * effectue le déplacement d'une pièce d'une case a une autre est passe le tour
	 * a l'équipe suivante. Si la nouvelle case est occupé par une pièce, celle-ci
	 * est supprimer.
	 */
	public void newDeplacement(Deplacement deplacementEffectuer) {
		Piece pieceDeplacer = deplacementEffectuer.getAncienneCase().getPiece();
		if (deplacementEffectuer.getNouvelleCase().getPiece() == null) {
			deplacementEffectuer.getNouvelleCase().setPiece(pieceDeplacer);
		} else {
			Piece pieceSupprimer = deplacementEffectuer.getNouvelleCase().getPiece();
			deplacementEffectuer.getNouvelleCase().setPiece(pieceDeplacer);
			plateau.supprimerPiece(pieceSupprimer);
		}
		deplacements.add(deplacementEffectuer);
		deplacementEffectuer.getAncienneCase().setPiece(null);
		tourDesBlanc = !tourDesBlanc;
	}

	/**
	 * a implementer
	 */
	public void annulerDeplacement() {
		int indexDernierElement = deplacements.size() - 1;
		Deplacement deplacementaAnnuler = deplacements.remove(indexDernierElement);
		Piece pieceDeplacer = deplacementaAnnuler.getNouvelleCase().getPiece();
		deplacementaAnnuler.getNouvelleCase().setPiece(null);
		deplacementaAnnuler.getAncienneCase().setPiece(pieceDeplacer);
		tourDesBlanc = !tourDesBlanc;
	}
}
