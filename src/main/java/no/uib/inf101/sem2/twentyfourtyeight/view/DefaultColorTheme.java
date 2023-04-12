package no.uib.inf101.sem2.twentyfourtyeight.view;

import java.awt.Color;

public class DefaultColorTheme implements ColorTheme {




    @Override
    public Color getTileColor(char c) {
        
        Color color = switch(c) {
        case 'A' -> new Color(238, 228, 218); //2
        case 'B' -> new Color(237, 224, 200); //4
        case 'C' -> new Color(242, 177, 121); //8
        case 'D' -> new Color(245, 149, 99); //16
        case 'E' -> new Color(246, 124, 95); //32
        case 'F' -> new Color(246, 94, 59); //64
        case 'G' -> new Color(237, 207, 114); //128
        case 'H' -> new Color(237, 204, 97); //256
        case 'I' -> new Color(237, 200, 80); //512
        case 'J' -> new Color(237, 197, 63); //1024
        //finne en fargekode for case 2048 -> new Color(?)
        case 'r' -> Color.RED;
        case 'g' -> Color.GREEN;
        case 'y' -> Color.YELLOW;
        case 'p' -> Color.PINK;
        case '-' -> Color.GRAY;
        default -> throw new IllegalArgumentException(
            "No available color for '" + c + "'");
        };
        return color;
    }
    
    
    
    @Override
    public Color getFrameColor() {
        Color frameColor = new Color(0, 0, 0, 0);
        return frameColor;
        }

    @Override
    public Color getBackgroundColor() {
        return null;
    }


    @Override
    public Color getGameOverColor() {
        
        return new Color(0, 0, 0, 128);
    }


    @Override
    public Color getFontColor() {
        return Color.WHITE;
    }
    
}

