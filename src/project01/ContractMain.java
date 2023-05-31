package project01;

import java.util.List;
import java.util.Scanner;

public class ContractMain {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		ContractDAO contractDAO = new ContractDAO();
		
		while(true) {
			
			System.out.println("[1.조회, 2.결과]");
			System.out.print("메뉴선택>");
			
			int menu = scan.nextInt();
			
			if(menu == 1) {
				
				List<ContractVO> list = contractDAO.getContracts();
				//System.out.println(list.toString());
				for(ContractVO vo : list) {
					System.out.println(vo.getP_code());
					System.out.println(vo.getP_name());
					System.out.println(vo.getP_position());
					System.out.println(vo.getSalary());
					System.out.println(vo.getCurrTeam());
					System.out.println(vo.getNewTeam());
					System.out.println(vo.getDown_payment());
					System.out.println(vo.getYn());
				}
				
				
			} else if(menu == 2) {
				
				ContractVO vo = new ContractVO();
				
				int result = contractDAO.updateContracts(vo);
				
				System.out.println("성공실패?>" + result);
				
			}
			
			
		}
		
		
		
		
	}
	
	
	
}
