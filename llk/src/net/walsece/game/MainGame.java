package net.walsece.game;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.SubstanceOfficeBlue2007LookAndFeel;

/**
 * Created by IntelliJ IDEA.
 * User: 王涛
 * Date: 2007-4-9
 * Time: 18:36:37
 * To change this template use File | Settings | File Templates.
 */
public class MainGame extends JPanel {
    static void uiInit() {
        try {
            Font font = new Font("宋体", Font.PLAIN, 12);
            UIManager.put("Label.font", font);
            UIManager.put("Button.font", font);
            SubstanceLookAndFeel sa = new SubstanceOfficeBlue2007LookAndFeel();
            UIManager.setLookAndFeel(sa);
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    public MainGame() {
        PathPanel panel = new PathPanel();
        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.CENTER);
        this.add(new status(panel), BorderLayout.NORTH);
    }


    public static void main(String[] args) {
        uiInit();
        JFrame frame = new JFrame("连连看");
        frame.setContentPane(new MainGame());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(800, 760);
        frame.setResizable(false);
        frame.setVisible(true);

    }


}
