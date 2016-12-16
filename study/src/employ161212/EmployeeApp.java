package employ161212;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeApp {
	
	public static void main(String[] args) throws Exception {
		final ArrayList<Employee> employeeList = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("================");
			System.out.println("1.사원등록 2.사원조회");
			System.out.print("================");
			int menu = Integer.parseInt(sc.nextLine());
			
			if (menu == 1) {
				System.out.println("사번을 입력하세요>");
				String no = sc.nextLine();
				System.out.println("이름을 입력하세요>");
				String name = sc.nextLine();
				System.out.print("월급을 입력하세요>");
				int salary = Integer.parseInt(sc.nextLine());
				
				Employee employee = new Employee(no, name, salary);
				
				employeeList.add(employee);
				FileWriter fw = new FileWriter("Employee.txt", true);
				String data = no + "," + name + "," + salary + System.lineSeparator(); 
				fw.write(data);
				
				fw.close();
			} else if (menu == 2) {
				BufferedReader br = new BufferedReader(new FileReader("Employee.txt"));
				String count = null;
				while ((count=br.readLine()) != null) {
					String[] datas = br.readLine().split(",");
					System.out.println("사원번호"+datas[0]);
					System.out.println("이    름"+datas[1]);
					System.out.println("월    급"+datas[2]);
					int salary =  Integer.parseInt(datas[2]);
					int annual = salary*12; 
					System.out.println("연    봉"+annual);
					
				}
				br.close();
			} else {
				System.out.println("번호가 잘못되었습니다.");
			}
		}
	}
}
