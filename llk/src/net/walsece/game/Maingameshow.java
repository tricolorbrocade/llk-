package net.walsece.game;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.applet.AudioClip; 
import java.io.*; 
import java.applet.Applet;
import java.net.MalformedURLException; 
import java.net.URI;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.*;
import java.util.*;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.SubstanceOfficeBlue2007LookAndFeel;
import net.walsece.game.NewJPanel;
import net.walsece.game.guodu1;
import net.walsece.game.victory;
public class Maingameshow extends JPanel {
	JFrame n2=null;
 Maingameshow panel;

 public static int level =1;
	 public Maingameshow(JFrame n2) {
		 //
	
		 	this.n2=n2;
	      //  PathPanel panel = new PathPanel();
	        //this.setLayout(new BorderLayout());//���ֹ�����
	       // this.add(panel, BorderLayout.CENTER);//����
	        //this.add(new status(panel), BorderLayout.NORTH);//��
		 	initComponents();
		 	 new Thread(new Runnable() {												
		            public void run() {      
		            	
		                while (true) {
		                	if (PathPanel.maps.size() > 0) {
		    					
		                 
		                         if (status.times.getValue() <= 0||PathPanel.shibai==1) {
		                        	 PathPanel.shibai=0;                 	 
		                        	 failed  p3=new failed(n2);//�½����NewJPanel2����������n2����
		                    
		 		                 	setVisible(false);
		 		                
		 		                	n2.add(p3);//�ڴ�����������p3
		 		                      n2.setVisible(true);//��ʾ���
		 		                    
		                       	break;
		                            
		                            
		                         }
		                         try {
		                             Thread.sleep(100);
		                         } catch (Exception ex) {
		                             break;
		                         }
		                         
		                     } else {
		                    	 if(level!=3) {
		                     
		                    	 guodu1 p2=new guodu1(n2);//�½����NewJPanel2����������n2����
		                 	setVisible(false);
		                	n2.add(p2);//�ڴ�����������p1
		                      n2.setVisible(true);//��ʾ���
		                     	break;}
		                     else { victory p4=new victory(n2);//�½����NewJPanel2����������n2����
			                 	setVisible(false);
			                	n2.add(p4);//�ڴ�����������p1
			                      n2.setVisible(true);//��ʾ���}
			                      break;
		                     }}
		                     }
		               
		                }	
	    }).start();
	 }
	 @SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desc="Generated Code"> 
	 private void initComponents() {
		  PathPanel panel = new PathPanel(n2);
		  status statu=new status(n2,panel);
	    //   this.setLayout(new BorderLayout());//���ֹ�����
	      //  this.add(statu, BorderLayout.NORTH);//��
	      //  this.add(panel, BorderLayout.CENTER);//����
	        setLayout(null);
statu.setBounds(0,0,800,40);
panel.setBounds(0,40,800,760);
this.add(statu);
this.add(panel);
panel.setVisible(true);
statu.setVisible(true);
this.setVisible(true);


	
}}


