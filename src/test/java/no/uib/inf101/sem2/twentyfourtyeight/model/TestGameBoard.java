package no.uib.inf101.sem2.twentyfourtyeight.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import no.uib.inf101.sem2.grid.CellPosition;

public class TestGameBoard{


@Test
public void testPrettyString() {
  GameBoard board = new GameBoard(3, 4);
  board.set(new CellPosition(0, 0), 2);
  board.set(new CellPosition(0, 3), 4);
  board.set(new CellPosition(2, 0), 8);
  board.set(new CellPosition(2, 3), 16);
  String expected = String.join("\n", new String[] {
      "2004",
      "0000",
      "80016"
  });
  assertEquals(expected, board.prettyString());
}

}
