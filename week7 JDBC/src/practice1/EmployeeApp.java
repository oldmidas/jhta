package practice1;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeApp {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		EmployeeDAO dao = new EmployeeDAO();
		Display display = new Display();
		while(true) {
			System.out.println("============");
			System.out.println("1.사원번호로 검색");
			System.out.println("2.부서번호로 검색");
			System.out.println("3.직업코드로 검색");
			System.out.println("4.월급으로 검색");
			System.out.println("5.부서번호별 평균연봉 검색");
			System.out.println("0.사원번호로 검색");
			System.out.println("============");
			int menu = Integer.parseInt(sc.nextLine());
			
			if (menu == 1) {
				ArrayList<EmployeeVO> employees = new ArrayList<>();
				System.out.println("검색할 사원번호를 입력하세요.");
				int id = Integer.parseInt(sc.nextLine());
				employees = dao.searchByEmployeeID(id);
				display.displayResult(employees);
				
			} else if (menu == 2) {
				ArrayList<EmployeeVO> employees = new ArrayList<>();
				System.out.println("검색할 부서번호를 입력하세요.");
				int id = Integer.parseInt(sc.nextLine());
				employees = dao.searchByDepartmentID(id);
				display.displayResult(employees);
				
			} else if (menu == 3) {
				ArrayList<EmployeeVO> employees = new ArrayList<>();
				System.out.println("검색할 직업코드를 입력하세요.");
				String id = sc.nextLine();
				employees = dao.searchByJobID(id);
				display.displayResult(employees);
				
			} else if (menu == 4) {
				ArrayList<EmployeeVO> employees = new ArrayList<>();
				System.out.println("검색할 최소금액을 입력하세요.");
				int min = Integer.parseInt(sc.nextLine());
				System.out.println("검색할 최대금액을 입력하세요.");
				int max = Integer.parseInt(sc.nextLine());
				employees = dao.searchBySalary(min, max);
				display.displayResult(employees);
				
			} else if (menu == 5) {
				double avg = 0.0;
				System.out.println("검색할 부서코드를 입력하세요.");
				int id = Integer.parseInt(sc.nextLine());
				avg = dao.searchAvgByDepartmentID(id);
				System.out.println("부서번호"+id+" 평균연봉: $" + avg);
				
			} else if (menu == 0) {
				sc.close();
				break;
				
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}	
}
