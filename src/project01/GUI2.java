package project01;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GUI2 extends JFrame{
   
   String[] colName = { "이름", "포지션", "신장", "소속" };
   DefaultTableModel tableModel = new DefaultTableModel(colName, 0);
   JTable table = new JTable(tableModel);
   JScrollPane sp = new JScrollPane(table);
   
   
   public GUI2() {
      super("선수목록");
      add(sp, "Center");
      setSize(400, 500);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   public static void main(String[] args) {

      PlayersDAO dao = new PlayersDAO();
      GUI2 m = new GUI2();
      List<PlayersVO> list = dao.getAllPlayers();

      for (PlayersVO v : list) {
         String name = v.getP_name();
         String position = v.getP_position();
         int height = v.getHeight();
         String t_name = v.getTeam_name();
         
         Object[] str = {name, position, height, t_name};
         m.tableModel.addRow(str);
      }
   }
   
   
   
}
