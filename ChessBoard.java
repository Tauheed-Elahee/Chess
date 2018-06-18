/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package chess;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

/**
 *
 * @Tauheed Elahee 101040312
 */
public final class ChessBoard {
    
    private ChessColour activeColour;
    private int fullMove;
    private final Square[][] board;
    private final ArrayList<Piece> takenPieces;
    private final ArrayList<Piece> whiteTakenPieces;
    private final ArrayList<Piece> blackTakenPieces;
    private final ObservableList<Piece> observableWhiteTakenPieces;
    private final ObservableList<Piece> observableBlackTakenPieces;
    
    public ChessBoard() {
        board = new Square[8][8];
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                board[i][j] = new Square(new Coordinate(i, j));
            }
        }
        activeColour = ChessColour.WHITE;
        fullMove = 1;
        this.reset();
        takenPieces = new ArrayList<>();
        whiteTakenPieces = new ArrayList<>();
        blackTakenPieces = new ArrayList<>();
        observableWhiteTakenPieces = FXCollections.observableList(whiteTakenPieces);
        observableBlackTakenPieces = FXCollections.observableList(blackTakenPieces);
    }
    
    public ChessBoard(Coordinate positions[], Piece pieces[]) throws IllegalArgumentException {
        if (positions.length != pieces.length) {
            throw new IllegalArgumentException();
        } else {
            board = new Square[8][8];
            for (int i = 0; i <= 7; i++) {
                for (int j = 0; j <= 7; j++) {
                    board[i][j] = new Square(new Coordinate(i, j));
                }
            }
            for (int k = 0; k < positions.length; k++) {
                pieces[k] = board[positions[k].getColumnNumber()][positions[k].getRowNumber()].addPiece(pieces[k]);
            }
        }
        activeColour = ChessColour.WHITE;
        fullMove = 1;
        takenPieces = new ArrayList<>();
        whiteTakenPieces = new ArrayList<>();
        blackTakenPieces = new ArrayList<>();
        observableWhiteTakenPieces = FXCollections.observableList(whiteTakenPieces);
        observableBlackTakenPieces = FXCollections.observableList(blackTakenPieces);
    }
    
    protected Square getSquare(Coordinate c) {
        return board[c.getColumnNumber()][c.getRowNumber()];
    }
    
    public void reset() {
        for (int l = 0; l <= 7; l++) {
            int m = 1;
            board[l][m].addPiece(new Pawn(ChessColour.WHITE));   // Place the white peasents
            m = 6;
            board[l][m].addPiece(new Pawn(ChessColour.BLACK));   // Place the black peasents
        }
        board[0][0].addPiece(new Rook(ChessColour.WHITE));
        board[7][0].addPiece(new Rook(ChessColour.WHITE)); // Place the white rooks
        board[1][0].addPiece(new Knight(ChessColour.WHITE));
        board[6][0].addPiece(new Knight(ChessColour.WHITE)); // Place the white knights
        board[2][0].addPiece(new Bishop(ChessColour.WHITE));
        board[5][0].addPiece(new Bishop(ChessColour.WHITE)); // Place the white bishops
        board[4][0].addPiece(new Queen(ChessColour.WHITE));
        board[3][0].addPiece(new King(ChessColour.WHITE)); // Place the white royalty
        board[0][7].addPiece(new Rook(ChessColour.BLACK));
        board[7][7].addPiece(new Rook(ChessColour.BLACK)); // Place the black rooks
        board[1][7].addPiece(new Knight(ChessColour.BLACK));
        board[6][7].addPiece(new Knight(ChessColour.BLACK)); // Place the black knights
        board[2][7].addPiece(new Bishop(ChessColour.BLACK));
        board[5][7].addPiece(new Bishop(ChessColour.BLACK)); // Place the black bishops
        board[3][7].addPiece(new Queen(ChessColour.BLACK));
        board[4][7].addPiece(new King(ChessColour.BLACK)); // Place the black royalty
        
        for (int i = 0; i <= 7; i++) {
            for (int j = 2; j <= 5; j++) {
                board[i][j].deletePiece(); // Delete all the pieces that are in the middle 4 rows of the board
            }
        }
    }
    
    public boolean move(Coordinate src, Coordinate dest){
        Square srcSquare = this.getSquare(src); // Check to see if there is a piece that can be moved
        if (!srcSquare.isOccupied()){
            return false;
        }
        
        Piece p = srcSquare.getPiece(); // Get the piece that is being moved
        if (!p.getColour().equals(activeColour)){   // Make sure the moved piece is belongs to the active colour
            return false;
        }
        
        if (p.isLeagalMove(this,src,dest)){
            Square destSquare = this.getSquare(dest);
            Piece takenPiece = destSquare.addPiece(p);
            //System.out.println("takenPiece is registered");
            if (takenPiece != null) {
                //System.out.println("takenPiece is not null");
		if (takenPiece.getColour().equals(chess.ChessColour.WHITE)) {
		    observableWhiteTakenPieces.add(takenPiece);
		}
		if (takenPiece.getColour().equals(chess.ChessColour.BLACK)) {
		    observableBlackTakenPieces.add(takenPiece);
		}
 
                //System.out.println(takenPiece.toString());
            }
            srcSquare.deletePiece();
            if (activeColour == ChessColour.WHITE) {
                activeColour = ChessColour.BLACK;   // Change playable player to black
            }
            else {
                activeColour = ChessColour.WHITE;   // Change playable player back to white
                fullMove++;                         // Increment fullMove once both players have had their turn
            }
            return true;    // Return true if move is successful
        }
        return false;
    }
    
    public void addTakenObserver(ListChangeListener listener) {
        observableWhiteTakenPieces.addListener(listener);
        observableBlackTakenPieces.addListener(listener);
    }
    
    @Override
    public String toString() {
        System.out.println("Board:Board");
        for (int n = 7; n >= 0; n--) {
            String b = new String();
            for (int p = 0; p <= 7; p++) {
                if (board[p][n].getPiece() == null) {
                    b += " ";
                }
                else {
                    b += Character.toString(board[p][n].getPiece().getShortName());
                }
                b += "_";
            }
            System.out.println(b);
        }
        return "";
    }
    
    public String toFEN() {
        System.out.print("FEN:");
        for (int s = 7; s >= 0; s--) {
            String f = new String();
            for (int q = 0; q <= 7; q++) {
                if (board[q][s].getPiece() == null) {
                    f += " ";
                }
                else {
                    f += Character.toString(board[q][s].getPiece().getShortName());
                }
            }
            f += "/";
            System.out.print(f);
        }
        char c;
        if (activeColour == chess.ChessColour.WHITE) {
            c = 'w';
        }
        else {
            c = 'b';
        }
        return " " + c + " " + fullMove + "\n";
    }
    
    public String toTakenString() {
        String s = new String();
        for(int i=0; i<takenPieces.size(); i++) {
            if (takenPieces.get(i).getColour() == ChessColour.WHITE) {
                s += Character.toString(takenPieces.get(i).getShortName());
            }
        }
        s += Character.toString(',');
        for(int i=0; i<takenPieces.size(); i++) {
            if (takenPieces.get(i).getColour() == ChessColour.BLACK) {
                s += Character.toString(takenPieces.get(i).getShortName());
            }
        }
        return s;
    }
}
