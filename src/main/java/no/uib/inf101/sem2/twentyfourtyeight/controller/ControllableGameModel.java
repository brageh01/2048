package no.uib.inf101.sem2.twentyfourtyeight.controller;

import no.uib.inf101.sem2.twentyfourtyeight.view.GameState;

public interface ControllableGameModel {
    
    void moveUp();

    void moveDown();

    void moveLeft();

    void moveRight();

    GameState getGameState();
}
