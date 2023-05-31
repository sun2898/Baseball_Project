package project01;

import java.util.List;
import java.util.Scanner;

public class StaffMain {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		StaffDAO staffDAO = new StaffDAO();
		
		while(true) {
			
			System.out.println("[1. 팀정보, 2. 스태프정보, 3.선수정보]");
			System.out.print("메뉴선택>");
			
			int menu = scan.nextInt();
			
			switch (menu) {
			case 1: System.out.println("준비중입니다.");
					
				break;
			case 2:
				
				System.out.println("[1. 조회, 2. 추가, 3. 변경, 4. 삭제]");
				System.out.print("메뉴선택>");
				
				int staffMenu = scan.nextInt();
				
				if(staffMenu == 1) {
					
					List<StaffVO> list = staffDAO.getStaffs("핑크스파이더스");
					for(StaffVO vo : list) {
						System.out.println(vo.getTeam_name());
						System.out.println(vo.getS_code());
						System.out.println(vo.getS_name());
						System.out.println(vo.getS_position());
						System.out.println(vo.getTask());
						System.out.println("===================================");
					}
					//System.out.println(list.toString());
					
				} else if(staffMenu == 2) { 
					
					System.out.print("팀명>");
					String team_name = scan.next();
					
					System.out.print("이름>");
					String s_name = scan.next();
					
					System.out.print("직책>");
					String s_position = scan.next();
					
					System.out.print("담당업무>");
					String task = scan.next();
					
					StaffVO vo = new StaffVO(team_name, s_name, s_position, task);
					
					int result = staffDAO.insertStaffs(vo);
					
					System.out.println("성공실패?" + result);
							
				} else if(staffMenu == 3) {
					
					System.out.print("팀명>");
					String team_name = scan.next();
					
					System.out.println("이름>");
					String s_name = scan.next();
					
					System.out.println("직책>");
					String s_position = scan.next();
					
					System.out.println("담당업무>");
					String task = scan.next();
					
					System.out.println("직원코드>");
					int s_code = scan.nextInt();
					
					StaffVO vo = new StaffVO(s_code, team_name, s_name, s_position, task);
					
					int result = staffDAO.updateStaffs(vo);
					
					System.out.println("성공실패?" + result);
			
				} else if(staffMenu == 4) {
					
					System.out.println("사원코드>");
					int s_code = scan.nextInt();
					
					StaffVO vo = new StaffVO(s_code);
					
					int result = staffDAO.deleteStaffs(vo);
					System.out.println("성공실패?" + result);
					
				}
				
				break;
			case 3:
				
				
				
				break;

			default:
				break;
			}
			
		}
		
	}

	
	
}
