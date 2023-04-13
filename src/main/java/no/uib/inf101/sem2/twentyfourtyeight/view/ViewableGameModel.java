package no.uib.inf101.sem2.twentyfourtyeight.view;

import no.uib.inf101.sem2.grid.GridCell;
import no.uib.inf101.sem2.grid.GridDimension;


public interface ViewableGameModel {
    
    /**
 * The size of the board
 * @return
 */
GridDimension getDimension();



/**
 * Get iterable of the 2048 board.
 * Iterable of GridCell containing tiles for the whole board.
 * @return Iterable of the 2048 board
 */
Iterable<GridCell<Integer>> getTilesOnBoard();


/**
 * Gets every tile on the board with a value
 * @return every tile with another value than zero
 */
Iterable<GridCell<Character>> getTilesOfValue();



/**
 * Decides the state of the game, either ACTIVE or GAME OVER
 * @return the state of the game
 */
GameState getGameState();
}
