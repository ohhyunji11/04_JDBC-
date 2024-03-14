package edu.kh.jdbc.run;

import java.util.Scanner;

public class Run4 {
	
	public static void main(String[] args) {
		
		// 삭제할 번호를 입력받아
		// 번호와 일치하는 행 삭제
		
		// 삭제 성공 시 -> 삭제 되었습니다.
		// 삭제 실패 시 -> 일치하는 번호 없음
		// 예외 발생 시 -> 삭제 중 예외 발생..
		
		Scanner sc = new Scanner(System.in);
		
		TestService service = new TestService();
		
		try {
			
			System.out.println("삭제할 번호 입력 : ");
			int testNo = sc.nextInt();
			
			int result = service.delete(testNo);
			
			
			
			
			
			
		} catch (Exception e) {
			System.out.println("삭제 중 예외 발생");
			e.printStackTrace();
		}
		
	
		

}
