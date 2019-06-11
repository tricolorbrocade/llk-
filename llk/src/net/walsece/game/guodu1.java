package net.walsece.game;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.walsece.game.Maingameshow;
public class guodu1 extends javax.swing.JPanel {
	 Image image=null;
    /**
     * Creates new form guodu1
     */
	JFrame n2=null;
	JLabel textFiel=null;
	private JButton play, more, button;
	private ImageIcon imgPlay, imgMore;//首页图片宽和高 和临时变量Play键More键
    public guodu1(JFrame n2) { Maingameshow.level++;
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
        more.setText("测试2");
        add(more);
        more.setBounds(300,500,145,75);;
        more.setBorderPainted(false);
        play = new JButton();
        add(play);
        play.setText("测试1");
        play.setBounds(300,400,145,75);
        play.setBorderPainted(false);
        imgPlay = new ImageIcon("button/next.png");
		imgMore = new ImageIcon("button/back.png");
		play.setIcon(imgPlay);
		more.setIcon(imgMore);
		textFiel=new JLabel("金币"+(++choujiang.jinbi));
        textFiel.setFont(new Font("宋体", Font.BOLD, 30));
   	 add(textFiel,1);
   	 textFiel.setBounds(500,360,100,100);
   	 textFiel.setVisible(true);
    	ImageIcon image = new ImageIcon("background/xiayiguan.png");
    	 JLabel label = new JLabel();
    	 label.setIcon(image);
    	 label.setBounds(0,0,800,760);
    	 add(label);
    	 more.requestFocus();
    	 play.requestFocus();

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
  	 play.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            jButton1ActionPerformed(evt);
	            Maingameshow p3=new Maingameshow(n2);//新建面板guodu12，并将窗口n2传入
	            setVisible(false);//隐藏当前面板
	            n2.add(p3);//在窗口中添加面板p1
	            n2.setVisible(true);//显示面板
	        }
	    });
	    more.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            jButton1ActionPerformed(evt);
	            NewJPanel p3=new NewJPanel(n2);//新建面板failed2，并将窗口n2传入
	            setVisible(false);//隐藏当前面板
	            n2.add(p3);//在窗口中添加面板p1
	            n2.setVisible(true);//显示面板
	        }
	    });
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        
    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    // End of variables declaration        
    
}
