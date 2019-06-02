package net.walsece.game;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.SubstanceOfficeBlue2007LookAndFeel;

public class Maingameshow extends JPanel {
	 
	 public Maingameshow() {
	    	
	        PathPanel panel = new PathPanel();
	        this.setLayout(new BorderLayout());//布局管理器
	        this.add(panel, BorderLayout.CENTER);//中心
	        this.add(new status(panel), BorderLayout.NORTH);//北
	    
	    }
}
