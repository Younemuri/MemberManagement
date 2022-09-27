package member;

import java.util.Scanner;

public class Menu {
	Scanner sc = new Scanner(System.in);
	
	private int number;
	
	SignUp signup = new SignUp();
	Search search = new Search();
	Delete delete = new Delete();
	
	public void selectNumber() {
		System.out.println("회원관리 프로그램");
		
		while(true) {
			System.out.println("1. 회원 가입 | 2. 회원 목록 | 3. 회원 삭제 | 4. 종료");
			System.out.print(">>");
			number = sc.nextInt();
			
			if(number == 1) {
				signup.insert_sql();
			} else if(number == 2) {
				search.search_sql();
			} else if(number == 3) {
				delete.delete_sql();
			} else if(number == 4) {
				break;
			} else {
				System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
			}
		}
	}
}
