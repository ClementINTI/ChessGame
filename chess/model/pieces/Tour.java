package chess.model.pieces;

import chess.model.Deplacement;
import chess.model.Plateau;

import java.net.URL;

public class Tour extends Piece{

    public Tour(String nom, boolean blanc) {
        super(nom, blanc);
    }

    @Override
    public String getNom() {
        return "Tour";
    }

    @Override
    public URL getImage() {
        return null;
    }

    @Override
    public Deplacement deplacer(Plateau plateau) {
        return null;
    }
}
