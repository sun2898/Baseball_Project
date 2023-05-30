package project01;

import java.util.List;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		PlayersDAO players  = new PlayersDAO();
		
		List<PlayersVO> list = players.getPlayers("알토스"); 
		System.out.println(list.toString());
		
		//업데이트
//		System.out.print("선수 코드>");
//		int code = scan.nextInt();
//		System.out.print("득점>");
//		int score = scan.nextInt();
//		System.out.print("서브>");
//		double serve = scan.nextDouble();
//		System.out.print("블로킹>");
//		double blocking = scan.nextDouble();
//		System.out.print("리시브>");
//		double receive = scan.nextDouble();
//		System.out.print("세트>");
//		double set = scan.nextDouble();
//		System.out.print("팀명>");
//		String team_name = scan.next();
//		
//		PlayersVO vou = new PlayersVO(code, score, serve, blocking, receive, set, team_name);
//		String result = players.updatePlayers(vou);
//		System.out.println(result);
		
		
		
		//삭제
//		System.out.print("선수 코드>");
//		int code = scan.nextInt();
//		PlayersVO vod = new PlayersVO(code);
//		String result = players.deletePlayers(vod);
//		System.out.println(result);
		
		
		//등록
//		System.out.print("선수코드>");
//		int code = scan.nextInt();
//		System.out.print("이름>");
//		String name = scan.next();
//		System.out.print("포지션>");
//		String position = scan.next();
//		System.out.print("키>");
//		int height = scan.nextInt();
//		System.out.print("득점>");
//		int score = scan.nextInt();
//		System.out.print("가입년도>");
//		int join_year = scan.nextInt();
//		System.out.print("서브>");
//		double serve = scan.nextDouble();
//		System.out.print("블로킹>");
//		double blocking = scan.nextDouble();
//		System.out.print("리시브>");
//		double receive = scan.nextDouble();
//		System.out.print("세트>");
//		double set = scan.nextDouble();
//		System.out.print("소속팀>");
//		String team_name = scan.next();
//		
//		
//		PlayersVO vo = new PlayersVO(code, name, position, height, score, join_year, serve, blocking, receive, set, team_name);
//		
//		String result = players.insertPlayers(vo);
//		System.out.println(result);
		
		
		
		
		
	}
}
