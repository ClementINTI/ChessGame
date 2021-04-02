package chess.model.pieces;

import java.util.ArrayList;
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
		return "Cavalier";
	}

	@Override
	public String getImage() {
		if (isBlanc()) {
			return "/chess/piecesImage/white_knight.png";
		} else {
			return "/chess/piecesImage/black_knight.png";
		}
	}

	@Override
	public List<Deplacement> deplacer(Plateau plateau, Case emplacement) {
		List<Case> listeCase = plateau.getListeCase();
		List<Deplacement> deplacements = new ArrayList<>();
		int indexActuelle = listeCase.indexOf(emplacement);

		deplacementPossible(deplacements, indexActuelle + 6, emplacement, listeCase);
		deplacementPossible(deplacements, indexActuelle + 15, emplacement, listeCase);
		deplacementPossible(deplacements, indexActuelle + 10, emplacement, listeCase);
		deplacementPossible(deplacements, indexActuelle + 17, emplacement, listeCase);
		deplacementPossible(deplacements, indexActuelle - 6, emplacement, listeCase);
		deplacementPossible(deplacements, indexActuelle - 15, emplacement, listeCase);
		deplacementPossible(deplacements, indexActuelle - 10, emplacement, listeCase);
		deplacementPossible(deplacements, indexActuelle - 17, emplacement, listeCase);

		/**
		 * for (int i = 0; i < 64; i++) { Case emplacementPossible=listeCase.get(i); if
		 * (emplacementPossible.getPiece() != null){ if (emplacement !=
		 * emplacementPossible) { if (emplacementPossible.getPiece().isBlanc() !=
		 * emplacement.getPiece().isBlanc()) { deplacements.add(new
		 * Deplacement(emplacement, emplacementPossible)); } } else {
		 * deplacements.add(new Deplacement(emplacement, emplacementPossible)); } } }
		 */
		return deplacements;
	}

	private void deplacementPossible(List<Deplacement> deplacements, int indexPossible, Case emplacement,
			List<Case> listeCase) {
		if (indexPossible < 64) {
			Case casePossible = listeCase.get(indexPossible);
			if (casePossible.getPiece().isBlanc() != isBlanc()) {
				deplacements.add(new Deplacement(emplacement, listeCase.get(indexPossible)));
			}
		}
	}
}
