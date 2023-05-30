package project01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TeamsDAO {

	private String url = DBProperties.URL;
	private String uid = DBProperties.UID;
	private String upw = DBProperties.UPW;
	
	public TeamsDAO() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("CLASS FOR NAME ERR");
		}	
	}
	
	public List<TeamsVO> getAllTeam () {
		List<TeamsVO> list = new ArrayList<>();
		
		String sql = "SELECT TEAM_NAME FROM TEAMS";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String team_name = rs.getString("team_name");
				
				TeamsVO vo = new TeamsVO();
				vo.setTeam_name(team_name);
				
				list.add(vo);
				
				System.out.println("팀 : " + vo.getTeam_name());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		return list;
	}

	public List<TeamsVO> getTeamInfo (String name) {
		
		List<TeamsVO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM TEAMS WHERE TEAM_NAME = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			String team_name = rs.getString("team_name");
			String owner = rs.getString("owner");
			String director = rs.getString("director");
			String team_leader = rs.getString("team_leader");
			String region = rs.getString("region");
			String sponser = rs.getString("sponser");
			
			TeamsVO vo = new TeamsVO(team_name, owner, director, team_leader, region, sponser);
			list.add(vo);
			
			System.out.println("================================");
			System.out.println("팀 : " + vo.getTeam_name());
			System.out.println("구단주 : " + vo.getOwner());
			System.out.println("감독 : " + vo.getDirector());
			System.out.println("주장 : " + vo.getTeam_leader());
			System.out.println("연고지 : " + vo.getRegion());
			System.out.println("모기업 : " + vo.getSponser());
			System.out.println("================================");
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		return list;
	}

	
	
}
