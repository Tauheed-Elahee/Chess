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
public class Knight extends Piece {
    
    public Knight (ChessColour colour) {
        super(colour, ChessPieces.KNIGHT);
    }
    
    @Override
    public boolean isLeagalMove(ChessBoard cb, Coordinate src, Coordinate dest) {
        super.isLeagalMove(cb, src, dest);
        
        ArrayList<Coordinate> lm = new ArrayList<>();
        
        int sc = src.getColumnNumber();
        int sr = src.getRowNumber();
        
        if ((sc+2 >= 0) && (sc+2 <= 7) && (sr+1 >= 0) && (sr+1 <= 7)){
            if (!cb.getSquare(new Coordinate(sc+2, sr+1)).isOccupied() || (cb.getSquare(new Coordinate(sc+2, sr+1)).getPiece().getColour() != this.getColour())) {
                lm.add(new Coordinate(sc+2, sr+1));
            }
        }
        if ((sc+2 >= 0) && (sc+2 <= 7) && (sr-1 >= 0) && (sr-1 <= 7)){
            if (!cb.getSquare(new Coordinate(sc+2, sr-1)).isOccupied() || (cb.getSquare(new Coordinate(sc+2, sr-1)).getPiece().getColour() != this.getColour())) {
                lm.add(new Coordinate(sc+2, sr-1));
            }
        }
        if ((sc+1 >= 0) && (sc+1 <= 7) && (sr+2 >= 0) && (sr+2 <= 7)){
            if (!cb.getSquare(new Coordinate(sc+1, sr+2)).isOccupied() || (cb.getSquare(new Coordinate(sc+1, sr+2)).getPiece().getColour() != this.getColour())) {
                lm.add(new Coordinate(sc+1, sr+2));
            }
        }
        if ((sc+1 >= 0) && (sc+1 <= 7) && (sr-2 >= 0) && (sr-2 <= 7)){
            if (!cb.getSquare(new Coordinate(sc+1, sr-2)).isOccupied() || (cb.getSquare(new Coordinate(sc+1, sr-2)).getPiece().getColour() != this.getColour())) {
                lm.add(new Coordinate(sc+1, sr-2));
            }
        }
        if ((sc-1 >= 0) && (sc-1 <= 7) && (sr+2 >= 0) && (sr+2 <= 7)){
            if (!cb.getSquare(new Coordinate(sc-1, sr+2)).isOccupied() || (cb.getSquare(new Coordinate(sc-1, sr+2)).getPiece().getColour() != this.getColour())) {
                lm.add(new Coordinate(sc-1, sr+2));
            }
        }
        if ((sc-1 >= 0) && (sc-1 <= 7) && (sr-2 >= 0) && (sr-2 <= 7)){
            if (!cb.getSquare(new Coordinate(sc-1, sr-2)).isOccupied() || (cb.getSquare(new Coordinate(sc-1, sr-2)).getPiece().getColour() != this.getColour())) {
                lm.add(new Coordinate(sc-1, sr-2));
            }
        }
        if ((sc-2 >= 0) && (sc-2 <= 7) && (sr+1 >= 0) && (sr+1 <= 7)){
            if (!cb.getSquare(new Coordinate(sc-2, sr+1)).isOccupied() || (cb.getSquare(new Coordinate(sc-2, sr+1)).getPiece().getColour() != this.getColour())) {
                lm.add(new Coordinate(sc-2, sr+1));
            }
        }
        if ((sc-2 >= 0) && (sc-2 <= 7) && (sr-1 >= 0) && (sr-1 <= 7)){
            if (!cb.getSquare(new Coordinate(sc-2, sr-1)).isOccupied() || (cb.getSquare(new Coordinate(sc-2, sr-1)).getPiece().getColour() != this.getColour())) {
                lm.add(new Coordinate(sc-2, sr-1));
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
