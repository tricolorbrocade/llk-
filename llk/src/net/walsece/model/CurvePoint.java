package net.walsece.model;

import net.walsece.game.PathPanel;

import java.awt.*;


public class CurvePoint {
    private int row;
    private int col;

    public CurvePoint(int row, int col) {
        this.row = row;
        this.col = col;
    }


    public CurvePoint(Picture ib) {
        this(ib.getRow(), ib.getCol());
    }





    public Point getPointOnMain() {
        return new Point(PathPanel.left+col * (PathPanel.WIDTH+PathPanel.BORDER) + PathPanel.WIDTH / 2, PathPanel.top+row * (PathPanel.HEIGHT+PathPanel.BORDER) + PathPanel.HEIGHT / 2);
    }


    public String toString() {
        return "CurvePoint{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}
