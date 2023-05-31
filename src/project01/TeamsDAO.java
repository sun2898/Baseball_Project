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

	public List<PlayersVO> getMB () {
		List<PlayersVO> list = new ArrayList<>();
		
		String sql = "SELECT *\r\n"
				+ "FROM (SELECT P_POSITION, \r\n"
				+ "             P_NAME,\r\n"
				+ "             HEIGHT, \r\n"
				+ "             SERVE, \r\n"
				+ "             BLOCKING, \r\n"
				+ "             RECEIVE, \r\n"
				+ "             TEAM_NAME, \r\n"
				+ "             RANK() OVER (ORDER BY BLOCKING DESC) AS BLOCKING_RANK\r\n"
				+ "       FROM PLAYERS\r\n"
				+ "       WHERE P_POSITION = 'MB'\r\n"
				+ "       )\r\n"
				+ "WHERE BLOCKING_RANK <= 2\r\n"
				+ "ORDER BY BLOCKING_RANK";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String p_position = rs.getString("p_position");
				String p_name = rs.getString("p_name");
				int height = rs.getInt("height");
				double serve = rs.getDouble("serve");
				double blocking = rs.getDouble("blocking");
				double receive = rs.getDouble("receive");
				String team_name = rs.getString("team_name");
				
				PlayersVO vo = new PlayersVO();
				vo.setP_position(p_position);
				vo.setP_name(p_name);
				vo.setHeight(height);
				vo.setServe(serve);
				vo.setBlocking(blocking);
				vo.setReceive(receive);
				vo.setTeam_name(team_name);
				
				list.add(vo);
				
				System.out.println("[" + vo.getP_position() + "] " + vo.getP_name() + 
						" | 선수명: " + vo.getP_name() + " | 신장 : " + vo.getHeight() + 
						" | 서브 : " + vo.getServe() + " | 블로킹 : " + vo.getBlocking() + 
						" | 수비 : " + vo.getReceive() + " | 소속팀 : " + vo.getTeam_name());
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

	public List<PlayersVO> getOP () {
		List<PlayersVO> list = new ArrayList<>();
		
		String sql = "SELECT *\r\n"
				+ "FROM (SELECT P_POSITION, \r\n"
				+ "             P_NAME,\r\n"
				+ "             HEIGHT, \r\n"
				+ "             SERVE, \r\n"
				+ "             BLOCKING, \r\n"
				+ "             RECEIVE, \r\n"
				+ "             TEAM_NAME, \r\n"
				+ "             RANK() OVER (ORDER BY RECEIVE DESC) AS RANK\r\n"
				+ "       FROM PLAYERS\r\n"
				+ "       WHERE P_POSITION = 'OP'\r\n"
				+ "       )\r\n"
				+ "WHERE RANK = 1";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String p_position = rs.getString("p_position");
				String p_name = rs.getString("p_name");
				int height = rs.getInt("height");
				double serve = rs.getDouble("serve");
				double blocking = rs.getDouble("blocking");
				double receive = rs.getDouble("receive");
				String team_name = rs.getString("team_name");
				
				PlayersVO vo = new PlayersVO();
				vo.setP_position(p_position);
				vo.setP_name(p_name);
				vo.setHeight(height);
				vo.setServe(serve);
				vo.setBlocking(blocking);
				vo.setReceive(receive);
				vo.setTeam_name(team_name);
				
				list.add(vo);
				
				System.out.println("[" + vo.getP_position() + "] " + vo.getP_name() + 
						" | 선수명: " + vo.getP_name() + " | 신장 : " + vo.getHeight() + 
						" | 서브 : " + vo.getServe() + " | 블로킹 : " + vo.getBlocking() + 
						" | 수비 : " + vo.getReceive() + " | 소속팀 : " + vo.getTeam_name());
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
	
	public List<PlayersVO> getOH () {
		List<PlayersVO> list = new ArrayList<>();
		
		String sql = "SELECT *\r\n"
				+ "FROM (SELECT P_POSITION, \r\n"
				+ "             P_NAME,\r\n"
				+ "             HEIGHT, \r\n"
				+ "             SERVE, \r\n"
				+ "             BLOCKING, \r\n"
				+ "             RECEIVE, \r\n"
				+ "             TEAM_NAME,\r\n"
				+ "             RANK() OVER (ORDER BY SERVE + BLOCKING + RECEIVE DESC) AS RANK\r\n"
				+ "       FROM PLAYERS\r\n"
				+ "       WHERE P_POSITION = 'OH'\r\n"
				+ "       )\r\n"
				+ "WHERE RANK <= 2";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String p_position = rs.getString("p_position");
				String p_name = rs.getString("p_name");
				int height = rs.getInt("height");
				double serve = rs.getDouble("serve");
				double blocking = rs.getDouble("blocking");
				double receive = rs.getDouble("receive");
				String team_name = rs.getString("team_name");
				
				PlayersVO vo = new PlayersVO();
				vo.setP_position(p_position);
				vo.setP_name(p_name);
				vo.setHeight(height);
				vo.setServe(serve);
				vo.setBlocking(blocking);
				vo.setReceive(receive);
				vo.setTeam_name(team_name);
				
				list.add(vo);
				
				System.out.println("[" + vo.getP_position() + "] " + vo.getP_name() + 
						" | 선수명: " + vo.getP_name() + " | 신장 : " + vo.getHeight() + 
						" | 서브 : " + vo.getServe() + " | 블로킹 : " + vo.getBlocking() + 
						" | 수비 : " + vo.getReceive() + " | 소속팀 : " + vo.getTeam_name());
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

	public List<PlayersVO> getS () {
		List<PlayersVO> list = new ArrayList<>();
		
		String sql = "SELECT *\r\n"
				+ "FROM (SELECT P_POSITION, \r\n"
				+ "             P_NAME,\r\n"
				+ "             HEIGHT, \r\n"
				+ "             SERVE, \r\n"
				+ "             BLOCKING, \r\n"
				+ "             RECEIVE, \r\n"
				+ "             TEAM_NAME,\r\n"
				+ "             RANK() OVER (ORDER BY SERVE DESC) AS RANK\r\n"
				+ "       FROM PLAYERS\r\n"
				+ "       WHERE P_POSITION = 'S'\r\n"
				+ "       )\r\n"
				+ "WHERE RANK = 1";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String p_position = rs.getString("p_position");
				String p_name = rs.getString("p_name");
				int height = rs.getInt("height");
				double serve = rs.getDouble("serve");
				double blocking = rs.getDouble("blocking");
				double receive = rs.getDouble("receive");
				String team_name = rs.getString("team_name");
				
				PlayersVO vo = new PlayersVO();
				vo.setP_position(p_position);
				vo.setP_name(p_name);
				vo.setHeight(height);
				vo.setServe(serve);
				vo.setBlocking(blocking);
				vo.setReceive(receive);
				vo.setTeam_name(team_name);
				
				list.add(vo);
				
				System.out.println("[" + vo.getP_position() + "] " + vo.getP_name() + 
						" | 선수명: " + vo.getP_name() + " | 신장 : " + vo.getHeight() + 
						" | 서브 : " + vo.getServe() + " | 블로킹 : " + vo.getBlocking() + 
						" | 수비 : " + vo.getReceive() + " | 소속팀 : " + vo.getTeam_name());
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
	
	public List<PlayersVO> getL () {
		List<PlayersVO> list = new ArrayList<>();
		
		String sql = "SELECT *\r\n"
				+ "FROM (SELECT P_POSITION, \r\n"
				+ "             P_NAME,\r\n"
				+ "             HEIGHT, \r\n"
				+ "             SERVE, \r\n"
				+ "             BLOCKING, \r\n"
				+ "             RECEIVE, \r\n"
				+ "             TEAM_NAME,\r\n"
				+ "             RANK() OVER (ORDER BY SERVE + BLOCKING + RECEIVE DESC) AS RANK\r\n"
				+ "       FROM PLAYERS\r\n"
				+ "       WHERE P_POSITION = 'L'\r\n"
				+ "       )\r\n"
				+ "WHERE RANK = 1";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String p_position = rs.getString("p_position");
				String p_name = rs.getString("p_name");
				int height = rs.getInt("height");
				double serve = rs.getDouble("serve");
				double blocking = rs.getDouble("blocking");
				double receive = rs.getDouble("receive");
				String team_name = rs.getString("team_name");
				
				PlayersVO vo = new PlayersVO();
				vo.setP_position(p_position);
				vo.setP_name(p_name);
				vo.setHeight(height);
				vo.setServe(serve);
				vo.setBlocking(blocking);
				vo.setReceive(receive);
				vo.setTeam_name(team_name);
				
				list.add(vo);
				
				System.out.println("[" + vo.getP_position() + "] " + vo.getP_name() + 
						" | 선수명: " + vo.getP_name() + " | 신장 : " + vo.getHeight() + 
						" | 서브 : " + vo.getServe() + " | 블로킹 : " + vo.getBlocking() + 
						" | 수비 : " + vo.getReceive() + " | 소속팀 : " + vo.getTeam_name());
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

	public void getEntry () {

		
		System.out.println("==선발명단=======================================================================================");
		getMB();
		getOP();
		getOH();
		getS();
		getL();
		System.out.println("===============================================================================================");
	}
	
public List<TeamsVO> getAllTeamInfo () {
		
		List<TeamsVO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM TEAMS";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
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

