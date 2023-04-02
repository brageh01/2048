package no.uib.inf101.sem2.twentyfourtyeight.view;

import javax.swing.JPanel;

import no.uib.inf101.sem2.twentyfourtyeight.model.GameModel;

import java.awt.Dimension;




public class GameView extends JPanel{
    ViewableGameModel model;
    
    public GameView(GameModel model){
        this.model = model;
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(400, 300));
    }
}
