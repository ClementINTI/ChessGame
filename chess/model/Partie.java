package chess.model;

import java.util.ArrayList;
import java.util.List;

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
		plateau = plateau.initialiserPlateau();
	}

	/**
	 * Retourne une Partie à l'état initial !!!!Finir d'implementer le constructeur
	 * !!!!
	 * 
	 * @return
	 */
	public Partie demmarrerPartie() {
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
	 * a implementer
	 */
	public void newDeplacement() {

	}

	/**
	 * a implementer
	 */
	public void annulerDeplacement() {

	}
}
