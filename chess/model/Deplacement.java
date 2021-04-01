package chess.model;

public class Deplacement {
	private Case ancienneCase;
	private Case nouvelleCase;

	public Deplacement(Case ancienneCase, Case nouvelleCase) {
		super();
		this.ancienneCase = ancienneCase;
		this.nouvelleCase = nouvelleCase;
	}

	public Case getAncienneCase() {
		return ancienneCase;
	}

	public Case getNouvelleCase() {
		return nouvelleCase;
	}

}
