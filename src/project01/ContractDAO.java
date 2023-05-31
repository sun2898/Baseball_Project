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
				String yes_no = rs.getString("yes_no");
				
				ContractVO vo = new ContractVO(p_code, p_name, p_position, salary, currTeam, newTeam, down_payment, yes_no);
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

	public int updateContracts(ContractVO vo) {
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "MERGE INTO PLAYERS P\n"
				+ "USING CONTRACTS C\n"
				+ "ON (P.P_CODE = C.P_CODE)\n"
				+ "WHEN MATCHED THEN\n"
				+ "    UPDATE\n"
				+ "    SET P.TEAM_NAME = (SELECT C.NEWTEAM\n"
				+ "                     FROM CONTRACTS C\n"
				+ "                     WHERE  C.P_NAME = P.P_NAME)";
		
		try {
			
			conn = DriverManager.getConnection(url, uid, upw);
			
			pstmt = conn.prepareStatement(sql);
			
			result = pstmt.executeUpdate();
			System.out.println(result);
			
			
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
