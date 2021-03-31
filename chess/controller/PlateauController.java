package chess.controller;

import chess.model.Partie;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

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

    // faire la classe
    private Partie partie;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        partie = new Partie();


        // Les boutons  voir pour les méthodes une fois les classes faits.
        buttonNewGame.setOnMouseClicked(event -> debutNouvellePartie());
        buttonQuit.setOnMouseClicked(event -> System.exit(0));
        buttonUndo.setOnMouseClicked(event -> annuler() );


    }

    private void debutNouvellePartie() {
        partie = new Partie();

        //a faire
    }


    private void annuler() {

        //a faire
    }

}
