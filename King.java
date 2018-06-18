/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package chess;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class King extends Piece {
    
    public King (ChessColour colour) {
        super(colour, ChessPieces.KING);
    }
    
    @Override
    public boolean isLeagalMove(ChessBoard cb, Coordinate src, Coordinate dest) {
        super.isLeagalMove(cb, src, dest);
        
        ArrayList<Coordinate> lm = new ArrayList<>();
        
        int sc = src.getColumnNumber();
        int sr = src.getRowNumber();
        
        if ((sc+1 >= 0) && (sc+1 <= 7) && (sr+1 >= 0) && (sr+1 <= 7)){
            if (!cb.getSquare(new Coordinate(sc+1, sr+1)).isOccupied() || cb.getSquare(new Coordinate(sc+1, sr+1)).getPiece().getColour() != this.getColour()) {
                lm.add(new Coordinate(sc+1, sr+1));
            }
        }
        if ((sc+1 >= 0) && (sc+1 <= 7) && (sr >= 0) && (sr <= 7)){
            if (!cb.getSquare(new Coordinate(sc+1, sr)).isOccupied() || cb.getSquare(new Coordinate(sc+1, sr)).getPiece().getColour() != this.getColour()) {
                lm.add(new Coordinate(sc+1, sr));
            }
        }
        if ((sc+1 >= 0) && (sc+1 <= 7) && (sr-1 >= 0) && (sr-1 <= 7)){
            if (!cb.getSquare(new Coordinate(sc+1, sr-1)).isOccupied() || cb.getSquare(new Coordinate(sc+1, sr-1)).getPiece().getColour() != this.getColour()) {
                lm.add(new Coordinate(sc+1, sr-1));
            }
        }
        if ((sc >= 0) && (sc <= 7) && (sr+1 >= 0) && (sr+1 <= 7)){
            if (!cb.getSquare(new Coordinate(sc, sr+1)).isOccupied() || cb.getSquare(new Coordinate(sc, sr+1)).getPiece().getColour() != this.getColour()) {
                lm.add(new Coordinate(sc, sr+1));
            }
        }
        if ((sc >= 0) && (sc <= 7) && (sr-1 >= 0) && (sr-1 <= 7)){
            if (!cb.getSquare(new Coordinate(sc, sr-1)).isOccupied() || cb.getSquare(new Coordinate(sc, sr-1)).getPiece().getColour() != this.getColour()) {
                lm.add(new Coordinate(sc, sr-1));
            }
        }
        if ((sc-1 >= 0) && (sc-1 <= 7) && (sr+1 >= 0) && (sr+1 <= 7)){
            if (!cb.getSquare(new Coordinate(sc-1, sr+1)).isOccupied() || cb.getSquare(new Coordinate(sc-1, sr+1)).getPiece().getColour() != this.getColour()) {
                lm.add(new Coordinate(sc-1, sr+1));
            }
        }
        if ((sc-1 >= 0) && (sc-1 <= 7) && (sr >= 0) && (sr <= 7)){
            if (!cb.getSquare(new Coordinate(sc-1, sr)).isOccupied() || cb.getSquare(new Coordinate(sc-1, sr)).getPiece().getColour() != this.getColour()) {
                lm.add(new Coordinate(sc-1, sr));
            }
        }
        if ((sc-1 >= 0) && (sc-1 <= 7) && (sr-1 >= 0) && (sr-1 <= 7)){
            if (!cb.getSquare(new Coordinate(sc-1, sr-1)).isOccupied() || cb.getSquare(new Coordinate(sc-1, sr-1)).getPiece().getColour() != this.getColour()) {
                lm.add(new Coordinate(sc-1, sr-1));
            }
        }
        
        for (int m = 0; m < lm.size(); m++){
            if (dest.getColumnNumber() == lm.get(m).getColumnNumber()) {
                if (dest.getRowNumber() == lm.get(m).getRowNumber()) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
