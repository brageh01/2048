package no.uib.inf101.sem2.twentyfourtyeight.model;

import java.util.Random;
import no.uib.inf101.sem2.twentyfourtyeight.tile.Tile;

import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.grid.Grid;

public class GameBoard extends Grid<Character>{

    
    
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

/* public Tile[] tiles;
public int r, c;

public GameBoard(int row,int col) {
    this.r = row;
    this.c = col;
    this.tiles = new Tile[this.rows()*this.cols()];
    for (Tile t : tiles) {
        t = new Tile(0);
    }
    addRandom(2);
}

public void addRandom(int n) {
    Random r = new Random();
    while(n > 0) {
        
        int index = r.nextInt(this.rows()*this.cols());
        if (tiles[index].getValue() == 0) {
            tiles[index].setValue(r.nextInt(10) == 0 ? 2 : 1);
            n--;
        }
    }
}


public int rows() {
    return this.r;
}

public int cols() {
    return this.c;
}
 */