package student_manager;

import java.util.Scanner;

public class RegisterStudent {
	
	public StudentVO studentRegister(Scanner sc) {
		
		System.out.println("이름을 입력하세요");
		String name = sc.nextLine();
		System.out.println("전공을 입력하세요");
		String major = sc.nextLine();
		System.out.println("학년을 입력하세요");
		int grade = Integer.parseInt(sc.nextLine());
		System.out.println("연락처를 입력하세요");
		String phone = sc.nextLine();
		System.out.println("아이디를 입력하세요");
		String id = sc.nextLine();
		System.out.println("비밀번호를 입력하세요");
		String password = sc.nextLine();
			
		return new StudentVO(name, major, grade, phone, id, password);
	}
}
