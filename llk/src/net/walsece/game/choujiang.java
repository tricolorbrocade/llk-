package net.walsece.game;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.swing.JLayeredPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import net.walsece.game.Maingameshow;
import net.walsece.game.PathPanel;
public class choujiang extends javax.swing.JPanel {
	 Image image=null;
    /**
     * Creates new form choujiang
     */
	JFrame n2=null;
	JLabel  label2=null;
	JLabel textFiel=null;
	public static int  jinbi=10;
	public static int  jiangpin=0;
	public static int yuyin=0;
    
	private JButton play, more,back,button;
	private ImageIcon imgPlay, imgMore,imgBack,chou1,chou2,chou3,chou4,chou5;//首页图片宽和高 和临时变量Play键More键
    public choujiang(JFrame n2) {
        initComponents();
        this.n2=n2;//通过构造函数接收之前传过来的面板
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents()  {
     
    	jButton1 = new javax.swing.JButton();//添加按钮
        jButton1.setText("测试1");
        add(jButton1);
        more = new javax.swing.JButton();//添加按钮
        back = new javax.swing.JButton();//添加按钮
        add(back);
        back.setBounds(300,600,145,75);
        back.setBorderPainted(false);
        add(more);
        more.setBounds(300,500,145,75);
        more.setBorderPainted(false);
        play = new JButton();
        add(play);
   
        play.setBounds(300,400,145,75);
        play.setBorderPainted(false);
        
     
        imgPlay = new ImageIcon("button/zhuangbei.png");
		imgMore = new ImageIcon("button/choujiang.png");
		 imgBack = new ImageIcon("button/back.png");
		play.setIcon(imgPlay);
		more.setIcon(imgMore);
		back.setIcon(imgBack);
   
    	// JLabel label1 = new JLabel();
    	
    	 chou1=new ImageIcon("jiangpin/zhongjiang.gif");
    	 chou2=new ImageIcon("jiangpin/yihan.jpeg");
    	 chou3=new ImageIcon("jiangpin/9150e4e5ly1fuhppvcjjej206o06owes.jpg");
    	 chou4=new ImageIcon("jiangpin/xingteng2.png");
    	 chou5=new ImageIcon("jiangpin/xingteng2.png");
    	// label1.setIcon(chou1);
    	// label1.setBounds(500,660,100,100);
    	// add(label1);
    	 
    	 textFiel=new JLabel("金币"+(jinbi));
    	 textFiel.setFont(new Font("宋体", Font.BOLD, 30));
    	 add(textFiel);
    	 textFiel.setBounds(500,360,100,100);
    	 
    	 label2=new JLabel(chou1);
    	 add(label2,1);
    	 label2.setBounds(300,130,300,250);
    	 label2.setVisible(true);

    	 
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
                NewJPanel p1=new NewJPanel(n2);//新建面板choujiang2，并将窗口n2传入
                setVisible(false);//隐藏当前面板
                n2.add(p1);//在窗口中添加面板p1
                n2.setVisible(true);//显示面板
            }
        });
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(jiangpin==1) {
                	if(yuyin==0) {
                	yuyin=1;
                	JOptionPane.showMessageDialog(null, "您的宠物已到账","消息", JOptionPane.WARNING_MESSAGE);
                	}
                	else {yuyin=0;
                	JOptionPane.showMessageDialog(null, "取消装备宠物","消息", JOptionPane.WARNING_MESSAGE);
                	
                	}
                	}
                else {JOptionPane.showMessageDialog(null, "快去赚取金币抽得宠物吧","消息", JOptionPane.WARNING_MESSAGE);}
            }
        });
        more.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
               // JLabel label2=new JLabel(); 
                //JLabel label3=new JLabel();  
               // JLabel label4=new JLabel(); 
                //JLabel label5=new JLabel();
                if(jinbi>0) {
                jinbi--;
                int j;
                if(jiangpin==0) {
                j=(int) (1+Math.random()*5);}
                
                else {j=(int) (2+Math.random()*5);}
          
                switch(j){
                
                	case(1): 
                		label2.setVisible(false);
                		textFiel.setVisible(false);
                		textFiel=new JLabel("金币"+(jinbi));
                     textFiel.setFont(new Font("宋体", Font.BOLD, 30));
                	 add(textFiel,1);
                	 textFiel.setBounds(500,360,100,100);
                	 textFiel.setVisible(true);
                	label2=new JLabel(chou1);
                	 add(label2,1);
                	 label2.setBounds(300,130,300,250);
                	label2.setVisible(true); 
                	
                	jiangpin=1;
                	JOptionPane.showMessageDialog(null, "恭喜获得宠物快去装备宠物吧","消息", JOptionPane.WARNING_MESSAGE);
                	repaint();
                	break;
                	/*
                		remove(label2);
                	 remove(label3);
                	 remove(label4); 
                	 remove(label5);
                   	 label1.setIcon(chou1);
                   	 label1.setBounds(500,660,100,100);
                   	 add(label1);
                       repaint();
                       */
                	case(2):
                		label2.setVisible(false);
                	label2=new JLabel(chou2);
                	 add(label2,1);
                	 label2.setBounds(300,130,300,250);
                	label2.setVisible(true);
                	textFiel.setVisible(false);
                	textFiel=new JLabel("金币"+(jinbi));
                    textFiel.setFont(new Font("宋体", Font.BOLD, 30));
               	 add(textFiel,1);
               	 textFiel.setBounds(500,360,100,100);
               	 textFiel.setVisible(true);
               	repaint();
                 	break;
                	case(3):
                		label2.setVisible(false);
                	label2=new JLabel(chou3);
                	 add(label2,1);   	 
                	 label2.setBounds(300,130,300,250);
                	label2.setVisible(true);  
                	textFiel.setVisible(false);
                	textFiel=new JLabel("金币"+(jinbi));
                    textFiel.setFont(new Font("宋体", Font.BOLD, 30));
               	 add(textFiel,1);
               	 textFiel.setBounds(500,360,100,100);
               	 textFiel.setVisible(true);
               	repaint();
                 	break;
                	case(4):
                		label2.setVisible(false);
                	label2=new JLabel(chou4);
                	 add(label2,1);
                	 label2.setBounds(300,130,300,250);
                	label2.setVisible(true);  
                	textFiel.setVisible(false);
                	textFiel=new JLabel("金币"+(jinbi));
                    textFiel.setFont(new Font("宋体", Font.BOLD, 30));
               	 add(textFiel,1);
               	 textFiel.setBounds(500,360,100,100);
               	 textFiel.setVisible(true);
               	repaint();
                 	break;
                	case(5):
                		label2.setVisible(false);
                	label2=new JLabel(chou5);
                	 add(label2,1);
                	 label2.setBounds(300,130,300,250);
                	label2.setVisible(true);
                	textFiel.setVisible(false);
                	textFiel=new JLabel("金币"+(jinbi));
                    textFiel.setFont(new Font("宋体", Font.BOLD, 30));
               	 add(textFiel,1);
               	 textFiel.setBounds(500,360,100,100);
               	 textFiel.setVisible(true);
          
               	repaint();
                 	break;}}
                else {
                	JOptionPane.showMessageDialog(null, "对不起，您的金币不足","对不起，您的金币不足", JOptionPane.ERROR_MESSAGE);
                }
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
   
   	ImageIcon image = new ImageIcon("background/choujiangbeijing1.png");
  	 JLabel label = new JLabel();
  	 label.setIcon(image);
  	 label.setBounds(0,0,800,700);
  	 add(label,-1);

    }// </editor-fold>                        
  
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        
    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    // End of variables declaration                   
}
