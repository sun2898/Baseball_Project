package project01;

import java.util.Scanner;

public class TeamsMainClass {

	public static void main(String[] args) {
					
			Scanner scan = new Scanner(System.in);
			
			TeamsDAO teamsDAO = new TeamsDAO();
			
			PlayersDAO playersDAO = new PlayersDAO();
			
			playersDAO.getAllPlayers();
			
			while(true) {
				
				System.out.println("[1. 팀 목록, 2. 팀 상세정보, 3. 선발명단]");
				System.out.print("메뉴> ");
				
				int menu = scan.nextInt();
				
				if(menu == 1) {
					//부서명으로 조회
					teamsDAO.getAllTeam();
					
				} else if(menu == 2) {
					System.out.print("팀명을 입력하세요> ");
					String name = scan.next();
					teamsDAO.getTeamInfo(name);
										
				} else if(menu == 3) {
					teamsDAO.getEntry();
				}
				
			}
	
			
	}
	
}
