package file.character;

import java.io.PrintStream;

public class PrintStreamDemo {
	public static void main(String[] args) throws Exception {
		PrintStream ps = new PrintStream("data.txt");
		ps.println("홍길동,10,20,30");
		ps.println("김유신,50,60,70");
		ps.println("강감찬,70,80,90");
		ps.println("이순신,30,40,50");
		ps.close();
	}
}
