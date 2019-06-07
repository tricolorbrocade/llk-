package net.walsece.game;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
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
public class choujiang extends JFrame{
	private static final long serialVersionUID = 1L;
	private ImageIcon img;//��ҳ����ͼƬ 
	private ImageIcon imgPlay, imgMore ,imgBack;//��ҳͼƬ��͸� ����ʱ����Play��More��
	// ��ʼ��־
		public static boolean start = false;
		// �����Ƿ���ʣ��
		public static boolean remain = true;
	private int IMGW, IMGH;
	private int imgw, imgh;
//��ǩ ���� ��ť�� ������
	private JLabel label;
	private JPanel panel;
	private JButton play, more, back, button;
	  private Image picture;
	private ActionListener playListener, moreListener,backListener;
	public int a=0;
	Image img_stop1 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("icons/bg11.jpg"));
	Image img_stop2 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("icons/bg11.jpg"));
	Image img_stop3 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("icons/bg11.jpg"));
	Image img_stop4 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("icons/bg11.jpg"));
	Image img_stop5 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("icons/bg11.jpg"));

//ִ�к���
		public static void main(String[] args){
			
	        new choujiang(null);
	    }
		//���غ���
		public choujiang(Graphics g){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			img = new ImageIcon(getClass().getResource("/net/walsece/game/icons/bg11.jpg"));//����ͼƬ
			IMGH = img.getIconHeight();//�õ�ͼƬ��
			IMGW = img.getIconWidth();//�õ�ͼƬ��
			this.setBounds(0,0,800, 760);
			
			
			this.setTitle("������");;
			label = new JLabel(img);
			label.setBounds(0,0,IMGW,IMGH);
			this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
			this.setLayout(null);
			panel = new JPanel();
			panel.setLayout(null);
			panel.setBounds(0,IMGH/2,IMGW,IMGH/2);
			panel.setOpaque(false);
			setContentPane(panel);
			back = new JButton();
			setVisible(true);
			getContentPane().setLayout(null);
			
			play = new JButton();
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				//	 MainGame M= new MainGame();
					setVisible(false);//����
				
					MainGame.main(null);
					PathPanel Path=new PathPanel();
					Path.level++;
				}
			});
			
			play.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					if (picture == null) {
			            picture= createImage(300, 300);
			        }
				a=(int) (Math.random()*5);
				switch(a){
				case 0:
					Graphics offg = picture.getGraphics();
					  offg.drawImage(img_stop1, 300, 3000, 300, 300 , null);//��ͣʱ����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ
			            g.drawImage(picture, 0, 0,null);
			          //  return; 
					 break;
					 case 2:
							Graphics offg1 = picture.getGraphics();
							  offg1.drawImage(img_stop1, 300, 3000, 300, 300 , null);//��ͣʱ����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ
					            g.drawImage(picture, 0, 0,null);
					   //         return; 
					 break;
					 case 3:
						 Graphics offg2 = picture.getGraphics();
						  offg2.drawImage(img_stop1, 300, 3000, 300, 300 , null);//��ͣʱ����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ
				            g.drawImage(picture, 0, 0,null);
				       //     return; 
					 break;
					 case 4:
						 Graphics offg3 = picture.getGraphics();
						  offg3.drawImage(img_stop1, 300, 3000, 300, 300 , null);//��ͣʱ����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ
				            g.drawImage(picture, 0, 0,null);
				        //    return;  
					break;
					 case 5:
						 Graphics offg4 = picture.getGraphics();
						  offg4.drawImage(img_stop1, 300, 3000, 300, 300 , null);//��ͣʱ����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ
				            g.drawImage(picture, 0, 0,null);
				          // return;
						 break;
					}
				}
			});
			more = new JButton();
			imgPlay = new ImageIcon("/net/walsece/game/icons/bg01.jpg");
			imgMore = new ImageIcon("icons/png-0529.png");
			imgBack = new ImageIcon("icons/png-0529.png");
			play.setIcon(imgPlay);
			more.setIcon(imgMore);
			back.setIcon(imgBack);
			add(play);
			add(more);
			add(back);
		play.setBounds((IMGH/2)-102,(IMGH/2)+20,193,47);
	play.setBorderPainted(false);
	more.setBounds((IMGH/2)-102,(IMGH/2)+100,193,47);
	more.setBorderPainted(false);
	back.setBounds((IMGH/2)-102,(IMGH/2)+180,193,47);
	back.setBorderPainted(false);
	//playListener = new PlayListener();
	 //moreListener = new MoreListener();
	play.addActionListener(playListener);
	more.addActionListener(moreListener);
	back.addActionListener(backListener);
	if(remain==false) {play.setEnabled(false);
	more.setEnabled(true);
	
	}
	else {play.setEnabled(true);
	more.setEnabled(false);}
 }
	
	public choujiang(int i)
{
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	img=new ImageIcon("src/images/bg01.png");
	IMGH=img.getIconHeight();
	IMGW=img.getIconWidth();
	this.setBounds(200, 200, IMGW, IMGH);
	this.setTitle("������");
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
