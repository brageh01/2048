package no.uib.inf101.sem2.twentyfourtyeight.model;

import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.twentyfourtyeight.tile.Tile;
import no.uib.inf101.sem2.twentyfourtyeight.tile.TileFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestGameOver {
    private GameModel gameModel;
    private GameBoard gameBoard;
    private TileFactory tileFactory;

    @BeforeEach
    public void setUp() {
        gameBoard = new GameBoard(4, 4);
        tileFactory = (position) -> new Tile(2, position);
        gameModel = new GameModel(gameBoard, tileFactory);
    }

    @Test
    public void testIsGameOverFalse() {
        assertFalse(gameModel.isGameOver());
    }

    @Test
    public void testIsGameOverTrue() {
        // Fill the board with tiles in a way that no valid moves are possible
        for (int row = 0; row < gameBoard.rows(); row++) {
            for (int col = 0; col < gameBoard.cols(); col++) {
                int value = (row + col) % 2 == 0 ? 2 : 4;
                gameBoard.set(new CellPosition(row, col), value);
            }
        }

        assertTrue(gameModel.isGameOver());
    }
}
