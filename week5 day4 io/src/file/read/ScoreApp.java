package file.read;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ScoreApp {
	public static void main(String[] args) throws IOException {
		ArrayList<Score> scoreList = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		FileOutputStream fos = new FileOutputStream("score.txt", false);
															//true일 경우는 덮어쓰기
		
		// 1.성적정보 등록	2. 성적정보 파일로 저장	3.성적순으로 정렬해서 파일저장하기 	0.종료
		while (true) {
			System.out.println("==============================================================");
			System.out.println("1.성적정보 등록  2.성적정보 파일로 저장  3.성적정보를 성적순으로 정렬해서 저장하기 0.종료");
			System.out.println("==============================================================");
			System.out.println("메뉴를 선택하세요>");
			int menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				// 이름,국어,영어,수학점수를 입력받아서 Score객체에 담고 ArrayList에 저장하기.
				
				System.out.println("이름을 입력하세요.");
				String name = sc.nextLine();
				System.out.println("국어점수를 입력하세요.");
				int kor  = Integer.parseInt(sc.nextLine());
				System.out.println("영어점수를 입력하세요.");
				int eng  = Integer.parseInt(sc.nextLine());
				System.out.println("수학점수를 입력하세요.");
				int math  = Integer.parseInt(sc.nextLine());
				// 정보 담기
				scoreList.add(new Score(name, kor, eng, math));
				System.out.println("정보가 등록되었습니다.");
				
			} else if (menu == 2) {
				// ArrayList에 저장된 성적정보를 파일로 기록하기
				// 홍길동^80^60^30
				// 김유신^40^50^70
				for (Score s : scoreList) {
					String temp = s.getName()+"^"+s.getKor()+"^"+s.getEng()+"^"+s.getMath()+System.lineSeparator();
					byte[] bytes = temp.getBytes();
					fos.write(bytes);
				}
				System.out.println("파일 생성 완료");
				
			} else if (menu == 3) {
				Collections.sort(scoreList, (s1, s2) -> -(s1.getAvg() - s2.getAvg()));
				for (Score s : scoreList) {
					String temp = s.getName()+"^"+s.getKor()+"^"+s.getEng()+"^"+s.getMath()+System.lineSeparator();
					byte[] bytes = temp.getBytes();
					fos.write(bytes);
				}
				System.out.println("성적순으로 파일 생성 완료");				
				
			} else if (menu == 0) {
				System.out.println("종료");
				break;
				
			} else {
				System.out.println("번호 잘못누름");
			}
		}
		fos.close();
	}
}
