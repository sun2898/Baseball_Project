package project01;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TeamsPage extends JFrame{

	String[] colName = {"팀이름", "구단주", "감독", "주장", "연고지", "모기업"};
	DefaultTableModel tableModel = new DefaultTableModel(colName, 0);
	JTable table = new JTable(tableModel);
	JScrollPane sp = new JScrollPane(table);
	JPanel jpanel = new JPanel();

	/**
	 * Create the application.
	 */
	public TeamsPage() {
		getContentPane().setLayout(null);
		sp.setBounds(12, 10, 604, 343);
		getContentPane().add(sp);
		
		
		setSize(800, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		readData();
	}
	
	
	public void readData() {
		TeamsDAO dao = new TeamsDAO();
		List<TeamsVO> list = dao.getAllTeamInfo();

		for (TeamsVO v : list) {
			String team_name = v.getTeam_name();
			String owner = v.getOwner();
			String director = v.getDirector();
			String team_leader = v.getTeam_leader();
			String region = v.getRegion();
			String sponser = v.getSponser();               

			Object[] str = {team_name, owner, director, team_leader, region, sponser};
			tableModel.addRow(str);

}
	}
}
