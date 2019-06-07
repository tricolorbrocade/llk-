package net.walsece.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.SubstanceOfficeBlue2007LookAndFeel;


public class MainGame extends JPanel { //�̳�ͼ�ν��湤�߰������������
   // public static  JFrame frame = new JFrame("������");//��������
    
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
    	
    	//uiInit();
    	JFrame frame=new JFrame();//����һ������
        NewJPanel panel = new NewJPanel(frame);
    
     //  JFrame frame = new JFrame("������");//��������
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
