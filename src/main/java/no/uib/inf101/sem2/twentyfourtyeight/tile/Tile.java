package no.uib.inf101.sem2.twentyfourtyeight.tile;

import no.uib.inf101.sem2.grid.CellPosition;

public class Tile implements ITile {
    // Instance variables
    private int value;
    private CellPosition position;

    // Constructor
    public Tile(int value, CellPosition position) {
        this.value = value;
        this.position = position;
    }

    // Getters
    public int getValue() {
        return value;
    }

    public CellPosition getPosition() {
        return position;
    }

    // Setters
    public void setValue(int value) {
        this.value = value;
    }

    public void setPosition(CellPosition position) {
        this.position = position;
    }

    // Create a new tile with the specified value and position
    public static Tile newTile(int value, CellPosition position) {
        return new Tile(value, position);
    }

    // Creates a copy of the tile with a new position
    public Tile shiftedBy(int deltaRow, int deltaCol) {
        return new Tile(this.value, new CellPosition(this.position.row() + deltaRow, this.position.col() + deltaCol));
    }

    // Checks if two tiles are equal based on their value and position
    

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + value;
        result = prime * result + position.hashCode();
        return result;
    }
}
