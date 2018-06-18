/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.ListChangeListener;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


/**
 *
 * @author Tauheed Elahee
 */
public class Assign4 extends Application implements ListChangeListener {
    
    private ChessBoard chessBoard;
    private Image icon;
    private SquareEventHandler eventHandler;
    private Button[] whiteTakenPieces;
    private Button[] blackTakenPieces;
    
    @Override
    public void start(Stage primaryStage) {
        
        chessBoard = new ChessBoard();
        chessBoard.addTakenObserver(this);
        eventHandler = new SquareEventHandler(chessBoard);
        
        BorderPane root = new BorderPane();
        
        GridPane battleField = new GridPane();
        GridPane whiteCaputredPieces = new GridPane();
        GridPane blackCapturedPieces = new GridPane();
        
        Button[] buttons = new Button[64];
        whiteTakenPieces = new Button[16];
        blackTakenPieces = new Button[16];
        
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                buttons[(8*i)+j] = new Button();
                
                if (((i%2 == 0) && ((8-j)%2 == 0)) || ((i%2 == 1) && ((8-j)%2 == 1))) {
                    buttons[(8*i)+j].setStyle("-fx-background-color: white;");
                }
                else {
                    buttons[(8*i)+j].setStyle("-fx-background-color: grey;");
                }
                
                if (chessBoard.getSquare(new Coordinate(i,j)).isOccupied()) {
                    icon = new Image(chessBoard.getSquare(new Coordinate(i,j)).getPiece().getImageString());
                    buttons[(8*i)+j].setGraphic(new ImageView(icon));
                }
                
                buttons[(8*i)+j].setMinSize(90, 90);
                buttons[(8*i)+j].setText(Character.toString((char)('a' + i)) + Integer.toString((j+1)));
                
                buttons[(8*i)+j].setOnAction(eventHandler);
                
                GridPane.setConstraints(buttons[(8*i)+j], i, (8-j));
                battleField.getChildren().add(buttons[(8*i)+j]);
            }
        }
        
        for (int i=0; i<2; i++) {
            for (int j=0; j<8; j++) {
                whiteTakenPieces[(8*i)+j] = new Button();
                whiteTakenPieces[(8*i)+j].setStyle("-fx-border-color: white;" + "-fx-background-color: grey;");
                
                //whiteTakenPieces[(8*i)+j].setText(Integer.toString((8*i)+j));
                
                whiteTakenPieces[(8*i)+j].setMinSize(90, 90);
                GridPane.setConstraints(whiteTakenPieces[(8*i)+j], (1-i), j);
                whiteCaputredPieces.getChildren().add(whiteTakenPieces[(8*i)+j]);
            }
        }
        
        for (int i=0; i<2; i++) {
            for (int j=0; j<8; j++) {
                blackTakenPieces[(8*i)+j] = new Button();
                blackTakenPieces[(8*i)+j].setStyle("-fx-border-color: white;" + "-fx-background-color: grey;");
                
                //blackTakenPieces[(8*i)+j].setText(Integer.toString((8*i)+j));
                
                blackTakenPieces[(8*i)+j].setMinSize(90, 90);
                GridPane.setConstraints(blackTakenPieces[(8*i)+j], i, j);
                blackCapturedPieces.getChildren().add(blackTakenPieces[(8*i)+j]);
            }
        }
        
        root.setLeft(whiteCaputredPieces);
        root.setCenter(battleField);
        root.setRight(blackCapturedPieces);
        
        Scene scene = new Scene(root, 1080, 720);
        
        primaryStage.setTitle("CHESS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void onChanged(Change c) {
        // System.out.println("Change has occured"); //To change body of generated methods, choose Tools | Templates.
        while (c.next()) {
            if (c.wasAdded()) {
                // In our application, should be nothing else
                int index = c.getFrom(); // In our application, will be 1
                List<Piece> pieces = c.getAddedSubList();
                // for (Piece p: pieces) {
                pieces.forEach((Piece p) -> {
                    Boolean isNotPlaced = true;
                    if (p.getColour().equals(chess.ChessColour.WHITE)) {
                        // for (int i=0; i<whiteTakenPieces.length; i++) {
                        for (Button whiteTakenPiece : whiteTakenPieces) {
                            if (isNotPlaced && (whiteTakenPiece.getGraphic() == null)) {
                                whiteTakenPiece.setGraphic(new ImageView(p.getImageString()));
                                isNotPlaced = false;
                                // System.out.println(p.toString());
                            }
                        }
                    }
                    if (p.getColour().equals(chess.ChessColour.BLACK)) {
                        // for (int i=0; i<blackTakenPieces.length; i++) {
                        for (Button blackTakenPiece : blackTakenPieces) {
                            if (isNotPlaced && (blackTakenPiece.getGraphic() == null)) {
                                blackTakenPiece.setGraphic(new ImageView(p.getImageString()));
                                isNotPlaced = false;
                                // System.out.println(p.toString());
                            }
                        }
                    }
                });
            }
        }
    }
    
}

class SquareEventHandler implements EventHandler<ActionEvent> {
    
    private final ChessBoard board;
    private Button firstButton;
    private Button secondButton;
    private Square firstSquare;
    private Square secondSquare;
    private Boolean moveInProgress;
    private Boolean moveFinished;
    private String test;
    
    public SquareEventHandler(ChessBoard chessBoard) {
        board = chessBoard;
        firstButton = null;
        secondButton = null;
        firstSquare = null;
        secondSquare = null;
        moveInProgress = false;
        moveFinished = false;
        test = null;
    }
    
    @Override
    public void handle(ActionEvent event) {
        
        Object temp = event.getSource();
        Button button = (Button)(temp);
        
        if (moveInProgress) {
            
            secondSquare = board.getSquare(new Coordinate(button.getText()));
            moveFinished = board.move(firstSquare.getCoordinate(), secondSquare.getCoordinate());
            
            if(secondSquare.isOccupied()) {
                test = secondSquare.getPiece().toString();
            }
            else {
                test = "N/A";
            }
            
            if (moveFinished) {
                secondButton = button;
                button.setGraphic((ImageView)(firstButton.getGraphic()));
                firstButton.setGraphic(new ImageView());
            }
            
            moveInProgress = false;
        }
        else {
            firstSquare = board.getSquare(new Coordinate(button.getText()));
            
            if(firstSquare.isOccupied()) {
                firstButton = button;
                moveInProgress = true;
                test = firstSquare.getPiece().toString();
            }
            else {
                test = "N/A";
            }
            
            moveFinished = false;
        }
        
        //System.out.println(test + " " + moveInProgress + " " + moveFinished);
        //System.out.println(board.toFEN());
    }
    
    
}
