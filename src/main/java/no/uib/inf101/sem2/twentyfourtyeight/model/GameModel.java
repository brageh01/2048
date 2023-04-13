package no.uib.inf101.sem2.twentyfourtyeight.model;


import no.uib.inf101.sem2.grid.GridCell;
import no.uib.inf101.sem2.grid.GridDimension;
import no.uib.inf101.sem2.twentyfourtyeight.controller.ControllableGameModel;
import no.uib.inf101.sem2.twentyfourtyeight.tile.Tile;
import no.uib.inf101.sem2.twentyfourtyeight.tile.TileFactory;
import no.uib.inf101.sem2.twentyfourtyeight.view.GameState;
import no.uib.inf101.sem2.twentyfourtyeight.view.ViewableGameModel;

public class GameModel implements ViewableGameModel, ControllableGameModel {
    GameBoard board;
    TileFactory factory;
    GameState gameState;
    

    public GameModel(GameBoard board, TileFactory factory){
        this.board = board;
        this.factory = factory;
        this.gameState = GameState.ACTIVE_GAME;

        for (int i = 0; i < 2; i++){
            addRandomTile();
        }
    }

    private void addRandomTile(){
        board.addTile(factory.getNext(board.getRandomEmptyPosition()));
    }
    
    @Override
    public GridDimension getDimension() {
        return this.board;
    }

    @Override
    public Iterable<GridCell<Integer>> getTilesOnBoard() {
        return this.board;
    }


    @Override
    public Iterable<GridCell<Character>> getTilesOfValue() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTilesOfValue'");
    }


    @Override
    public GameState getGameState() {
        return gameState;
    }


    
    }

