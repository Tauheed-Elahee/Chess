/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import chess.Piece;
import chess.Pawn;
import chess.Rook;
import chess.Knight;
import chess.Bishop;
import chess.Queen;
import chess.King;
import chess.ChessColour;
import chess.ChessPieces;
import chess.Square;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cheryl
 */
public class PieceTest {
    
    public PieceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testConstructorUnoccupiedWhite() {
         Piece p = new Piece ( ChessColour.WHITE, ChessPieces.KING );
         Assert.assertEquals('K', p.getShortName());
         Assert.assertEquals(ChessColour.WHITE, p.getColour());
         Assert.assertEquals(ChessPieces.KING, p.getName());
    }
    @Test
    public void testConstructorUnoccupiedBlack() {
         Piece p = new Piece ( ChessColour.BLACK, ChessPieces.KING );
         Assert.assertEquals('k', p.getShortName());
         Assert.assertEquals(ChessColour.BLACK, p.getColour());
         Assert.assertEquals(ChessPieces.KING, p.getName());
    }
    
    @Test
    public void testConstructorShortNameBlack() {
         Piece p = new King ( ChessColour.BLACK );
         Assert.assertEquals('k', p.getShortName());
         Assert.assertEquals(ChessColour.BLACK, p.getColour());
         Assert.assertEquals(ChessPieces.KING, p.getName());
    }
    @Test
    public void testConstructorShortNameWhite() {
         Piece p = new King ( ChessColour.WHITE );
         Assert.assertEquals('K', p.getShortName());
         Assert.assertEquals(ChessColour.WHITE, p.getColour());
         Assert.assertEquals(ChessPieces.KING, p.getName());
    }
    
//    @Test
//    public void testConstructorShortNameInvalid() {
//         try {
//           Piece p = new Piece ( 'L' );
//           Assert.fail();
//         } catch (IllegalArgumentException e) { /*Should catch */ }
//    }
    
    @Test
    public void testToString() {
         Piece p = new Piece ( ChessColour.WHITE, ChessPieces.KING );
         Assert.assertEquals("WHITE KING", p.toString());
    }
}