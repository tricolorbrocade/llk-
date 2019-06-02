package net.walsece.game;

import net.walsece.model.CurvePoint;
import net.walsece.model.Picture;
import net.walsece.model.PathLine;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.util.TimerTask;

public class PathPanel<Ball> extends JPanel implements ActionListener {
    private static final String JFrame = null;
	java.util.List<Ball> balls = new ArrayList<Ball>();
    java.util.List<PathLine> lines = new ArrayList<PathLine>();
    public static int WIDTH = 70;
    public static int HEIGHT = 70;
    public static int rows = 4, columns = 4;//������
    static int PANEL_WIDTH = 800, PANEL_HEIGHT = 700;//Ƕ����
    public static int BORDER = 1;
    Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("icons/bg11.jpg"));
    Image img_stop = Toolkit.getDefaultToolkit().getImage(getClass().getResource("icons/stop.jpg"));

    public static int left, top;
    public static int level = 1;

    Timer timer;
    private int delay = 12;
    private boolean stoped;
    private boolean started;
    private Picture[][] pictures;
    java.util.List<Picture> ibs;
    private Picture front_click, front_over;

    static Map<String, List<Picture>> maps = new HashMap<String, List<Picture>>();

   
    
    private Image offImage;
    boolean pause;

    public PathPanel() {
        ibs = IconsManage.getRandomIcons(rows * columns, maps);//������ͼ��
        this.pictures = new Picture[rows][columns];
        left = (PANEL_WIDTH - BORDER - columns * (WIDTH + 1)) / 2;
        top = (PANEL_HEIGHT - BORDER - (HEIGHT + 1) * rows) / 2; //��������

        initPictures();
        this.addMouseListener(new MouseAdapter() {//�������¼�
            public void mouseClicked(MouseEvent e) {
                if (isOut(e)) {
                    if (front_click != null) {
                        front_click.setSelected(false);
                        front_click = null;
                        repaint();
                    }
                    return;
                }

                Picture nowa = getPicture(e);
                if (nowa != null && nowa.isVisible()) {
                    doClick(nowa);
                    repaint(); //����ѡ��
                }
            }

        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
//                Picture nowa = getPicture(e);
//                if ((nowa == null || !nowa.isVisible())) {
//                    return;
//                }
////                nowa.setBgColor(new Color(248, 192, 3));
////                if (front_over != null && !front_over.getId().equals(nowa.getId())) {
////                    front_over.setBgColor(null);
////                    repaint(front_over.getX(), front_over.getY(), WIDTH + BORDER, HEIGHT + BORDER);
////                }
////                if (front_click != null && nowa.getId().equals(front_click.getId())) {
////                    return;
////                }
////                repaint(nowa.getX(), nowa.getY(), WIDTH + BORDER, HEIGHT + BORDER);
//                front_over = nowa;

            }
        });
    }

    private void initPictures() {
        List<Picture> list = new ArrayList<Picture>(ibs);
        for (int row = 0; row < pictures.length; row++) {
            for (int col = 0; col < pictures[row].length; col++) {
                pictures[row][col] = list.remove((int) (Math.random() * list.size()));
                pictures[row][col].setRow(row);
                pictures[row][col].setCol(col);
            }
        }
    }

    /**
     * �������λ�û�ȡ��Ӧ��ͼƬ
     *
     * @param e
     * @return
     */
    private Picture getPicture(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();//��ȡ����
        if (isOut(e)) {
            return null;
        }

        int row = (y - top) / (BORDER + HEIGHT);
        int col = (x - left) / (BORDER + WIDTH);
        return pictures[row][col];
    }//����ͼƬ������

    boolean isOut(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        int right = left + columns * (BORDER + WIDTH);
        int bottom = top + rows * (BORDER + HEIGHT);

        return x <= left || x - right >= 0 || y <= top || y - bottom >= 0;
    }


    public void isFinished() {
        if (maps.size() > 0) {
            return;
        }
       MainGame.frame.setVisible(false);
		guodu.main(null);
      //  JOptionPane.showMessageDialog(this, "��ϲ�����˵�" + level + "�أ����[ȷ��]������һ��");
        level++;
        ibs.clear();
        ibs = IconsManage.getRandomIcons(rows * columns, maps);
        initPictures();
    } //�趨�صĵȼ�

    /**
     * ����
     *
     * @param p
     * @param flag
     */
    public void down(Picture p, boolean flag) {
        int row = p.getRow();
        int col = p.getCol();
        while (true) {
            if (row <= 0) {
                break;
            }
            Picture up = pictures[row - 1][col];
            if (up.isVisible() || flag) {
                pictures[row - 1][col] = p;
                pictures[row][col] = up;
                up.setRow(row);
                row--;
            } else {
                break;

            }
        }
    }

    /**
     * ���к������
     */
    public void downAll() {
        for (int col = 0; col < columns; col++) {
            for (int row = 0; row < rows; row++) {
                if (!pictures[row][col].isVisible()) {
                    down(pictures[row][col], false);
                }
            }
        }
    }

    /**
     * ����
     *
     * @param p
     * @param flag
     */
    public void left(Picture p, boolean flag) {
        int row = p.getRow();
        int col = p.getCol();
        while (true) {
            if (col >= columns - 1) {
                break;
            }
            Picture up = pictures[row][col + 1];
            if (up.isVisible() || flag) {
                pictures[row][col + 1] = p;
                pictures[row][col] = up;
                up.setCol(col);
                col++;
            } else {
                break;

            }
        }
    }

    public void leftAll() {
        for (int row = 0; row < rows; row++) {
            for (int col = columns - 1; col >= 0; col--) {
                if (!pictures[row][col].isVisible()) {
                    left(pictures[row][col], false);
                }
            }
        }
    }


    public void actionPerformed(ActionEvent e) {
        synchronized (PathPanel.class) {
            Iterator it = lines.iterator();//��һ�ε���Iterator��next()����ʱ�����������еĵ�һ��Ԫ�ء�

            while (it.hasNext()) {
                PathLine l = (PathLine) it.next();
                if (l.isFlag()) {
                    it.remove();
                }
            }
        }
        if (lines.size() > 0 || !stoped) {
            this.repaint();
        }
        if (lines.size() == 0 && started) {
            timer.stop();
            started = false;
            isFinished();
        }
    }


    public void paint(Graphics g) {
        if (offImage == null) {
            offImage = createImage(getWidth(), getHeight());
        }

        Graphics offg = offImage.getGraphics();
        if (pause) {
            offg.drawImage(img_stop, 0, 0, this.getWidth(), this.getHeight(), this);//��ͣʱ����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ
            g.drawImage(offImage, 0, 0, this);
            return;
        }
        super.paint(offg);
        for (Picture[] button : pictures) {
            for (Picture p : button) {
                p.paint(offg);
            }
        }

        if (lines.size() > 0) {//����������ȥ
            synchronized (PathPanel.class) {
                for (PathLine l : lines) {
                    l.draw(offg);
                }
            }
            stoped = false;
        } else {
            stoped = true;
        }
        g.drawImage(offImage, 0, 0, this);

    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
//        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.65f));
        g2d.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));


    }

    /**
     * ����ж�
     *
     * @param ib
     */
    public void doClick(Picture ib) {
        ib.setSelected(true);
        if (front_click != null && !ib.getId().equals(front_click.getId())) {
            front_click.setSelected(false);
        }
        if (front_click != null && front_click != ib && front_click.getIconId().equals(ib.getIconId())) {
            CurvePoint[] cp = getPoints(front_click, ib);
            if (cp != null) {
                drawPath(cp, front_click, ib);
                List<Picture> list = maps.get(front_click.getIconId());
                list.remove(front_click);
                list.remove(ib);
                if (list.size() == 0) {
                    maps.remove(front_click.getIconId());
                }
                front_click = null;

            } else {
                front_click = ib;
            }
        } else {
            front_click = ib;
        }
    }

    public int getLevel() {
        return level;
    }

    public CurvePoint[] getPoints(Picture b1, Picture b2) {

        if (b1.getRow() == b2.getRow()) {
            return wayRow(b1, b2);
        } else if (b1.getCol() == b2.getCol()) {
            return wayCol(b1, b2);
        } else {
            CurvePoint[] cp = wayRow(b1, b2);
            return cp == null ? wayCol(b1, b2) : cp;
        }
    }

    /**
     * �жϡ���������ͨ���Ƿ���·���������ض�Ӧ·���Ĺյ㣬���û��·���򷵻�null
     *
     * @param b1
     * @param b2
     * @return
     */
    CurvePoint[] wayRow(Picture b1, Picture b2) {

        Picture left = b1.getCol() < b2.getCol() ? b1 : b2;
        Picture right = (left == b1) ? b2 : b1;//�ж�˭����˭����

        //��������Ŀ��֮����ص㣬�Ա�֤�����·�����Ǳ���
        int center = getCenter(b1.getRow(), b2.getRow());
        int flag = -1;

        row:
        for (int i = 0; i < rows + 2; i++) {
            if (center + flag * i < -1) {//����´������ĵ���г���������ֹͣ���������ĵ�����
                center += 1;
            } else if (center + flag * i > rows) {//����´������ĵ���г��������£����ĵ�����
                center -= 1;
            } else {
                center += flag * i;//�������ĵ㲻������������
                flag = -flag;
            }

            if (center > -1 && center < rows) {//�����������
                for (int x = left.getCol(); x <= right.getCol(); x++) {
                    String id = pictures[center][x].getId();
                    if (id.equals(b1.getId()) || id.equals(b2.getId())) {
                        continue;//���1��2������ĵ������b1��b2
                    }
                    if (pictures[center][x].isVisible()) {
                        continue row;//�������δ����ͼƬ
                    }
                }
            }
            int r = left.getRow();//������

            int beg = r < center ? r : center;///��������
            int end = r < center ? center : r;
            for (int step = beg + 1; step < end; step++) {
                if (pictures[step][left.getCol()].isVisible()) {
                    continue row;
                }
            }

            r = right.getRow();//�ұߵĵ�
            beg = r < center ? r : center;
            end = r < center ? center : r;//��������
            for (int step = beg + 1; step < end; step++) {
                if (pictures[step][right.getCol()].isVisible()) {
                    continue row;
                }
            }

            CurvePoint[] points;//�Ƚ��м�������ϵ���м��ж��ٹյ�
            if (left.getRow() == center && right.getRow() == center) {//0�յ�
                points = new CurvePoint[2];
                points[0] = new CurvePoint(left);
                points[1] = new CurvePoint(right);
            } else if (left.getRow() == center) {//1�յ�
                points = new CurvePoint[3];
                points[0] = new CurvePoint(left);
                points[1] = new CurvePoint(center, right.getCol());
                points[2] = new CurvePoint(right);
            } else if (right.getRow() == center) {//1�յ�
                points = new CurvePoint[3];
                points[0] = new CurvePoint(left);
                points[1] = new CurvePoint(center, left.getCol());
                points[2] = new CurvePoint(right);
            } else {//2�յ�
                points = new CurvePoint[4];
                points[0] = new CurvePoint(left);
                points[1] = new CurvePoint(center, left.getCol());
                points[2] = new CurvePoint(center, right.getCol());
                points[3] = new CurvePoint(right);
            }

            if (b2.getId().equals(left.getId())) {
                int length = points.length;
                CurvePoint[] cp = new CurvePoint[length];
                for (int index = 0; index < length; index++) {
                    cp[index] = points[length - index - 1];
                }
                return cp;
            }
            return points;

        }

        return null;
    }

    /**
     * �жϡ���������ͨ����û���򷵻�null�����򷵻عյ�����
     *
     * @param b1
     * @param b2
     * @return
     */
    CurvePoint[] wayCol(Picture b1, Picture b2) {
        Picture top = b1.getRow() < b2.getRow() ? b1 : b2;
        Picture bottom = (top == b1) ? b2 : b1;

        //��������Ŀ��֮����ص㣬�Ա�֤�����·�����Ǳ���
        int middle = getCenter(b1.getCol(), b2.getCol());
        int flag = -1;

        row:
        for (int i = 0; i < columns + 2; i++) {
            if (middle + flag * i < -1) {
                middle += 1;
            } else if (middle + flag > rows) {
                middle -= 1;
            } else {
                middle += flag * i;
                flag = -flag;
            }

            if (middle > -1 && middle < columns) {
                for (int x = top.getRow(); x <= bottom.getRow(); x++) {
                    String id = pictures[x][middle].getId();
                    if (id.equals(b1.getId()) || id.equals(b2.getId())) {
                        continue;
                    }
                    if (pictures[x][middle].isVisible()) {
                        continue row;
                    }
                }
            }
            int r = top.getCol();
            int beg = r < middle ? r : middle;
            int end = r < middle ? middle : r;
            for (int step = beg + 1; step < end; step++) {
                if (pictures[top.getRow()][step].isVisible()) {
                    continue row;
                }
            }

            r = bottom.getCol();
            beg = r < middle ? r : middle;
            end = r < middle ? middle : r;
            for (int step = beg + 1; step < end; step++) {
                if (pictures[bottom.getRow()][step].isVisible()) {
                    continue row;
                }
            }

            CurvePoint[] points;
            if (top.getCol() == middle && bottom.getCol() == middle) {
                points = new CurvePoint[2];
                points[0] = new CurvePoint(top);
                points[1] = new CurvePoint(bottom);
            } else {
                points = new CurvePoint[4];
                points[0] = new CurvePoint(top);
                points[1] = new CurvePoint(top.getRow(), middle);
                points[2] = new CurvePoint(bottom.getRow(), middle);
                points[3] = new CurvePoint(bottom);
            }

            if (b2.getId().equals(top.getId())) {
                int length = points.length;
                CurvePoint[] cp = new CurvePoint[length];
                for (int index = 0; index < length; index++) {
                    cp[index] = points[length - index - 1];
                }
                return cp;
            }
            return points;

        }

        return null;
    }
