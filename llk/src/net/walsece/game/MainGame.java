package net.walsece.game;

import javax.swing.*;
import java.io.*; 
import java.applet.Applet;
import java.net.MalformedURLException; 
import java.net.URI;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.*;
import java.util.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.SubstanceOfficeBlue2007LookAndFeel;


public class MainGame extends JPanel { //继承图形界面工具包（面板容器）
   // public static  JFrame frame = new JFrame("连连看");//窗体名称
	 File g;
	 URI urg;
	    URL urgg; 
    static void uiInit() {
        try {
            Font font = new Font("宋体", Font.PLAIN, 12);
            UIManager.put("Label.font", font);//添加标签字体
            UIManager.put("Button.font", font);//按钮字体
            SubstanceLookAndFeel sa = new SubstanceOfficeBlue2007LookAndFeel();
            UIManager.setLookAndFeel(sa);//感官
            JFrame.setDefaultLookAndFeelDecorated(true);//界面设置
            JDialog.setDefaultLookAndFeelDecorated(true);//窗体
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void actionPerformed(ActionEvent e) {
    	this.setVisible(false);
    	new Panel();
    	}
    	
    public MainGame() {
    	try {    g = new File("Music/youxi.wav"); 
        urg = g.toURI();
        urgg = urg.toURL();  //解析地址
        AudioClip aaz; 
        aaz = Applet.newAudioClip(urgg);
        aaz.loop();  //循环播放
    } catch (Exception e) 
    { e.printStackTrace();
    }   
    	uiInit();
    	JFrame frame=new JFrame();//创建一个窗口
        NewJPanel panel = new NewJPanel(frame);
    
     //  JFrame frame = new JFeame("连连看");//窗体名称
       // frame.setContentPane(new NewJPanel(null));
    	frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);////用户单击窗口的关闭按钮时程序执行的操作

        frame.setSize(800, 760);//窗体长宽
        frame.setResizable(false);//窗体不可改变（拉伸）
       
        frame.setVisible(true);
    }
    

    public static void main(String[] args){
  //	uiInit();
       
     // PathPanel panel = new PathPanel();
     // JFrame frame = new JFrame("连连看");//窗体名称
      // frame.setContentPane(new MainGame());
       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);////用户单击窗口的关闭按钮时程序执行的操作

       //frame.setSize(800, 760);//窗体长宽
       // frame.setResizable(false);//窗体不可改变（拉伸）
     
     //  frame.setVisible(true);
   	 
        new MainGame();
    }
   
}
