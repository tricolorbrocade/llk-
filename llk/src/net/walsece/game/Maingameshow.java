package net.walsece.game;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.SubstanceOfficeBlue2007LookAndFeel;
import net.walsece.game.NewJPanel;
public class Maingameshow extends JPanel {
	JFrame n2=null;
	 public Maingameshow(JFrame n2) {
		 	this.n2=n2;
	      //  PathPanel panel = new PathPanel();
	        //this.setLayout(new BorderLayout());//布局管理器
	       // this.add(panel, BorderLayout.CENTER);//中心
	        //this.add(new status(panel), BorderLayout.NORTH);//北
		 	initComponents();
	    
	    }
	 @SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desc="Generated Code"> 
	 private void initComponents() {
		  PathPanel panel = new PathPanel();
	        this.setLayout(new BorderLayout());//布局管理器
	        this.add(panel, BorderLayout.CENTER);//中心
	        this.add(new status(panel), BorderLayout.NORTH);//北
	 }
}
