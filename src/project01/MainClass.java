package project01;

import java.util.Scanner;

public class MainClass {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		TeamsDAO teamsDAO = new TeamsDAO();
		
		teamsDAO.getAllTeam();
		
		System.out.print("조회할 팀 명 > ");
		String name = scan.nextLine();
				
		teamsDAO.getTeamInfo(name);
		
		
	}
}
