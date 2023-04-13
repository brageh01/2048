package no.uib.inf101.sem2.twentyfourtyeight.view;

import java.awt.Color;
import java.util.Map;


public interface ColorTheme {
   

    Color getTileColor(int number);

    Color getFrameColor();

    Color getBackgroundColor();

    Color getFontColor();

    Color getGameOverColor();
}
