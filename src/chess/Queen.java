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
public class Queen extends Piece {
    
    public Queen (ChessColour colour) {
        super(colour, ChessPieces.QUEEN);
    }
    
    @Override
    public boolean isLeagalMove(ChessBoard cb, Coordinate src, Coordinate dest) {
        super.isLeagalMove(cb, src, dest);
        
        ArrayList<Coordinate> listOfLeagalMoves = new ArrayList<>();
        
        int sourceColumn = src.getColumnNumber();
        int sourceRow = src.getRowNumber();
        
        int stepper = 1;
        Boolean encounteredAPiece = false;
        while ((sourceColumn+stepper >= 0) && (sourceColumn+stepper <= 7) && (sourceRow >= 0) && (sourceRow <= 7)){
            Coordinate currentCoordinate = new Coordinate(sourceColumn+stepper, sourceRow);
            if (!cb.getSquare(currentCoordinate).isOccupied() && !encounteredAPiece) {
                listOfLeagalMoves.add(currentCoordinate);
            }
            if (cb.getSquare(currentCoordinate).isOccupied() && !encounteredAPiece) {
                if (cb.getSquare(currentCoordinate).getPiece().getColour() != this.getColour()) {
                    listOfLeagalMoves.add(currentCoordinate);
                }
                encounteredAPiece=true;
            }
            stepper++;
        }
        stepper = 1;
        encounteredAPiece = false;
        while ((sourceColumn-stepper >= 0) && (sourceColumn-stepper <= 7) && (sourceRow >= 0) && (sourceRow <= 7)){
            Coordinate currentCoordinate = new Coordinate(sourceColumn-stepper, sourceRow);
            if (!cb.getSquare(currentCoordinate).isOccupied() && !encounteredAPiece) {
                listOfLeagalMoves.add(currentCoordinate);
            }
            if (cb.getSquare(currentCoordinate).isOccupied() && !encounteredAPiece) {
                if (cb.getSquare(currentCoordinate).getPiece().getColour() != this.getColour()) {
                    listOfLeagalMoves.add(currentCoordinate);
                }
                encounteredAPiece=true;
            }
            stepper++;
        }
        stepper = 1;
        encounteredAPiece = false;
        while ((sourceColumn >= 0) && (sourceColumn <= 7) && (sourceRow+stepper >= 0) && (sourceRow+stepper <= 7)){
            Coordinate currentCoordinate = new Coordinate(sourceColumn, sourceRow+stepper);
            if (!cb.getSquare(currentCoordinate).isOccupied() && !encounteredAPiece) {
                listOfLeagalMoves.add(currentCoordinate);
            }
            if (cb.getSquare(currentCoordinate).isOccupied() && !encounteredAPiece) {
                if (cb.getSquare(currentCoordinate).getPiece().getColour() != this.getColour()) {
                    listOfLeagalMoves.add(currentCoordinate);
                }
                encounteredAPiece=true;
            }
            stepper++;
        }
        stepper = 1;
        encounteredAPiece = false;
        while ((sourceColumn >= 0) && (sourceColumn <= 7) && (sourceRow-stepper >= 0) && (sourceRow-stepper <= 7)){
            Coordinate currentCoordinate = new Coordinate(sourceColumn, sourceRow-stepper);
            if (!cb.getSquare(currentCoordinate).isOccupied() && !encounteredAPiece) {
                listOfLeagalMoves.add(currentCoordinate);
            }
            if (cb.getSquare(currentCoordinate).isOccupied() && !encounteredAPiece) {
                if (cb.getSquare(currentCoordinate).getPiece().getColour() != this.getColour()) {
                    listOfLeagalMoves.add(currentCoordinate);
                }
                encounteredAPiece=true;
            }
            stepper++;
        }
        stepper = 1;
        encounteredAPiece = false;
        while ((sourceColumn+stepper >= 0) && (sourceColumn+stepper <= 7) && (sourceRow+stepper >= 0) && (sourceRow+stepper <= 7)){
            Coordinate currentCoordinate = new Coordinate(sourceColumn+stepper, sourceRow+stepper);
            if (!cb.getSquare(currentCoordinate).isOccupied() && !encounteredAPiece) {
                listOfLeagalMoves.add(currentCoordinate);
            }
            if (cb.getSquare(currentCoordinate).isOccupied() && !encounteredAPiece) {
                if (cb.getSquare(currentCoordinate).getPiece().getColour() != this.getColour()) {
                    listOfLeagalMoves.add(currentCoordinate);
                }
                encounteredAPiece=true;
            }
            stepper++;
        }
        stepper = 1;
        encounteredAPiece = false;
        while ((sourceColumn+stepper >= 0) && (sourceColumn+stepper <= 7) && (sourceRow-stepper >= 0) && (sourceRow-stepper <= 7)){
            Coordinate currentCoordinate = new Coordinate(sourceColumn+stepper, sourceRow-stepper);
            if (!cb.getSquare(currentCoordinate).isOccupied() && !encounteredAPiece) {
                listOfLeagalMoves.add(currentCoordinate);
            }
            if (cb.getSquare(currentCoordinate).isOccupied() && !encounteredAPiece) {
                if (cb.getSquare(currentCoordinate).getPiece().getColour() != this.getColour()) {
                    listOfLeagalMoves.add(currentCoordinate);
                }
                encounteredAPiece=true;
            }
            stepper++;
        }
        stepper = 1;
        encounteredAPiece = false;
        while ((sourceColumn-stepper >= 0) && (sourceColumn-stepper <= 7) && (sourceRow+stepper >= 0) && (sourceRow+stepper <= 7)){
            Coordinate currentCoordinate = new Coordinate(sourceColumn-stepper, sourceRow+stepper);
            if (!cb.getSquare(currentCoordinate).isOccupied() && !encounteredAPiece) {
                listOfLeagalMoves.add(currentCoordinate);
            }
            if (cb.getSquare(currentCoordinate).isOccupied() && !encounteredAPiece) {
                if (cb.getSquare(currentCoordinate).getPiece().getColour() != this.getColour()) {
                    listOfLeagalMoves.add(currentCoordinate);
                }
                encounteredAPiece=true;
            }
            stepper++;
        }
        stepper = 1;
        encounteredAPiece = false;
        while ((sourceColumn-stepper >= 0) && (sourceColumn-stepper <= 7) && (sourceRow-stepper >= 0) && (sourceRow-stepper <= 7)){
            Coordinate currentCoordinate = new Coordinate(sourceColumn-stepper, sourceRow-stepper);
            if (!cb.getSquare(currentCoordinate).isOccupied() && !encounteredAPiece) {
                listOfLeagalMoves.add(currentCoordinate);
            }
            if (cb.getSquare(currentCoordinate).isOccupied() && !encounteredAPiece) {
                if (cb.getSquare(currentCoordinate).getPiece().getColour() != this.getColour()) {
                    listOfLeagalMoves.add(currentCoordinate);
                }
                encounteredAPiece=true;
            }
            stepper++;
        }
        
        for (int counter = 0; counter < listOfLeagalMoves.size(); counter++){
            if (dest.getColumnNumber() == listOfLeagalMoves.get(counter).getColumnNumber()) {
                if (dest.getRowNumber() == listOfLeagalMoves.get(counter).getRowNumber()) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
