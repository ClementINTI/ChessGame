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
import chess.model.pieces.Piece;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

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
	 * Liste des emplacements possible
	 */
	private List<AnchorPane> listeDeplacementPossible = new ArrayList<AnchorPane>();
	private boolean pieceSelectionner;
	private Case ancienPlacement;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
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
		demarrerPartie();
		buttonNewGame.setOnMouseClicked(event -> demarrerPartie());
		buttonQuit.setOnMouseClicked(event -> System.exit(0));
		buttonUndo.setOnMouseClicked(event -> annuler());
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
			if (position.getPiece().isBlanc() == partie.isTourDesBlanc()) {
				caseSelectionner.setBorder(creerBordure(Color.BLUE));
				afficherDeplacementPossible(plateau, position);
			}
		} else if (pieceSelectionner) {
			if (listeDeplacementPossible.contains(caseSelectionner)) {
				effectuerDeplacement(position);
			} else if (caseSelectionner == listeCasesFXML.get(plateau.getListeCase().indexOf(ancienPlacement))) {
				pieceSelectionner = false;
				updateVue();
			}
		}
	}

	private void effectuerDeplacement(Case position) {
		Deplacement deplacementEffectuer = new Deplacement(ancienPlacement, position);
		partie.newDeplacement(deplacementEffectuer);
		pieceSelectionner = false;
		ancienPlacement = null;
		updateVue();
	}

	private void afficherDeplacementPossible(Plateau plateau, Case position) {
		ancienPlacement = position;
		List<Integer> deplacementPossible = plateau.donnerDeplacement(position);
		listeDeplacementPossible.clear();
		for (int deplacement : deplacementPossible) {
			AnchorPane casePossible = listeCasesFXML.get(deplacement);
			casePossible.setBorder(creerBordure(Color.RED));
			listeDeplacementPossible.add(casePossible);
		}
		pieceSelectionner = true;
	}

	private void updateVue() {
		Plateau plateau = partie.getPlateau();
		List<Case> listeCase = plateau.getListeCase();

		for (int i = 0; i < 64; i++) {
			Piece piece = listeCase.get(i).getPiece();
			if (piece != null) {
				attribuerBordure(i);
				listeCasesFXML.get(i).setStyle("-fx-background-image: url('" + piece.getImage()
						+ "');-fx-background-repeat: no-repeat;-fx-background-position: center;");
			} else {
				attribuerBordure(i);
			}
		}
	}

	private void attribuerBordure(int i) {
		if ((i % 2 == 0 && (i / 8) % 2 == 0) || (i % 2 != 0 && (i / 8) % 2 != 0)) {
			listeCasesFXML.get(i).setStyle("-fx-background-color: white");
			listeCasesFXML.get(i).setBorder(creerBordure(Color.WHITE));

		} else {
			listeCasesFXML.get(i).setStyle("-fx-background-color: black");
			listeCasesFXML.get(i).setBorder(creerBordure(Color.BLACK));
		}
	}

	private Border creerBordure(Color couleur) {
		return new Border(new BorderStroke(couleur, BorderStrokeStyle.SOLID, null, new BorderWidths(5)));
	}

	private void demarrerPartie() {
		partie = Partie.demmarrerPartie();
		pieceSelectionner = false;
		ancienPlacement = null;
		updateVue();
	}

	private void annuler() {
		partie.annulerDeplacement();
		pieceSelectionner = false;
		ancienPlacement = null;
		updateVue();
	}
}
