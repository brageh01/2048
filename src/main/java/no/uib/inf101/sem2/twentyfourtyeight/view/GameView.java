package no.uib.inf101.sem2.twentyfourtyeight.view;

import javax.swing.JPanel;

import no.uib.inf101.sem2.grid.GridCell;
import no.uib.inf101.sem2.twentyfourtyeight.model.GameModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;




public class GameView extends JPanel{
    ViewableGameModel model;
    ColorTheme colorTheme;
    double INNER_MARGIN = 10;
    double OUTER_MARGIN = 10;
    public GameView(GameModel model){
        this.model = model;
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(400, 300));

        colorTheme = new DefaultColorTheme();
        Color backgroundColor = colorTheme.getBackgroundColor();
        this.setBackground(backgroundColor);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        drawGame(g2);
    }

    private void drawGame(Graphics2D g2){

        double boxDimX = this.getWidth()-2*INNER_MARGIN;
        double boxDimY = this.getHeight()-2*INNER_MARGIN;
        // Rektangel for spillområdet
        Rectangle2D gameArea = new Rectangle2D.Double(OUTER_MARGIN, OUTER_MARGIN, boxDimX, boxDimY);
        Shape shape = gameArea;
    
        // Fyll rektangelet med fargen til rammen rundt rutenettet
        g2.setColor(colorTheme.getFrameColor());
        g2.fill(shape);
        g2.draw(shape);
      
        // Opprett et CellPositionToPixelConverter-objekt basert på rektangelet
      
        CellPositionToPixelConverter converter = new CellPositionToPixelConverter(gameArea, model.getDimension(), INNER_MARGIN);
    
        // Tegn hver celle i rutenettet ved å kalle på drawCell-metoden
        drawCells(g2, model.getTilesOnBoard(), converter, colorTheme);
        //drawCells(g2, model.GetTilesOfValue(), converter, colorTheme)
        
        
    }

    private static void drawCells(Graphics2D g2, Iterable<GridCell<Character>> cells, CellPositionToPixelConverter converter, ColorTheme colorTheme) {
        for (GridCell<Character> cell : cells) {
            Rectangle2D rect = converter.getBoundsForCell(cell.pos());
            Color color = colorTheme.getTileColor(cell.value());
    
            Shape shape = rect;
            g2.setColor(color);
            g2.fill(shape);
            g2.draw(shape);

            //AVVENT MED RESTERENDE HER
            //FontMetrics fm = g2.getFontMetrics();
            //String number = Integer.toString(tile.getNumber());
            //int x = (int) (rect.getX() + rect.getWidth() / 2 - fm.stringWidth(number) / 2);
            //int y = (int) (rect.getY() + rect.getHeight() / 2 + fm.getAscent() / 2);
            //g2.drawString(number, x, y);
        }
    }
}

