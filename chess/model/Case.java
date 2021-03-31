package chess.model;

public class Case {
	private boolean estOccuper;

	public Case(boolean estOccuper) {
		super();
		this.estOccuper = estOccuper;
	}

	public boolean isEstOccuper() {
		return estOccuper;
	}

	public void setEstOccuper(boolean estOccuper) {
		this.estOccuper = estOccuper;
	}

}
