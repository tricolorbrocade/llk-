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
	private ImageIcon imgPlay, imgMore;//首页图片宽和高 和临时变量Play键More键
    public NewJPanel(JFrame n2) {
    	
       initComponents();
         this.n2=n2;//通过构造函数接收之前传过来的面板
   	 
	      
    }
    /*
    @SuppressWarnings("deprecation")
  	void Music(){  
      	  try {      
      	      f = new File("D:\\搜狗高速下载\\lingsheng.wav"); 
      	      uri = f.toURI();
      	      url = uri.toURL();  //解析地址
      	      AudioClip aau; 
      	      aau = Applet.newAudioClip(url);
      	      aau.loop();  //循环播放
      	  } catch (Exception e) 
      	  { e.printStackTrace();
      	  } 
      	}
      	*/
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents()  {
    	jButton1 = new javax.swing.JButton();//添加按钮
        jButton1.setText("测试1");
        add(jButton1);
        more = new javax.swing.JButton();//添加按钮
        more.setText("测试2");
        add(more);
        more.setBounds(300,500,145,75);
        more.setBorderPainted(false);
        play = new JButton();
        add(play);
        play.setText("测试1");
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
                Maingameshow p1=new Maingameshow(n2);//新建面板NewJPanel2，并将窗口n2传入
                setVisible(false);//隐藏当前面板
                n2.add(p1);//在窗口中添加面板p1
                n2.setVisible(true);//显示面板
            }
        });
        more.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
                choujiang p4=new choujiang(n2);//新建面板NewJPanel2，并将窗口n2传入
                setVisible(false);//隐藏当前面板
                n2.add(p4);//在窗口中添加面板p1
                n2.setVisible(true);//显示面板
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

