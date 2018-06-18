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
public class Coordinate {
    
    private int column;
    private int row;
    
    public Coordinate(int column, int row) {
        if (column > 7 || column < 0 || row > 7 || row < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.column = column;
        this.row = row;
    }
    
    public Coordinate(char column, char row) {
        if (column > 'h' || column < 'a' || row > '7' || row < '1') {
            throw new IndexOutOfBoundsException();
        }
        this.column = ((int) column) - 97;
        this.row = ((int) row) - 49;
    }
    
    public Coordinate(String coordinate) {
        if (coordinate.length() != 2) {
            throw new IllegalArgumentException();
        }
        this.column = (int) (coordinate.charAt(0)) - 97;
        this.row = (int) (coordinate.charAt(1)) - 49;
    }
    
    public char getColumn() {
        return (char) ('a' + this.column);
    }
    
    public int getColumnNumber() {
        return this.column;
    }
    
    public char getRow() {
        return (char) ('1' + this.row); //this is a one plus row number
    }
    
    public int getRowNumber() {
        return this.row;
    }
    
    public String name() {
        return Character.toString(this.getColumn()) + Character.toString(this.getRow()); //Turn each char into a string and then output the combined string
    }
    
    @Override
    public String toString() {
        return "(" + this.getColumnNumber() + "," + this.getRowNumber() + ")";
    }
    
}