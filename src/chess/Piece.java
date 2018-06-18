/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package chess;

/**
 *
 * @Tauheed Elahee 101040312
 */
public class Piece {
    
    private final ChessColour colour;
    private final ChessPieces name;
    private char shortName;
    private final String imageName;
    
    public Piece(ChessColour colour, ChessPieces name) {
        this.colour = colour;
        this.name = name;
        this.shortName = name.getShortName();
        imageName = "file:src/chess/chess.images/" + colour.toString().toLowerCase() + "_" + name.toString().toLowerCase() + ".png";
        if (colour == chess.ChessColour.BLACK) {
            this.shortName = Character.toLowerCase(this.shortName);
        }
    }
    
    public boolean isLeagalMove(ChessBoard cb, Coordinate src, Coordinate dest) {
        
        if (dest.equals(src)) {
            return false;
        }
        
        if ((cb.getSquare(dest).isOccupied()) && (cb.getSquare(dest).getPiece().getColour().equals(cb.getSquare(src).getPiece().getColour()))) {
            return false;
        }
        
        if (!cb.getSquare(src).isOccupied()) {
            return false;
        }
        
        if ((src.getColumnNumber()>7) || (src.getRowNumber()>7) || (dest.getColumnNumber()>7) || (dest.getRowNumber()>7)) {
            return false;
        }
        if ((src.getColumnNumber()<0) || (src.getRowNumber()<0) || (dest.getColumnNumber()<0) || (dest.getRowNumber()<0)) {
            return false;
        }
        
        return false;
    }
    
    public ChessColour getColour() {
        return colour;
    }
    
    public ChessPieces getName() {
        return name;
    }
    
    public char getShortName() {
        return shortName;
    }

    public String getImageString() {
	return imageName;
    }
    
    @Override
    public String toString() {
        return colour + " " + name;
    }
}
