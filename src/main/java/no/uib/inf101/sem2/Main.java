package no.uib.inf101.sem2;

import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.twentyfourtyeight.model.GameBoard;
import no.uib.inf101.sem2.twentyfourtyeight.model.GameModel;
import no.uib.inf101.sem2.twentyfourtyeight.tile.RandomTileFactory;
import no.uib.inf101.sem2.twentyfourtyeight.tile.TileFactory;
import no.uib.inf101.sem2.twentyfourtyeight.view.GameView;

import javax.swing.JFrame;

public class Main {
  public static void main(String[] args) {
    GameBoard board = new GameBoard(4, 4);
    
    /* board.set(new CellPosition(0, 0), 2);
    board.set(new CellPosition(0, 3), 4);
    board.set(new CellPosition(3, 0), 8);
    board.set(new CellPosition(3, 3), 16); */

    TileFactory factory = new RandomTileFactory();
    GameModel model = new GameModel(board, factory);
    GameView view = new GameView(model);

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("2048");
    frame.setContentPane(view);
    frame.pack();
    frame.setVisible(true);
    }
}
