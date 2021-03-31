package chess.model.pieces;

import java.net.URL;

public class Roi extends Piece{



    public Roi(String nom, boolean blanc) {
        super(nom, blanc);
    }

    @Override
    public String getNom() {
        return "Roi";
    }

    @Override
    public URL getImage() {
        return null;
    }

}
