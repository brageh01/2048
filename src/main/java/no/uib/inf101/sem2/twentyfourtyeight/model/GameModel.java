package no.uib.inf101.sem2.twentyfourtyeight.model;

import no.uib.inf101.sem2.grid.GridCell;
import no.uib.inf101.sem2.grid.GridDimension;
import no.uib.inf101.sem2.twentyfourtyeight.view.GameState;
import no.uib.inf101.sem2.twentyfourtyeight.view.ViewableGameModel;

public class GameModel implements ViewableGameModel {
    GameBoard board;

    public GameModel(GameBoard board){
        this.board = board;
    }

    
    @Override
    public GridDimension getDimension() {
        return this.board;
    }

    @Override
    public Iterable<GridCell<Character>> getTilesOnBoard() {
        return this.board;
    }


    @Override
    public Iterable<GridCell<Character>> getTilesOfValue() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTilesOfValue'");
    }


    @Override
    public GameState getGameState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGameState'");
    }

    
}
