package project01;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainPage extends JFrame {


   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               MainPage window = new MainPage();
               window.setVisible(true);
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
      setBounds(100, 100, 450, 300);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      getContentPane().setLayout(null);
      
      JPanel panel = new JPanel();
      panel.setBounds(12, 10, 412, 243);
      getContentPane().add(panel);
      panel.setLayout(null);
      
      JButton btn1 = new JButton("선수 정보");
      btn1.setBounds(154, 77, 97, 23);
      panel.add(btn1);
      
      btn1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            GUI2 g2 = new GUI2();
            g2.setVisible(true);
            dispose();
         }
      });
      
   }
}