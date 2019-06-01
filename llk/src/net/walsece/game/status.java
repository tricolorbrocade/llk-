package net.walsece.game;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: 王涛
 * Date: 2007-4-13
 * Time: 23:06:22
 * To change this template use File | Settings | File Templates.
 */
public class status extends JPanel {
    private long time = 600 * 1000;
    private PathPanel main;
    private boolean stoped = false;
    ImageIcon pause = new ImageIcon(getClass().getResource("/net/walsece/game/icons/pause.png"));
    ImageIcon con = new ImageIcon(getClass().getResource("/net/walsece/game/icons/continue.png"));
    private int times_tishi = 3;
    private int times_resort = 3;

    public status(PathPanel path) {
        initComponents();
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    if (stoped) {
                        try {
                            Thread.sleep(500);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        continue;
                    }
                    int t = times.getValue();
                    t--;
                    times.setValue(t);
                    if (t <= 0) {
                        break;
                    }
                    try {
                        Thread.sleep(time / 100);
                    } catch (Exception ex) {
                        break;
                    }
                }
            }
        }).start();
        this.main = path;
        stop.setIcon(pause);
    }

    private void label3ActionPerformed(ActionEvent e) {

        this.tishi.setText("提示×" + (--times_tishi));
        main.tishi();
        if (times_tishi <= 0) {
            this.tishi.setEnabled(false);
        }
    }

    private void label2ActionPerformed(ActionEvent e) {
        stoped = !stoped;
        stop.setText(stoped ? "继续" : "暂停");
        stop.setIcon(stoped ? con : pause);
        main.pause(stoped);
    }

    private void label4ActionPerformed(ActionEvent e) {
        this.resort.setText("重列×" + (--times_resort));
        main.reSort();
        if (times_resort <= 0) {
            this.resort.setEnabled(false);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - wang tao
        panel1 = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        label5 = new JLabel();
        slider1 = new JSlider();
        vSpacer1 = new JPanel(null);
        panel2 = new JPanel();
        times = new JProgressBar();
        stop = new JButton();
        tishi = new JButton();
        resort = new JButton();
        panel3 = new JPanel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();

        //======== this ========
//        setBorder(new MatteBorder(0, 0, 1, 0, Color.magenta));

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), getBorder()));
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent e) {
                if ("border".equals(e.getPropertyName())) throw new RuntimeException();
            }
        });

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //======== panel1 ========
        {
//            panel1.setBorder(new MatteBorder(0, 0, 2, 0, Color.lightGray));
            panel1.setLayout(null);

            //---- button1 ----
            button1.setText("\u9009 \u5173");
            panel1.add(button1);
            button1.setBounds(new Rectangle(new Point(10, 10), button1.getPreferredSize()));

            //---- button2 ----
            button2.setText("\u5f00\u59cb\u6e38\u620f");
            panel1.add(button2);
            button2.setBounds(new Rectangle(new Point(90, 10), button2.getPreferredSize()));

            //---- label5 ----
            label5.setText("\u97f3\u4e50");
            panel1.add(label5);
            label5.setBounds(new Rectangle(new Point(580, 10), label5.getPreferredSize()));
            panel1.add(slider1);
            slider1.setBounds(610, 10, 240, slider1.getPreferredSize().height);
            panel1.add(vSpacer1);
            vSpacer1.setBounds(855, 0, vSpacer1.getPreferredSize().width, 40);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for (int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
//        add(panel1);

        //======== panel2 ========
        {
            panel2.setLayout(null);

            //---- times ----
            times.setValue(100);
            panel2.add(times);
            times.setBounds(170, 10, 250, 25);

            //---- stop ----
            stop.setText("\u6682\u505c");
            stop.setIcon(null);
            stop.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 12));
            stop.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    label2ActionPerformed(e);
                }
            });
            panel2.add(stop);
            stop.setBounds(430, 10, 110, 25);

            //---- tishi ----
            tishi.setText("\u63d0\u793a\u00d73");
            tishi.setIcon(new ImageIcon(getClass().getResource("/net/walsece/game/icons/png-0630.png")));
            tishi.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 12));
            tishi.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    label3ActionPerformed(e);
                }
            });
            panel2.add(tishi);
            tishi.setBounds(550, 10, 110, 25);

            //---- resort ----
            resort.setText("\u91cd\u5217\u00d73");
            resort.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 12));
            resort.setIcon(new ImageIcon(getClass().getResource("/net/walsece/game/icons/png-0616.png")));
            resort.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    label4ActionPerformed(e);
                }
            });
            panel2.add(resort);
            resort.setBounds(670, 10, 110, 25);

            //======== panel3 ========
            {
                panel3.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

                //---- label6 ----
                label6.setIcon(new ImageIcon(getClass().getResource("/net/walsece/game/icons/0.jpg")));
                panel3.add(label6);

                //---- label7 ----
                label7.setIcon(new ImageIcon(getClass().getResource("/net/walsece/game/icons/1.jpg")));
                panel3.add(label7);

                //---- label8 ----
                label8.setIcon(new ImageIcon(getClass().getResource("/net/walsece/game/icons/2.jpg")));
                panel3.add(label8);

                //---- label9 ----
                label9.setIcon(new ImageIcon(getClass().getResource("/net/walsece/game/icons/3.jpg")));
                panel3.add(label9);

                //---- label10 ----
                label10.setIcon(new ImageIcon(getClass().getResource("/net/walsece/game/icons/4.jpg")));
                panel3.add(label10);

                //---- label11 ----
                label11.setIcon(new ImageIcon(getClass().getResource("/net/walsece/game/icons/5.jpg")));
                panel3.add(label11);

                //---- label12 ----
                label12.setIcon(new ImageIcon(getClass().getResource("/net/walsece/game/icons/6.jpg")));
                panel3.add(label12);

                //---- label13 ----
                label13.setIcon(new ImageIcon(getClass().getResource("/net/walsece/game/icons/7.jpg")));
                panel3.add(label13);

                //---- label14 ----
                label14.setIcon(new ImageIcon(getClass().getResource("/net/walsece/game/icons/8.jpg")));
                panel3.add(label14);
            }
            panel2.add(panel3);
            panel3.setBounds(10, 10, 160, 25);
//            panel2.add(vSpacer2);
//            vSpacer2.setBounds(0, 0, vSpacer2.getPreferredSize().width, 40);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for (int i = 0; i < panel2.getComponentCount(); i++) {
                    Rectangle bounds = panel2.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel2.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel2.setMinimumSize(preferredSize);
                panel2.setPreferredSize(preferredSize);
            }
        }
        add(panel2);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - wang tao
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JLabel label5;
    private JSlider slider1;
    private JPanel vSpacer1;
    private JPanel panel2;
    private JProgressBar times;
    private JButton stop;
    private JButton tishi;
    private JButton resort;
    private JPanel panel3;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

