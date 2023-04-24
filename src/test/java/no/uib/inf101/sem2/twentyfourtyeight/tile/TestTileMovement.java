package no.uib.inf101.sem2.twentyfourtyeight.tile;

import org.junit.jupiter.api.Test;

import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.twentyfourtyeight.model.GameBoard;
import no.uib.inf101.sem2.twentyfourtyeight.model.GameModel;
import static org.junit.jupiter.api.Assertions.assertEquals;;
public class TestTileMovement {
    
    @Test
    public void tileCanMoveUp(){
        GameBoard board = new GameBoard(4, 4);
        board.set(new CellPosition(1, 1), 2);
        board.set(new CellPosition(2, 1), 2);
        
        FixedTileFactory factory = new FixedTileFactory(0);
        GameModel model = new GameModel(board, factory);
        
        model.moveUp();
        assertEquals(4, board.get(new CellPosition(0, 1)));
        assertEquals(0, board.get(new CellPosition(1, 1)));
        assertEquals(0, board.get(new CellPosition(2, 1)));
    }

    @Test
    public void tileCanMoveDown(){
        GameBoard board = new GameBoard(4, 4);
        board.set(new CellPosition(1, 1), 2);
        board.set(new CellPosition(2, 1), 2);
        
        FixedTileFactory factory = new FixedTileFactory(0);
        GameModel model = new GameModel(board, factory);
    
        model.moveDown();
        assertEquals(4, board.get(new CellPosition(3, 1)));
        assertEquals(0, board.get(new CellPosition(1, 1)));
        assertEquals(0, board.get(new CellPosition(2, 1)));
    }

    @Test
    public void tileCanMoveRight(){
        GameBoard board = new GameBoard(4, 4);
        board.set(new CellPosition(1, 1), 2);
        board.set(new CellPosition(2, 1), 2);
        
        FixedTileFactory factory = new FixedTileFactory(0);
        GameModel model = new GameModel(board, factory);
    
        model.moveRight();
        assertEquals(2, board.get(new CellPosition(1, 3)));
        assertEquals(2, board.get(new CellPosition(2, 3)));
        assertEquals(0, board.get(new CellPosition(1, 1)));
        assertEquals(0, board.get(new CellPosition(2, 1)));
        }
    
    
    @Test
    public void tileCanMoveLeft(){
        GameBoard board = new GameBoard(4, 4);
        board.set(new CellPosition(1, 1), 2);
        board.set(new CellPosition(2, 1), 2);
        
        FixedTileFactory factory = new FixedTileFactory(0);
        GameModel model = new GameModel(board, factory);
    
        model.moveLeft();
        assertEquals(2, board.get(new CellPosition(1, 0)));
        assertEquals(2, board.get(new CellPosition(2, 0)));
        assertEquals(0, board.get(new CellPosition(1, 1)));
        assertEquals(0, board.get(new CellPosition(2, 1)));
    }
        
    


    @Test
    public void testTileShiftedBy() {
        Tile tile = new Tile(2, new CellPosition(0, 0));
        Tile shiftedTile = tile.shiftedBy(1, 1);
        
        assertEquals(2, shiftedTile.getValue());
        assertEquals(1, shiftedTile.getPosition().row());
        assertEquals(1, shiftedTile.getPosition().col());
    }
}

