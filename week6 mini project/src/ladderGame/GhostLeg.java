package ladderGame;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class GhostLeg {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		ArrayList<String> players = new ArrayList<>();
		HashMap<String, String> finalResult = new HashMap<>();
		
		//입력받기
		System.out.println("참여 인원 수를 입력하세요[2-6명]");
		int playerNo = Integer.parseInt(sc.nextLine());
		if (playerNo<1) {
			System.out.println("최소 참여 인원은 2명입니다.");
			return;
		} else if (playerNo>6) {
			System.out.println("최대 참여 인원은 6명입니다.");
			return;
		}
		for (int i=0; i<playerNo; i++) {
			System.out.println((i+1)+"번째 플레이어의 이름을 입력하세요");
			players.add(sc.nextLine());
		}
		
		String[] results = new String[playerNo];
		for (int i=0; i<playerNo; i++) {
			System.out.println((i+1)+"번째 결과를 입력하세요");
			results[i] = sc.nextLine();
		}
				
		// 사다리 랜덤 선정
		boolean[][] ladder = new boolean[8][playerNo];
		boolean dice = false;
		for (int i=0; i<7; i++) {
			for (int j=0;j<playerNo-1;j++) {
				if (dice=random.nextBoolean()) {
					if (j==0 && (ladder[i][j+1]==false)) {
							ladder[i][j] = true;
					} else if ((j>0&&j<playerNo-2)&&(ladder[i][j-1]==true)||(ladder[i][j+1]==true)){
						ladder[i][j] = false;
					} else if ((j<5 && 0<j) && (ladder[i][j-1]==false)) {
						ladder[i][j] = true;
					} else if ((j>0&&j<playerNo-2)&&(ladder[i][j-1]==false)&&(ladder[i][j+1]==false)) {
						ladder[i][j] = true;
					}
				}			
			}
		}
		
		// 사다리 그리기
		for (int i=0; i<8; i++) {
			for (int j=0; j<playerNo; j++) {
				System.out.print("|");
				if (ladder[i][j]) {
					System.out.print("__");
				} else if (!ladder[i][j]) {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
				
		// 계산하기
		int temp = 0;
			for (int j=0; j<playerNo; j++) {
				for (int i=0; i<8; i++) {
					if (i==7) {
						//System.out.println(temp);
						finalResult.put(players.get(temp), results[j]);
						//System.out.println("final");
						j=temp++;
						continue;
					}
					if (ladder[i][+j]) {
						//System.out.println("오른쪽");
						j++;
						continue;
					} else if (!ladder[i][j]) {
						if (j>0) {
							if (ladder[i][j-1]) {
								j--;
								//System.out.println("왼쪽");
								continue;
							}
						}
						//System.out.println("아래로");
						continue;
					}
				}
				//System.out.println("끝");
			}
		System.out.println(finalResult);
		sc.close();
	}
}
