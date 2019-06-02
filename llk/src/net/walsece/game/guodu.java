package net.walsece.game;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.util.Timer;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.SubstanceOfficeBlue2007LookAndFeel;

import com.sun.glass.events.WindowEvent;
public class guodu extends JFrame{
		private static final long serialVersionUID = 1L;
		private ImageIcon img;//首页背景图片 
		private ImageIcon imgPlay, imgMore;//首页图片宽和高 和临时变量Play键More键
	
		private int IMGW, IMGH;
		private int imgw, imgh;
	//标签 布局 按钮等 监听器
		private JLabel label;
		private JPanel panel;
		private JButton play, more, button;
		private ActionListener playListener, moreListener;
	 
	//执行函数
		public static void main(String[] args){
			
	        new guodu();
	    }
		//重载函数
		public guodu(){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			img = new ImageIcon(getClass().getResource("/net/walsece/game/icons/bg01.jpg"));//背景图片
			IMGH = img.getIconHeight();//得到图片高
			IMGW = img.getIconWidth();//得到图片宽
			this.setBounds(0,0,800, 760);
			this.setTitle("连连看");
			label = new JLabel(img);
			label.setBounds(0,0,IMGW,IMGH);

			this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
			this.setLayout(null);
			panel = new JPanel();
			panel.setLayout(null);
			panel.setBounds(0,IMGH/2,IMGW,IMGH/2);
			panel.setOpaque(false);
			setContentPane(panel);
			
			setVisible(true);
			getContentPane().setLayout(null);
			
			play = new JButton();
			play.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				//	 MainGame M= new MainGame();
					setVisible(false);//隐藏当前面板
				
					MainGame.main(null);
					PathPanel Path=new PathPanel();
					Path.level++;
				}
			});
			more = new JButton();
			imgPlay = new ImageIcon("/net/walsece/game/icons/bg01.jpg");
			imgMore = new ImageIcon("icons/png-0529.png");
			play.setIcon(imgPlay);
			more.setIcon(imgMore);
			add(play);
			add(more);
		play.setBounds((IMGW/2)-102,(IMGH/2)+23,193,47);
	play.setBorderPainted(false);
	more.setBounds((IMGW/2)-102,(IMGH/2)+100,193,47);
	more.setBorderPainted(false);
	//playListener = new PlayListener();
	 //moreListener = new MoreListener();
	play.addActionListener(playListener);
	more.addActionListener(moreListener);
 }
	//重载函数
	public guodu(int i)
{
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	img=new ImageIcon("src/images/bg01.png");
	IMGH=img.getIconHeight();
	IMGW=img.getIconWidth();
	this.setBounds(200, 200, IMGW, IMGH);
	this.setTitle("连连看");
	label = new JLabel(img);
	label.setBounds(0,0,IMGW,IMGH);
	this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
	this.setLayout(null);
	
	panel = new JPanel();
	panel.setLayout(null);
	panel.setBounds(IMGH/2,IMGH/2,IMGW,IMGH/2);
img = new ImageIcon("src/images/01.png");
	imgw = img.getIconWidth() + 2;
	imgh = img.getIconHeight() + 2;
	for(int cols = 1;cols < 6;cols++)
	{
for(int rows = 0;rows < 5;rows++ )
{
buttonCreated2("src/"+cols+".png",cols+"",cols*imgw,rows*imgh,imgw,imgh);
}
}
	panel.setOpaque(false);
	this.setContentPane(panel);
	this.setVisible(true);
 }



	
   
 




  

public void buttonCreated2(String file,String command,int x,int y,int w,int h)
		{
	img=new ImageIcon(file);
 button=new JButton(img);
 button.setBounds(x,y,imgw,imgh);
 button.setContentAreaFilled(false);
 button.setActionCommand(command);
 panel.add(button);
 }


	public void actionPerformed(ActionEvent e){
			this.dispose();
 }
		public void windowActivated(WindowEvent arg0) {
	// TODO Auto-generated method stub
			
	}
		public void windowClosed(WindowEvent arg0) {
	// TODO Auto-generated method stub

}
	public void windowClosing(WindowEvent arg0) {
	// TODO Auto-generated method stub

}
	public void windowDeactivated(WindowEvent arg0) {
	// TODO Auto-generated method stub

}
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

}
	public void windowIconified(WindowEvent arg0) {
	// TODO Auto-generated method stub

}
	public void windowOpened(WindowEvent arg0) {
	// TODO Auto-generated method stub    
}
	



}
