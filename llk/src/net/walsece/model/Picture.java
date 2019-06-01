package net.walsece.model;


import net.walsece.game.PathPanel;

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: ÍõÌÎ
 * Date: 2007-4-10
 * Time: 19:26:08
 * To change this template use File | Settings | File Templates.
 */
public class Picture {
    private int x;
    private int y;
    private Image img;

    private int row;
    private int col;
    private boolean visible = true;
    private boolean selected;
    private Color bgColor;
    private String id;


    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
        this.y = PathPanel.top + row * (PathPanel.HEIGHT + 1);
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
        this.x = PathPanel.left + col * (PathPanel.WIDTH + 1);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Picture(Image img, String id) {
        this.img = img;
        this.id = id;

    }

    public String getIconId() {
        return img.toString();
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }

    public boolean isSelected() {
        return selected;
    }


    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public Picture(int row, int col, Image img) {
        this.x = row;
        this.y = col;
        this.img = img;
    }


    public Color getBgColor() {
        return bgColor;
    }

    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }

    public void paint(Graphics g) {
        if (!visible) {
            return;
        }
        Graphics2D g2d = (Graphics2D) g;
        if (bgColor != null) {
            g2d.setColor(bgColor);
            g2d.fillRect(x, y, PathPanel.WIDTH, PathPanel.HEIGHT);
        }
        g2d.setStroke(new BasicStroke(PathPanel.BORDER));
        g2d.setColor(new Color(182, 171, 180));
//        if (x == PathPanel.left) {
        g2d.drawLine(x, y, x, y + PathPanel.HEIGHT);
//        }
//        if (y == PathPanel.top) {
        g2d.drawLine(x, y, x + PathPanel.WIDTH, y);
//        }
        g2d.drawLine(x + PathPanel.BORDER, y + PathPanel.HEIGHT + PathPanel.BORDER, x + PathPanel.WIDTH + PathPanel.BORDER, y + PathPanel.HEIGHT + PathPanel.BORDER);
        g2d.drawLine(x + PathPanel.WIDTH + PathPanel.BORDER, y + PathPanel.BORDER, x + PathPanel.WIDTH + PathPanel.BORDER, y + PathPanel.HEIGHT + PathPanel.BORDER);

        g2d.drawImage(img, x, y, null);
        if (selected) {
            Color color = Color.RED;
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
            g2d.setColor(color);
            g2d.fillRect(x+PathPanel.BORDER, y+PathPanel.BORDER, PathPanel.WIDTH, PathPanel.HEIGHT);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        }

    }

    public void setVisible(boolean b) {
        this.visible = b;
    }

    public void setSelected(boolean b) {
        this.selected = b;
    }
}
