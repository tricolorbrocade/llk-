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

import net.walsece.game.Maingameshow;
public class guodu1 extends javax.swing.JPanel {
	 Image image=null;
    /**
     * Creates new form guodu1
     */
	JFrame n2=null;
	private JButton play, more, button;
	private ImageIcon imgPlay, imgMore;//��ҳͼƬ��͸� ����ʱ����Play��More��
    public guodu1(JFrame n2) { Maingameshow.level++;
        initComponents();
        this.n2=n2;//ͨ�����캯������֮ǰ�����������
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents()  {
    	jButton1 = new javax.swing.JButton();//��Ӱ�ť
        jButton1.setText("����1");
        add(jButton1);
        more = new javax.swing.JButton();//��Ӱ�ť
        more.setText("����2");
        add(more);
        more.setBounds(225,225,115,115);
        more.setBorderPainted(false);
        play = new JButton();
        add(play);
        play.setText("����1");
        play.setBounds(115,115,115,115);
        play.setBorderPainted(false);
        imgPlay = new ImageIcon("D:\\\\\\\\������\\\\\\\\Pictures\\\\\\\\u=2629648377,3202501847&fm=27&gp.jpg");
		imgMore = new ImageIcon("icons/png-0529.png");
		play.setIcon(imgPlay);
		more.setIcon(imgMore);
    	ImageIcon image = new ImageIcon("D:\\\\������\\\\Pictures\\\\u=2629648377,3202501847&fm=27&gp.jpg");
    	 JLabel label = new JLabel();
    	 label.setIcon(image);
    	 label.setBounds(0,0,500,312);
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
	            Maingameshow p3=new Maingameshow(n2);//�½����guodu12����������n2����
	            setVisible(false);//���ص�ǰ���
	            n2.add(p3);//�ڴ�����������p1
	            n2.setVisible(true);//��ʾ���
	        }
	    });
	    more.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            jButton1ActionPerformed(evt);
	            Maingameshow p3=new Maingameshow(n2);//�½����guodu12����������n2����
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
