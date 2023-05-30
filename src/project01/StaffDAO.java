package project01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO {

	String url = DBProperties.URL;
	String uid = DBProperties.UID;
	String upw = DBProperties.UPW;
	
	public StaffDAO() {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (Exception e) {
			System.out.println("CLASS FOR NAME ERR");
		}
		
	}
	
	
	public List<StaffVO> getStaffs(String team_name) {
		
		List<StaffVO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM STAFFS WHERE TEAM_NAME = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, team_name);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int s_code = rs.getInt("s_code");
				String t_name = rs.getString("team_name");
				String s_name = rs.getString("s_name");
				String s_position = rs.getString("s_position");
				String task = rs.getString("task");
				
				StaffVO vo = new StaffVO(s_code, t_name, s_name, s_position, task);
			
				list.add(vo);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {

				conn.close();
				pstmt.close();
				rs.close();
				
			} catch (Exception e2) {
			
			}
		}
		return list;
	}
	
	
	public int insertStaffs(StaffVO vo) {
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO STAFFS(S_CODE, TEAM_NAME, S_NAME, S_POSITION, TASK) VALUES(STAFFS_SEQ.NEXTVAL, ?, ?, ?, ?)";
		
		try {
			
			conn = DriverManager.getConnection(url, uid, upw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTeam_name());
			pstmt.setString(2, vo.getS_name());
			pstmt.setString(3, vo.getS_position());
			pstmt.setString(4, vo.getTask());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				
			}
		}
		return result;
	}
	
	
	public int updateStaffs(StaffVO vo) {
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE STAFFS\r\n"
				+ "SET TEAM_NAME = ?,\r\n"
				+ "    S_NAME = ?,\r\n"
				+ "    S_POSITION = ?,\r\n"
				+ "    TASK = ?\r\n"
				+ "WHERE S_CODE = ?"; //컬럼 추가 건의할 것
		
		try {
			
			conn = DriverManager.getConnection(url, uid, upw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTeam_name());
			pstmt.setString(2, vo.getS_name());
			pstmt.setString(3, vo.getS_position());
			pstmt.setString(4, vo.getTask());
			pstmt.setInt(5, vo.getS_code()); //생성자, getter/setter만들 것
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();				
			} catch (Exception e2) {
				
			}
		}
		return result;
	
	}
	
	
	public int deleteStaffs(StaffVO vo) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM STAFFS WHERE S_CODE = ?";
				
		try {
			
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getS_code());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {	
				conn.close();
				pstmt.close();
			} catch (Exception e) {
				
			}
		}
		
		return result;
	}
	
	
	
}
