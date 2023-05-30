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
	
	public List<PlayersVO> getPlayers(String name){
		List<PlayersVO> list = new ArrayList<>();
		
		String sql = "select * from players where team_name = ? ";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
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

		
	public String insertPlayers(PlayersVO vo) {
		int result = 0;
		String str = "";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into players values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getP_code());
			pstmt.setString(2, vo.getP_name());
			pstmt.setString(3, vo.getP_position());
			pstmt.setInt(4, vo.getHeight());
			pstmt.setInt(5, vo.getScore());
			pstmt.setInt(6, vo.getJoin_year());
			pstmt.setDouble(7, vo.getServe());
			pstmt.setDouble(8, vo.getBlocking());
			pstmt.setDouble(9, vo.getReceive());
			pstmt.setDouble(10, vo.getP_set());
			pstmt.setString(11, vo.getTeam_name());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		if(result == 0) {
			str = "오류, 다시 입력하세요";
		} else if(result == 1) {
			str = "등록되었습니다.";
		}
		
		
		return str;
	}
	
	public String deletePlayers(PlayersVO vo) {
		int result = 0;
		String str = "";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from players where p_code = ?";
		
		try {
			
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getP_code());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		if(result == 0) {
			str = "오류, 다시 입력하세요";
		} else if(result == 1) {
			str = "삭제하였습니다.";
		}
		
		
		return str;
	}

	public String updatePlayers(PlayersVO vo) {
		int result = 0;
		String str = "";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update players \r\n"
				+ "set score = ?,\r\n"
				+ "    serve = ?,\r\n"
				+ "    blocking = ?,\r\n"
				+ "    receive = ?,\r\n"
				+ "    p_set = ?,\r\n"
				+ "    team_name =?\r\n"
				+ "where p_code = ?";
		
		try {
			
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getScore());
			pstmt.setDouble(2, vo.getServe());
			pstmt.setDouble(3, vo.getBlocking());
			pstmt.setDouble(4, vo.getReceive());
			pstmt.setDouble(5, vo.getP_set());
			pstmt.setString(6, vo.getTeam_name());
			pstmt.setInt(7, vo.getP_code());
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		if(result == 0) {
			str = "오류, 다시 입력하세요";
		} else if(result == 1) {
			str = "업데이트 완료";
		}
		
		return str;
	}

	
}
