package project01;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainPage {

   private JFrame frame;
 
   Image img = null;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
            	MainPage window = new MainPage();
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the application.
    */
   public MainPage() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      
         
      frame = new JFrame("배구선수 관리 프로그램 - VMP");
      frame.setBackground(new Color(255, 255, 255));
      frame.getContentPane().setFont(new Font("굴림", Font.BOLD, 12));
      frame.setBounds(100, 100, 638, 448);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      
      
      JButton btnNewButton = new JButton("구단관리");
      btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 TeamsPage t1 = new TeamsPage();
        	 
         }
      });
      btnNewButton.setBounds(331, 43, 213, 67);
      frame.getContentPane().add(btnNewButton);
      
      JButton btnNewButton_1 = new JButton("선수관리");
      btnNewButton_1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		playersPage g2 = new playersPage();
      	}
      });
      btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
      
      btnNewButton_1.setBounds(60, 43, 213, 67);
      frame.getContentPane().add(btnNewButton_1);
      
   }
}