package no.uib.inf101.sem2;

import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.twentyfourtyeight.model.GameBoard;
import no.uib.inf101.sem2.twentyfourtyeight.model.GameModel;
import no.uib.inf101.sem2.twentyfourtyeight.view.GameView;

import javax.swing.JFrame;

public class Main {
  public static void main(String[] args) {
    GameBoard board = new GameBoard(4, 4);
    
    board.set(new CellPosition(0, 0), 'g');
    board.set(new CellPosition(0, 3), 'p');
    board.set(new CellPosition(2, 0), 'r');
    board.set(new CellPosition(2, 3), 'y');


    GameModel model = new GameModel(board);
    GameView view = new GameView(model);

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("INF101");
    frame.setContentPane(view);
    frame.pack();
    frame.setVisible(true);
  }
}
