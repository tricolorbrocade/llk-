package net.walsece.game;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.*;
import java.util.*;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.SubstanceOfficeBlue2007LookAndFeel;
import net.walsece.game.NewJPanel;
import net.walsece.game.guodu1;

public class Maingameshow extends JPanel {
	JFrame n2=null;
 Maingameshow panel;
 public static int level =1;
	 public Maingameshow(JFrame n2) {
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
		    					
		                 
		                         if (status.times.getValue() <= 0) {
		                      		                       	 
		                        	 guodu1 p2=new guodu1(n2);//�½����NewJPanel2����������n2����
		                        	 level++;
		 		                 	setVisible(false);
		 		                
		 		                	n2.add(p2);//�ڴ�����������p1
		 		                      n2.setVisible(true);//��ʾ���
		 		                      
		                       	break;
		                            
		                            
		                         }
		                         try {
		                             Thread.sleep(100);
		                         } catch (Exception ex) {
		                             break;
		                         }
		                         
		                     } else {guodu1 p2=new guodu1(n2);//�½����NewJPanel2����������n2����
		                 	setVisible(false);
		                	n2.add(p2);//�ڴ�����������p1
		                      n2.setVisible(true);//��ʾ���
		                     	break;
		                     }}
		               
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


