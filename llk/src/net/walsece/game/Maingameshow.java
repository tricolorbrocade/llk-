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
	        //this.setLayout(new BorderLayout());//布局管理器
	       // this.add(panel, BorderLayout.CENTER);//中心
	        //this.add(new status(panel), BorderLayout.NORTH);//北
		 	initComponents();
		 	 new Thread(new Runnable() {												
		            public void run() {      
		            	
		                while (true) {
		                	if (PathPanel.maps.size() > 0) {
		    					
		                 
		                         if (status.times.getValue() <= 0) {
		                      		                       	 
		                        	 guodu1 p2=new guodu1(n2);//新建面板NewJPanel2，并将窗口n2传入
		                        	 level++;
		 		                 	setVisible(false);
		 		                
		 		                	n2.add(p2);//在窗口中添加面板p1
		 		                      n2.setVisible(true);//显示面板
		 		                      
		                       	break;
		                            
		                            
		                         }
		                         try {
		                             Thread.sleep(100);
		                         } catch (Exception ex) {
		                             break;
		                         }
		                         
		                     } else {guodu1 p2=new guodu1(n2);//新建面板NewJPanel2，并将窗口n2传入
		                 	setVisible(false);
		                	n2.add(p2);//在窗口中添加面板p1
		                      n2.setVisible(true);//显示面板
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
	    //   this.setLayout(new BorderLayout());//布局管理器
	      //  this.add(statu, BorderLayout.NORTH);//北
	      //  this.add(panel, BorderLayout.CENTER);//中心
	        setLayout(null);
statu.setBounds(0,0,800,40);
panel.setBounds(0,40,800,760);
this.add(statu);
this.add(panel);
panel.setVisible(true);
statu.setVisible(true);
this.setVisible(true);


	
}}


