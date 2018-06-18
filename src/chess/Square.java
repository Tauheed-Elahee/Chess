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
public class Square {
    
    private final Coordinate coordinate;
    private Piece piece;
    
    public Square(Coordinate c) {
        this.coordinate = c;
        this.piece = null;
    }
    
    public Square(Coordinate c, Piece p) {
        this.coordinate = c;
        this.piece = p;
    }
    
    public char getColumn() {
        return coordinate.getColumn();
    }
    
    public char getRow() {
        return coordinate.getRow();
    }
    
    public int getColumnNumber() {
        return coordinate.getColumnNumber();
    }
    
    public int getRowNumber() {
        return coordinate.getRowNumber();
    }
    
    public Coordinate getCoordinate() {
        return this.coordinate;
    }
    
    public Piece getPiece() {
        return this.piece;
    }
    
    public Piece addPiece(Piece newPiece) {
        Piece previousPiece = this.piece;
        this.piece = newPiece;
        return previousPiece;
    }
    
    public Piece deletePiece() {
        Piece removePiece = this.piece;
        this.piece = null;
        return removePiece;
    }
    
    public boolean isOccupied() {
        return piece != null;
    }
    
    @Override
    public String toString() {
        if (piece == null) {
            return "Square" + this.coordinate + ": ";
        }
        else {
            return "Square" + this.coordinate + ":" + this.piece;
        }
    }
}
