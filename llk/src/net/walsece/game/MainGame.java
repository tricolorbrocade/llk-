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


public class MainGame extends JPanel { //�̳�ͼ�ν��湤�߰������������
   // public static  JFrame frame = new JFrame("������");//��������
	 File g;
	 URI urg;
	    URL urgg; 
    static void uiInit() {
        try {
            Font font = new Font("����", Font.PLAIN, 12);
            UIManager.put("Label.font", font);//��ӱ�ǩ����
            UIManager.put("Button.font", font);//��ť����
            SubstanceLookAndFeel sa = new SubstanceOfficeBlue2007LookAndFeel();
            UIManager.setLookAndFeel(sa);//�й�
            JFrame.setDefaultLookAndFeelDecorated(true);//��������
            JDialog.setDefaultLookAndFeelDecorated(true);//����
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
        urgg = urg.toURL();  //������ַ
        AudioClip aaz; 
        aaz = Applet.newAudioClip(urgg);
        aaz.loop();  //ѭ������
    } catch (Exception e) 
    { e.printStackTrace();
    }   
    	uiInit();
    	JFrame frame=new JFrame();//����һ������
        NewJPanel panel = new NewJPanel(frame);
    
     //  JFrame frame = new JFeame("������");//��������
       // frame.setContentPane(new NewJPanel(null));
    	frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);////�û��������ڵĹرհ�ťʱ����ִ�еĲ���

        frame.setSize(800, 760);//���峤��
        frame.setResizable(false);//���岻�ɸı䣨���죩
       
        frame.setVisible(true);
    }
    

    public static void main(String[] args){
  //	uiInit();
       
     // PathPanel panel = new PathPanel();
     // JFrame frame = new JFrame("������");//��������
      // frame.setContentPane(new MainGame());
       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);////�û��������ڵĹرհ�ťʱ����ִ�еĲ���

       //frame.setSize(800, 760);//���峤��
       // frame.setResizable(false);//���岻�ɸı䣨���죩
     
     //  frame.setVisible(true);
   	 
        new MainGame();
    }
   
}
