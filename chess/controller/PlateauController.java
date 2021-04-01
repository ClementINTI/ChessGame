package chess.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import chess.model.Case;
import chess.model.Deplacement;
import chess.model.Partie;
import chess.model.Plateau;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
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
	// faire la classe
	private Partie partie;

	private List<AnchorPane> listeCasesFXML = new ArrayList<AnchorPane>();
	/**
	 * Liste des emplacements possible l'index 0 contient l'emplacement initial de
	 * la pièce
	 */
	private List<AnchorPane> listeDeplacementPossible = new ArrayList<AnchorPane>();
	private boolean pieceSelectionner;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

		partie = Partie.demmarrerPartie();
		pieceSelectionner = false;
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
		updateVue();
		Plateau plateau = partie.getPlateau();
		List<Case> listeCase = plateau.getListeCase();
		// Les boutons voir pour les mÃ©thodes une fois les classes faits.
		buttonNewGame.setOnMouseClicked(event -> {
			partie = Partie.demmarrerPartie();
			updateVue();
		});
		buttonQuit.setOnMouseClicked(event -> System.exit(0));
		buttonUndo.setOnMouseClicked(event -> annuler());
		// listeCasesFXML.addAll(Collections.addAll(c, elements));

		for (int i = 0; i < 64; i++) {
			listeCasesFXML.get(i).setOnMouseClicked(event -> cliquerCase(event));
		}
	}

	private void cliquerCase(MouseEvent event) {
		AnchorPane caseSelectionner = (AnchorPane) event.getTarget();
		Plateau plateau = partie.getPlateau();
		int indexCase = listeCasesFXML.indexOf(caseSelectionner);
		Case position = plateau.getListeCase().get(indexCase);

		if (!pieceSelectionner) {
			afficherDeplacementPossible(plateau, position, indexCase);
		} else {/*
				 * Deplacement deplacementEffectuer=new
				 * Deplacement(listeDeplacementPossible.get(0),
				 * plateau.getListeCase().get(indexCase))
				 * partie.newDeplacement(deplacementEffectuer);
				 */
		}
	}

	private void afficherDeplacementPossible(Plateau plateau, Case position, int indexCaseSelectionner) {
		List<Deplacement> deplacementPossible = plateau.donnerDeplacement(position);
		listeDeplacementPossible.clear();
		listeDeplacementPossible.add(listeCasesFXML.get(indexCaseSelectionner));
		for (Deplacement deplacement : deplacementPossible) {
			int indexNouvelleCase = plateau.getListeCase().indexOf(deplacement.getNouvelleCase());
			AnchorPane casePossible = listeCasesFXML.get(indexNouvelleCase);
			casePossible.setStyle("-fx-background-color: red");
			listeDeplacementPossible.add(casePossible);
		}
		pieceSelectionner = true;
	}

	private void updateVue() {
		Plateau plateau = partie.getPlateau();
		List<Case> listeCase = plateau.getListeCase();

		/**
		 * BackgroundImage image = new BackgroundImage(new
		 * javafx.scene.image.Image("/src/chess/piecesImage/white_king.png",9,9,false,true),
		 * BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT
		 * );
		 **/
		for (int i = 0; i < 64; i++) {
			if (listeCase.get(i).getPiece() != null) {
				// listeCasesFXML.get(i).setStyle("-fx-background-color: red");
				listeCasesFXML.get(i).setStyle(
						"-fx-background-image: url('/chess/piecesImage/white_king.png');-fx-background-repeat: no-repeat;-fx-background-position: center;");
				// listeCasesFXML.get(i).setBackground(new Background(image));
				// "/src/chess/piecesImage/white_king.png"
				// new
				// Image(getClass().getResourceAsStream("/src/chess/piecesImage/white_king.png"));
				// ImageView imageView =

				// Sa c'est a clement
				/*
				 * } else if (i % 2 == 0) {
				 * listeCasesFXML.get(i).setStyle("-fx-background-color: white"); } else {
				 * listeCasesFXML.get(i).setStyle("-fx-background-color: black");
				 */
			}
		}

		// a faire
	}

	private void annuler() {

		// a faire
	}

}
