package comparator;

import java.util.ArrayList;
import java.util.Collections;

public class FruitApp {
	public static void main(String[] args) {
		ArrayList<Fruit> cart = new ArrayList<>();
		cart.add(new Fruit("사과", "빨강", 1000, 10));
		cart.add(new Fruit("사과", "노랑", 1500, 15));
		cart.add(new Fruit("바나나", "노랑", 2000, 20));
		cart.add(new Fruit("배", "하양", 5000, 30));
		cart.add(new Fruit("토마토", "빨강", 3000, 30));
		cart.add(new Fruit("파인애플", "노랑", 7000, 50));

		/*숫자로 비교하기
		Comparator<Fruit> c = new Comparator<Fruit>() {
			public int compare(Fruit f1, Fruit f2) {
				return f1.getPrice() - f2.getPrice();
			}
		};
		
		Collections.sort(cart, c);
		*/
		
		/*숫자로 비교하기
		Collections.sort(cart, new Comparator<Fruit>() {
			public int compare(Fruit f1, Fruit f2) {
				return f1.getKcal() - f2.getKcal();
			}
		});
		*/
		
		/*문자열로 비교하기
		Collections.sort(cart, new Comparator<Fruit>() {
			public int compare(Fruit f1, Fruit f2) {
				return f1.getName().compareTo(f2.getName());
			}
		});
		*/
		
		/*람다표현식 자바8부터 사용가능하다
		Collections.sort(cart, (Fruit f1, Fruit f2) -> {return f1.getName().compareTo(f2.getName()); });
		//                        ↓매개변수 타입 생략
		Collections.sort(cart, (f1, f2) -> { return f1.getName().compareTo(f2.getName()); });
		*///							    ↓실행문이 하나뿐인 경우 {}는 생략 가능하다, return을 생략하더라도 표현식의 연산결과가 자동으로 반환된다.
		Collections.sort(cart, (f1, f2) -> f1.getName().compareTo(f2.getName()));
		
		/* 람다식의 if문
		Collections.sort(cart, (f1, f2) -> {
			if (f1.getPrice() > f2.getPrice()) {
				return 1;
			} else {
				return 0;
			} });
		*/
		
		System.out.println(cart);

	}
}
