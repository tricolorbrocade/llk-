package net.walsece.game;
import java.applet.Applet;

import java.net.MalformedURLException;

import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import java.net.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.applet.AudioClip; 
import java.io.*; 
import java.applet.Applet;
import java.net.MalformedURLException; 
import java.net.URI;
import java.net.URL;
import javax.swing.JFrame;


import net.walsece.game.choujiang;
import net.walsece.game.Maingameshow;
import net.walsece.game.PathPanel;
public class NewJPanel extends javax.swing.JPanel {
	 Image image=null;
    /**
     * Creates new form NewJPanel
     */
	  File f;
	    URI uri;
	       URL url; 
	JFrame n2=null;
	private JButton play, more, button;
	private ImageIcon imgPlay, imgMore;//��ҳͼƬ��͸� ����ʱ����Play��More��
    public NewJPanel(JFrame n2) {
    	
       initComponents();
         this.n2=n2;//ͨ�����캯������֮ǰ�����������
   	 
	      
    }
    /*
    @SuppressWarnings("deprecation")
  	void Music(){  
      	  try {      
      	      f = new File("D:\\�ѹ���������\\lingsheng.wav"); 
      	      uri = f.toURI();
      	      url = uri.toURL();  //������ַ
      	      AudioClip aau; 
      	      aau = Applet.newAudioClip(url);
      	      aau.loop();  //ѭ������
      	  } catch (Exception e) 
      	  { e.printStackTrace();
      	  } 
      	}
      	*/
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents()  {
    	jButton1 = new javax.swing.JButton();//��Ӱ�ť
        jButton1.setText("����1");
        add(jButton1);
        more = new javax.swing.JButton();//��Ӱ�ť
        more.setText("����2");
        add(more);
        more.setBounds(300,500,145,75);
        more.setBorderPainted(false);
        play = new JButton();
        add(play);
        play.setText("����1");
        play.setBounds(300,400,145,75);
        play.setBorderPainted(false);
        imgPlay = new ImageIcon("button/play3.png");
		imgMore = new ImageIcon("button/MORE.png");
		play.setIcon(imgPlay);
		more.setIcon(imgMore);
    	ImageIcon image = new ImageIcon("background/bejing.png");
    	 JLabel label = new JLabel();
    	 label.setIcon(image);
    	 label.setBounds(0,0,800,700);
    	 add(label);
        
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
                Maingameshow p1=new Maingameshow(n2);//�½����NewJPanel2����������n2����
                setVisible(false);//���ص�ǰ���
                n2.add(p1);//�ڴ�����������p1
                n2.setVisible(true);//��ʾ���
            }
        });
        more.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
                choujiang p4=new choujiang(n2);//�½����NewJPanel2����������n2����
                setVisible(false);//���ص�ǰ���
                n2.add(p4);//�ڴ�����������p1
                n2.setVisible(true);//��ʾ���
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
      
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115,115)
                .addComponent(jButton1)
                .addContainerGap(188, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jButton1)
                .addContainerGap(187, Short.MAX_VALUE))
        );
       jButton1.setVisible(false);
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        
    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    // End of variables declaration  
   
  
  

    
      }

