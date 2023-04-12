package no.uib.inf101.sem2.twentyfourtyeight.tile;
import java.awt.Color;


import no.uib.inf101.sem2.twentyfourtyeight.view.DefaultColorTheme;

public class Tile {
    private int value;
    private Color color;

    public Tile(int value) {
        this.value = value;
        DefaultColorTheme theme = new DefaultColorTheme();
        this.color = theme.getTileColor(value);
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public void setValue(int value) {
        this.value = value;
        DefaultColorTheme theme = new DefaultColorTheme();
        this.color = theme.getTileColor(value);
    }

}
