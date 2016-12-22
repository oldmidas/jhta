package movingLetter;

import java.util.Scanner;

public class MovingLetter {
	/*
	 * A B C D				E A B C
	 * E F G H		->		I G K D
	 * I J K L				M F O H
	 * M N O P				N J P L
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[][] letters =  {	{"A", "B", "C", "D"},
								{"E", "F", "G", "H"},
								{"I", "J", "K", "L"},
								{"M", "N", "O", "P"} };
		String temp = null;
		String enter = null;
		while (true) {
			for (int i=0; i<4; i++) {
				for (int k=0; k<4; k++) {
					System.out.print(letters[i][k] + " ");
				}
				System.out.println();
			}
			System.out.println("엔터를 누르면 이동합니다.");
			enter = sc.nextLine();
			
			temp = letters[0][0];
			letters[0][0] = letters[1][0];
			letters[1][0] = letters[2][0];
			letters[2][0] = letters[3][0];
			letters[3][0] = letters[3][1];
			letters[3][1] = letters[3][2];
			letters[3][2] = letters[3][3];
			letters[3][3] = letters[2][3];
			letters[2][3] = letters[1][3];
			letters[1][3] = letters[0][3];
			letters[0][3] = letters[0][2];
			letters[0][2] = letters[0][1];
			letters[0][1] = temp;
			temp = letters[1][1];
			letters[1][1] = letters[1][2];
			letters[1][2] = letters[2][2];
			letters[2][2] = letters[2][1];
			letters[2][1] = temp;
			
		}
	}
	 
}
