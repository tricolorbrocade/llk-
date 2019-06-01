package net.walsece.model;

import net.walsece.game.PathPanel;

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: ÍõÌÎ
 * Date: 2007-4-12
 * Time: 19:01:44
 * To change this template use File | Settings | File Templates.
 */
public class PathLine {
    Point[] points;
    int step = 8;
    int index = 0;
    boolean flag = false;
    Picture b1, b2;
    Color c1 = new Color(189, 24, 231);
    Color c2 = Color.white;
    private PathPanel panel;

    public PathLine(PathPanel p, Point[] points, Picture b1, Picture b2) {
        this.points = points;
        this.b1 = b1;
        this.b2 = b2;
        this.panel = p;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2f));
        g2d.setColor(c1);
        GradientPaint gp;
        int length = step * index;
        int curL = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int l = length - curL;
            if (points[i + 1].x == points[i].x) {
                curL += Math.abs(points[i + 1].y - points[i].y);
                if (curL < length) {
                    g2d.drawLine(points[i].x, points[i].y, points[i + 1].x, points[i + 1].y);
                    if (i == points.length - 2) {
                        flag = true;
                    }
                } else {
                    if (points[i + 1].y - points[i].y < 0) {
                        l = -l;
                    }
                    gp = new GradientPaint(points[i].x, points[i].y, c1, points[i].x, points[i].y + l, c2);
                    g2d.setPaint(gp);
                    g2d.drawLine(points[i].x, points[i].y, points[i].x, points[i].y + l);
                    break;
                }
            } else {
                curL += Math.abs(points[i + 1].x - points[i].x);
                if (curL < length) {
                    g2d.drawLine(points[i].x, points[i].y, points[i + 1].x, points[i + 1].y);
                    if (i == points.length - 2) {
                        flag = true;
                    }
                } else {
                    if (points[i + 1].x - points[i].x < 0) {
                        l = -l;
                    }
                    gp = new GradientPaint(points[i].x, points[i].y, c1, points[i].x + l, points[i].y, c2);
                    g2d.setPaint(gp);
                    g2d.drawLine(points[i].x, points[i].y, points[i].x + l, points[i].y);
                    break;
                }

            }

        }
        if (flag) {
            b1.setVisible(false);
            b2.setVisible(false);
            switch (panel.getLevel()) {
                case 2: {
                    panel.down(b1, true);
                    panel.down(b2, true);
                    break;
                }
                case 3:{
                    panel.left(b1,true);
                    panel.left(b2,true);
                    break;
                }
            }
//            panel.isFinished();
        }
        index++;

    }
}
