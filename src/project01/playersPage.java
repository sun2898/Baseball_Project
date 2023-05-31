package project01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class playersPage extends JFrame{

	String[] colName = {"선수코드", "소속", "이름", "포지션", "신장", "입단년도", "서브", "블로킹", "리시브", "세트"};
	DefaultTableModel tableModel = new DefaultTableModel(colName, 0);
	JTable table = new JTable(tableModel);
	JScrollPane sp = new JScrollPane(table);
	JPanel jpanel = new JPanel();
	private JTextField textField;
	JTextArea ta = new JTextArea();
	

	
	public playersPage() {
		getContentPane().setLayout(null);
		sp.setBounds(12, 10, 604, 343);
		getContentPane().add(sp);
		
		JButton btnNewButton_4 = new JButton("조회");
		btnNewButton_4.setBounds(628, 173, 135, 45);
		getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_4_1 = new JButton("추가");
		btnNewButton_4_1.setBounds(628, 118, 135, 45);
		getContentPane().add(btnNewButton_4_1);
		
		JButton btnNewButton_4_2 = new JButton("수정");
		btnNewButton_4_2.setBounds(628, 228, 135, 45);
		getContentPane().add(btnNewButton_4_2);
		
		JButton btnNewButton_4_2_1 = new JButton("삭제");
		btnNewButton_4_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
				
				int p_code = Integer.parseInt(textField.getText());
				PlayersDAO dao = new PlayersDAO();
				PlayersVO vo = new PlayersVO();
				dao.deletePlayers(vo);
				
			}
		});
		btnNewButton_4_2_1.setBounds(628, 283, 135, 45);
		getContentPane().add(btnNewButton_4_2_1);
		
		textField = new JTextField();
		textField.setBounds(628, 57, 135, 34);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		
		setSize(800, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		readData();
	}

	public void readData() {
		PlayersDAO dao = new PlayersDAO();
		List<PlayersVO> list = dao.getAllPlayers();

		for (PlayersVO v : list) {
			int p_code = v.getP_code();
			String t_name = v.getTeam_name();
			String name = v.getP_name();
			String position = v.getP_position();
			int height = v.getHeight();
			int score = v.getScore();                
			int join_year = v.getJoin_year();        
			double serve = v.getServe();                
			double blocking = v.getBlocking();          
			double receive = v.getReceive();            
			double p_set = v.getP_set();                

			Object[] str = {p_code, t_name, name, position, height, score, serve, join_year,blocking, receive, p_set};
			tableModel.addRow(str);

		}
	}
}

