package net.walsece.game;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
import net.walsece.game.NewJPanel;
public class failed extends javax.swing.JPanel 
	{
	 Image image=null;
    /**
     * Creates new form failed
     */
	JFrame n2=null;
	private JButton play, more, button;
	private ImageIcon imgPlay, imgMore;//��ҳͼƬ��͸� ����ʱ����Play��More��
    public failed(JFrame n2) { Maingameshow.level=1;
        initComponents();
        this.n2=n2;//ͨ�����캯������֮ǰ�����������
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents()  {
    	jButton1 = new javax.swing.JButton();//��Ӱ�ť
        jButton1.setText("����1");
        add(jButton1);
        play = new JButton();
        add(play);
       
        play.setBounds(500,500,145,75);
        play.setBorderPainted(false);
        imgPlay = new ImageIcon("button/back.png");
	
		play.setIcon(imgPlay);
    	ImageIcon image = new ImageIcon("background/GAMEOVER.png");
    	 JLabel label = new JLabel();
    	 label.setIcon(image);
    	 label.setBounds(0,0,800,700);
    	 add(label);

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
	            NewJPanel p3=new NewJPanel(n2);//�½����failed2����������n2����
	            setVisible(false);//���ص�ǰ���
	            n2.add(p3);//�ڴ�����������p1
	            n2.setVisible(true);//��ʾ���
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
