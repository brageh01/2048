package no.uib.inf101.sem2.twentyfourtyeight.model;


import no.uib.inf101.sem2.grid.CellPosition;
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
    Tile tile;
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

    
    private boolean canMoveTile(Tile tile, int dx, int dy) {
        CellPosition nextPosition = new CellPosition(tile.getPosition().row() + dy, tile.getPosition().col() + dx);
        
        if (!board.positionIsOnGrid(nextPosition)) {
            return false;
        }
        
        
        
        int nextValue = this.board.get(nextPosition);
    

        if (nextValue == 0) {
            return true;
        } else if (nextValue == tile.getValue()) {
            return true;
        }
    
        return false;
    }
    
    private void applyMoveTile(Tile tile, int dx, int dy) {
        CellPosition currentPosition = tile.getPosition();
        CellPosition nextPosition = new CellPosition(tile.getPosition().row() + dy, tile.getPosition().col() + dx);
        int currentValue = tile.getValue();
        int nextValue = this.board.get(nextPosition);
    
        if (nextValue == 0) {
            Tile movedTile = tile.shiftedBy(dy, dx);
            this.board.set(movedTile.getPosition(), movedTile.getValue());
            this.board.set(currentPosition, 0);
        } else if (nextValue == currentValue) {
            Tile mergedTile = tile.shiftedBy(dy, dx);
            mergedTile.setValue(currentValue * 2);
            this.board.set(mergedTile.getPosition(), mergedTile.getValue());
            this.board.set(currentPosition, 0);
        }
    }
    
    public boolean moveTiles(int dx, int dy) {
        boolean moved = false;
        boolean keepMoving = true;

        while(keepMoving){
            keepMoving = false;
            int startRow = (dy == 1) ? this.board.rows() - 1 : 0;
            int startCol = (dx == 1) ? this.board.cols() - 1 : 0;
            int endRow = (dy == 1) ? -1 : this.board.rows();
            int endCol = (dx == 1) ? -1 : this.board.cols();
            int rowStep = (dy == 0) ? 1 : -dy;
            int colStep = (dx == 0) ? 1 : -dx;
            
            for (int row = startRow; row != endRow; row += rowStep) {
                for (int col = startCol; col != endCol; col += colStep) {
                    CellPosition currentPosition = new CellPosition(row, col);
                    int currentValue = this.board.get(currentPosition);
                    
                    if (currentValue != 0) {
                        Tile currentTile = Tile.newTile(currentValue, currentPosition);
                        
                        if (canMoveTile(currentTile, dx, dy)) {
                            applyMoveTile(currentTile, dx, dy);
                            moved = true;
                            keepMoving = true;
                        }
                    }
                }
            }
        }
            
        if (moved) {
            addRandomTile();
        }
    
        return moved;
    }


    @Override
    public void moveUp() {
        moveTiles(0, -1);
    }

    @Override
    public void moveDown() {
        moveTiles(0, 1);
    }

    @Override
    public void moveLeft() {
        moveTiles(-1, 0);
    }

    @Override
    public void moveRight() {
        moveTiles(1, 0);
    }

    @Override
    public GameState getGameState() {
        return gameState;
    }

    @Override
    public Iterable<GridCell<Integer>> getTilesOfValue() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTilesOfValue'");
    }


    
    }

