package login20161212;

import java.util.Scanner;

public class UserApp {
	public static void main(String[] args) throws Exception {
		Functions function = new Functions();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("==================================");
			System.out.println("1.가입 2.로그인 3.로그아웃 4.객체로저장 0.종료");
			System.out.println("==================================");
			System.out.print("메뉴를 선택하세요>");
			int menu = Integer.parseInt(sc.nextLine());
			
			if (menu == 1) {
				System.out.println("이름 : ");
				String name = sc.nextLine();
				System.out.println("아이디 : ");
				String id = sc.nextLine();
				for(User temp : function.userList) {
					if (id.equals(temp.getId())) {
						System.out.println("이미 존재하는 아이디입니다.");
						return;
					}
				}
				System.out.println("비번 : ");
				String pw = sc.nextLine();
				System.out.println("비번재확인 : ");
				String pw2 = sc.nextLine();
				if (!(pw.equals(pw2))) {
					System.out.println("비밀번호를 다르게 입력하셨습니다!");
					return;
				}
				function.register(name, id, pw);
			} else if (menu == 2) {
				System.out.println("아이디 : ");
				String id = sc.nextLine();
				System.out.println("비번 : ");
				String pw = sc.nextLine();
				function.login(id, pw);
				
			} else if (menu == 3) {
				function.logout();
			} else if (menu == 4) {
				function.infoSave();
			} else if (menu == 0) {
				System.out.println("종료합니다.");
				break;
			} else {
				System.out.println("번호를 잘못입력했습니다.");
			}
			
		}
	}
}
