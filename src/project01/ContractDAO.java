package project01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContractDAO {

	String url = DBProperties.URL;
	String uid = DBProperties.UID;
	String upw = DBProperties.UPW;
	
	public ContractDAO() {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (Exception e) {
			System.out.println("CLASS FOR NAME ERR");
		}	
	}
	
	public List<ContractVO> getContracts() {
		
		List<ContractVO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM CONTRACTS";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int p_code = rs.getInt("p_code");
				String p_name = rs.getString("p_name");
				String p_position = rs.getString("p_position");
				int salary = rs.getInt("salary");
				String currTeam = rs.getString("currteam");
				String newTeam = rs.getString("newTeam");
				int down_payment = rs.getInt("down_payment");
				String yn = rs.getString("yn");
				
				ContractVO vo = new ContractVO(p_code, p_name, p_position, salary, currTeam, newTeam, down_payment, yn);
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

	public int insertContracts(ContractVO vo) {
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO PLAYERS VALUES(PLAYERS_SEQ.NEXTVAL, P_NAME, P_POSITION, HEIGHT, SCORE, JOIN_YEAR, SERVE, BLOCKING, RECEIVE, P_SET, NEWTEAM)";
		
		try {
			
			conn = DriverManager.getConnection(url, uid, upw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getP_name());
			pstmt.setString(2, vo.getP_position());
			pstmt.setInt(3, vo.getHeight());
			pstmt.setInt(4, vo.getScore());
			pstmt.setInt(5, vo.getJoin_year());
			pstmt.setDouble(6, vo.getServe());
			pstmt.setDouble(7, vo.getBlocking());
			pstmt.setDouble(8, vo.getReceive());
			pstmt.setDouble(9, vo.getP_set());
			pstmt.setString(10, vo.getTeam_name());
			
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

	public int deleteContracts(ContractVO vo) {
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM PLAYERS WHERE P_CODE = ?";
		
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
				
			}
			
		}
		return result;
		
	}
	
	
	
	
	
	
	
	
	
}
