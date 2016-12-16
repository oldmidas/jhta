package fibonacciSequence;

import java.util.ArrayList;
import java.util.Scanner;

public class FibonacciSequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("보고싶은 피보나치 수열을 입력하세요.[최대45]");
		ArrayList<Integer> nos = new ArrayList<>(); 
		int no = sc.nextInt();

		for (int i=0; i<=no; i++) {
			if (i<2) {
				nos.add(i);
			} else if (i>=2) {
				nos.add(nos.get(i-2)+nos.get(i-1));
			}
		}
		nos.remove(0);
		System.out.println(nos);
		sc.close();
	}
}
