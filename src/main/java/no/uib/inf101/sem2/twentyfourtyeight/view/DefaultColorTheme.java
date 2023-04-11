package no.uib.inf101.sem2.twentyfourtyeight.view;

import java.awt.Color;

public class DefaultColorTheme implements ColorTheme {

    @Override
    public Color getTileColor(int c) {
        Color color = switch(c) {
        case 2 -> new Color(238, 228, 218);
        case 4 -> new Color(237, 224, 200);
        case 8 -> new Color(242, 177, 121);
        case 16 -> new Color(245, 149, 99);
        case 32 -> new Color(246, 124, 95);
        case 64 -> new Color(246, 94, 59);
        case 128 -> new Color(237, 207, 114);
        case 256 -> new Color(237, 204, 97);
        case 512 -> new Color(237, 200, 80);
        case 1024 -> new Color(237, 197, 63);
        //finne en fargekode for case 2048 -> new Color(???????????????????)
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
