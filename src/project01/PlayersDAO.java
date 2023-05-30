package project01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayersDAO {

	//멤버변수
	private String url = DBProperties.URL;
	private String uid = DBProperties.UID;
	private String upw = DBProperties.UPW;
		
	public PlayersDAO()	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public List<PlayersVO> getPlayers(int height01){
		List<PlayersVO> list = new ArrayList<>();
		
		String sql = "select * from players where height > ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, height01);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int p_code = rs.getInt("p_code");
				String p_name = rs.getString("p_name");
				String p_position = rs.getString("p_position");
				int height = rs.getInt("height");
				int score = rs.getInt("score");
				int join_year = rs.getInt("join_year");
				int serve = rs.getInt("serve");
				int blocking = rs.getInt("blocking");
				int receive = rs.getInt("receive");
				int p_set = rs.getInt("p_set");
				String team_name = rs.getString("team_name");
				
				PlayersVO vo = new PlayersVO(p_code, p_name, p_position, height, score, join_year, serve, blocking, receive, p_set, team_name);
				
				list.add(vo);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				conn.clearWarnings();
				pstmt.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
		}
		
		
		
		
		
		return list;
	}
		
	
}
