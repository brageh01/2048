package no.uib.inf101.sem2.twentyfourtyeight.model;

import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.grid.Grid;

public class GameBoard extends Grid<Character> {

    public GameBoard(int row, int col) {
    super(row, col, '-');
        
    }
    

    public String prettyString() {
        String boardToString = "";
        for (int row = 0; row < this.rows(); row++) {
            for (int col = 0; col < this.cols(); col++) {
                CellPosition position = new CellPosition(row, col);
                Character value = get(position);
                boardToString += value;
                }
            boardToString += "\n";
            }
        return boardToString.strip();
        }
}
