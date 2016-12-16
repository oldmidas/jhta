package ladderGame;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Random;

public class LadderGame {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
		while(true) {
			ArrayList<String> players = new ArrayList<>();
			ArrayList<String> results = new ArrayList<>();
			System.out.println("======사 다 리 게 임======");
			System.out.println("참여할 인원수를 입력하세요[2-8명]");
			int playerNo = Integer.parseInt(sc.nextLine());
			if (playerNo < 2) {
				System.out.println("최소인원은 2명입니다.");
				return;
			} else if (playerNo > 8) {
				System.out.println("최대인원은 8명입니다.");
				return;
			}
			
			for(int i = 0; i<playerNo; i++) {
				System.out.println((i+1) + "번 플레이어의 이름을 입력하세요.");
				players.add(sc.nextLine());
			}

			for(int i = 0; i<playerNo; i++) {
				System.out.println((i+1) + "번째 결과를 입력하세요.");
				results.add(sc.nextLine());
			}

			System.out.println("계 산 중 띠릿 띠릿..");
			
			Thread.sleep(2000);
//			boolean clock = false;
//			Date now = new Date();
//			long time = now.getTime() + 1000;
//			while (!clock) {
//				Date now2 = new Date();
//				long time2 = now2.getTime();
//				if (time == time2) {
//					clock = true;
//				}
//			}
			
			int i = 0;
			while (!results.isEmpty()) {
				int a = random.nextInt(results.size());
				if (!results.isEmpty()) {
					System.out.println(players.get(i++) + "님 ====> " + results.get(a));
					results.remove(a);
				}				
			}
		}
	}
}