public void tishi() {
        Picture[] maped = getMappedButtons();
        if (maped == null) {
            JOptionPane.showMessageDialog(this, "�����������ˣ���");
            return;
        }
        if (front_click != null) {
            front_click.setSelected(false);
            repaint(front_click.getX(), front_click.getY(), WIDTH + BORDER, HEIGHT + BORDER);
            front_click = null;
        }
        maped[0].setSelected(true);
        maped[1].setSelected(true);
        repaint(maped[0].getX(), maped[0].getY(), WIDTH + BORDER, HEIGHT + BORDER);
        repaint(maped[1].getX(), maped[1].getY(), WIDTH + BORDER, HEIGHT + BORDER);

    }

    /**
     * ����
     */
    public void reSort() {
        initPictures();
        switch (level) {
            case 2:
                downAll();
                break;
            case 3:
                leftAll();
                break;
        }
        repaint();
    }

    Picture[] getMappedButtons() {
        for (List<Picture> l : maps.values()) {
            for (int i = 0; i < l.size(); i++) {
                for (int j = i + 1; j < l.size(); j++) {
                    if (getPoints(l.get(i), l.get(j)) != null) {
                        return new Picture[]{l.get(i), l.get(j)};
                    }
                }
            }
        }
        return null;
    }

    public void pause(boolean b) {
        pause = b;
        repaint();
    }

    int getCenter(int i1, int i2) {
        int min = i1 < i2 ? i1 : i2;
        int max = i1 < i2 ? i2 : i1;
        return min + (max - min) / 2;
    }

    public void startTimer() {
        if (timer == null) {
            timer = new Timer(delay, this);

        }
        if (!started) {
            timer.start();
            started = true;
        }
    }

    public void drawPath(CurvePoint[] points, Picture b1, Picture b2) {
        new Thread(new Drawer(this, points, b1, b2)).start();

    }


    class Drawer implements Runnable {
        private CurvePoint[] points;
        private Picture b1, b2;
        private PathPanel panel;

        Drawer(PathPanel panel, CurvePoint[] points, Picture b1, Picture b2) {
            this.points = points;
            this.b1 = b1;
            this.b2 = b2;
            this.panel = panel;
        }

        public void run() {
            Point[] ps = new Point[points.length];
            for (int i = 0; i < points.length; i++) {
                ps[i] = points[i].getPointOnMain();
            }
            int index = ps.length - 1;

            transPoint(ps[0], ps[1], ps[0], 1);
            transPoint(ps[index - 1], ps[index], ps[index], -1);

            PathLine l = new PathLine(panel, ps, b1, b2);
            synchronized (PathPanel.class) {
                lines.add(l);
            }
            startTimer();
        }

        void transPoint(Point p1, Point p2, Point target, int flag) {
            if (p1.getX() == p2.getX()) {
                if (p1.getY() < p2.getY()) {
                    target.y += flag * HEIGHT / 2;
                } else {
                    target.y -= flag * HEIGHT / 2;
                }
            } else {
                if (p1.getX() < p2.getX()) {
                    target.x += flag * WIDTH / 2;
                } else {
                    target.x -= flag * WIDTH / 2;
                }
            }
        }
    }


}
