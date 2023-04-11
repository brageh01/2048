package no.uib.inf101.sem2.twentyfourtyeight.view;

import java.awt.Color;

public interface ColorTheme {
   
    Color getTileColor(int c);

    Color getFrameColor();

    Color getBackgroundColor();

    Color getFontColor();

    Color getGameOverColor();
}
