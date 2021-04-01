package chess.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import chess.model.Partie;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class PlateauController implements Initializable {

	@FXML
	private Button buttonNewGame;

	@FXML
	private Button buttonQuit;

	@FXML
	private Button buttonUndo;

	@FXML
	private Label labelPlayerTurn;

	@FXML
	private GridPane gridPaneChessBoard;
	@FXML
	private AnchorPane colonne0ligne0, colonne1ligne0, colonne2ligne0, colonne3ligne0, colonne4ligne0, colonne5ligne0,
			colonne6ligne0, colonne7ligne0;
	@FXML
	private AnchorPane colonne0ligne1, colonne1ligne1, colonne2ligne1, colonne3ligne1, colonne4ligne1, colonne5ligne1,
			colonne6ligne1, colonne7ligne1;
	@FXML
	private AnchorPane colonne0ligne2, colonne1ligne2, colonne2ligne2, colonne3ligne2, colonne4ligne2, colonne5ligne2,
			colonne6ligne2, colonne7ligne2;
	@FXML
	private AnchorPane colonne0ligne3, colonne1ligne3, colonne2ligne3, colonne3ligne3, colonne4ligne3, colonne5ligne3,
			colonne6ligne3, colonne7ligne3;
	@FXML
	private AnchorPane colonne0ligne4, colonne1ligne4, colonne2ligne4, colonne3ligne4, colonne4ligne4, colonne5ligne4,
			colonne6ligne4, colonne7ligne4;
	@FXML
	private AnchorPane colonne0ligne5, colonne1ligne5, colonne2ligne5, colonne3ligne5, colonne4ligne5, colonne5ligne5,
			colonne6ligne5, colonne7ligne5;
	@FXML
	private AnchorPane colonne0ligne6, colonne1ligne6, colonne2ligne6, colonne3ligne6, colonne4ligne6, colonne5ligne6,
			colonne6ligne6, colonne7ligne6;
	@FXML
	private AnchorPane colonne0ligne7, colonne1ligne7, colonne2ligne7, colonne3ligne7, colonne4ligne7, colonne5ligne7,
			colonne6ligne7, colonne7ligne7;

	private List<AnchorPane> listeCasesFXML = new ArrayList<AnchorPane>();
	// faire la classe
	private Partie partie;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

		partie = Partie.demmarrerPartie();

		// Les boutons voir pour les méthodes une fois les classes faits.
		buttonNewGame.setOnMouseClicked(event -> debutNouvellePartie());
		buttonQuit.setOnMouseClicked(event -> System.exit(0));
		buttonUndo.setOnMouseClicked(event -> annuler());
		// listeCasesFXML.addAll(Collections.addAll(c, elements));
		listeCasesFXML.addAll(Arrays.asList(colonne0ligne0, colonne1ligne0, colonne2ligne0, colonne3ligne0,
				colonne4ligne0, colonne5ligne0, colonne6ligne0, colonne7ligne0, colonne0ligne1, colonne1ligne1,
				colonne2ligne1, colonne3ligne1, colonne4ligne1, colonne5ligne1, colonne6ligne1, colonne7ligne1,
				colonne0ligne2, colonne1ligne2, colonne2ligne2, colonne3ligne2, colonne4ligne2, colonne5ligne2,
				colonne6ligne2, colonne7ligne2, colonne0ligne3, colonne1ligne3, colonne2ligne3, colonne3ligne3,
				colonne4ligne3, colonne5ligne3, colonne6ligne3, colonne7ligne3, colonne0ligne4, colonne1ligne4,
				colonne2ligne4, colonne3ligne4, colonne4ligne4, colonne5ligne4, colonne6ligne4, colonne7ligne4,
				colonne0ligne5, colonne1ligne5, colonne2ligne5, colonne3ligne5, colonne4ligne5, colonne5ligne5,
				colonne6ligne5, colonne7ligne5, colonne0ligne6, colonne1ligne6, colonne2ligne6, colonne3ligne6,
				colonne4ligne6, colonne5ligne6, colonne6ligne6, colonne7ligne6, colonne0ligne7, colonne1ligne7,
				colonne2ligne7, colonne3ligne7, colonne4ligne7, colonne5ligne7, colonne6ligne7, colonne7ligne7));
		// colonne0ligne0.setOnMouseClicked();

	}

	private void debutNouvellePartie() {
		partie = Partie.demmarrerPartie();

		// a faire
	}

	private void annuler() {

		// a faire
	}

}
