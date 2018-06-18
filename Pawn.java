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
public class Pawn extends Piece {
    
    private boolean firstMove;
    
    public Pawn (ChessColour colour) {
        super(colour, ChessPieces.PAWN);
        firstMove = true;
    }
    
    @Override
    public boolean isLeagalMove(ChessBoard cb, Coordinate src, Coordinate dest) {
        super.isLeagalMove(cb, src, dest);
        
        ArrayList<Coordinate> lm = new ArrayList<>();
        
        int sc = src.getColumnNumber();
        int sr = src.getRowNumber();
        
        if (this.getColour() == chess.ChessColour.WHITE) {
            if ((sc >= 0) && (sc <= 7) && (sr+2 >= 0) && (sr+2 <= 7) && firstMove){
                if (!cb.getSquare(new Coordinate(sc, sr+2)).isOccupied()) {
                    lm.add(new Coordinate(sc, sr+2));
                    firstMove = false;
                }
            }
            if ((sc >= 0) && (sc <= 7) && (sr+1 >= 0) && (sr+1 <= 7)){
                if (!cb.getSquare(new Coordinate(sc, sr+1)).isOccupied()) {
                    lm.add(new Coordinate(sc, sr+1));
                }
            }
            if ((sc+1 >= 0) && (sc+1 <= 7) && (sr+1 >= 0) && (sr+1 <= 7) && (cb.getSquare(new Coordinate(sc+1, sr+1)).getPiece() != null)){
                if (cb.getSquare(new Coordinate(sc+1, sr+1)).getPiece().getColour() == chess.ChessColour.BLACK) {
                    lm.add(new Coordinate(sc+1, sr+1));
                }
            }
            if ((sc-1 >= 0) && (sc-1 <= 7) && (sr+1 >= 0) && (sr+1 <= 7) && (cb.getSquare(new Coordinate(sc-1, sr+1)).getPiece() != null)){
                if (cb.getSquare(new Coordinate(sc-1, sr+1)).getPiece().getColour() == chess.ChessColour.BLACK) {
                    lm.add(new Coordinate(sc-1, sr+1));
                }
            }
        }
        if (this.getColour() == chess.ChessColour.BLACK) {
            if ((sc >= 0) && (sc <= 7) && (sr-2 >= 0) && (sr-2 <= 7) && firstMove){
                if (!cb.getSquare(new Coordinate(sc, sr-2)).isOccupied()) {
                    lm.add(new Coordinate(sc, sr-2));
                    firstMove = false;
                }
            }
            if ((sc >= 0) && (sc <= 7) && (sr-1 >= 0) && (sr-1 <= 7)){
                if (!cb.getSquare(new Coordinate(sc, sr-1)).isOccupied()) {
                    lm.add(new Coordinate(sc, sr-1));
                }
            }
            if ((sc+1 >= 0) && (sc+1 <= 7) && (sr-1 >= 0) && (sr+-1 <= 7) && (cb.getSquare(new Coordinate(sc+1, sr-1)).getPiece() != null)){
                if (cb.getSquare(new Coordinate(sc+1, sr-1)).getPiece().getColour() == chess.ChessColour.WHITE) {
                    lm.add(new Coordinate(sc+1, sr-1));
                }
            }
            if ((sc-1 >= 0) && (sc-1 <= 7) && (sr-1 >= 0) && (sr-1 <= 7) && (cb.getSquare(new Coordinate(sc-1, sr-1)).getPiece() != null)){
                if (cb.getSquare(new Coordinate(sc-1, sr-1)).getPiece().getColour() == chess.ChessColour.WHITE) {
                    lm.add(new Coordinate(sc-1, sr-1));
                }
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
