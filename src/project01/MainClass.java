package project01;

import java.util.List;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		PlayersDAO players  = new PlayersDAO();
		
		List<PlayersVO> list = players.getPlayers(180); 
		System.out.println(list.toString());
	}
}
