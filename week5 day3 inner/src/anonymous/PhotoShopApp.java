package anonymous;

public class PhotoShopApp {
	public static void main(String[] args) {
		PhotoShop ps = new PhotoShop();

		Pen yellow = new Pen() {
			public void draw() {
				System.out.println("노랑 노랑 노랑");
			}
		};

		ps.painting(yellow);
		
		/*
		 * ps.painting(new Pen());
		 * 
		 * ps.painting(new Pen() {});
		 * 
		 * ps.painting(new Pen() {
		 * 
		 * });
		 * 
		 * ps.painting(new Pen() {
		 * 		public void draw() {
		 * 
		 * 		}
		 * });
		 */
		
		ps.painting(new Pen() {
			public void draw() {
				System.out.println("빨강 빨강 빨강");
			}
		});
		
		//ps.paintring(()-> {}); 람다표현식(람다식에서는 메소드가 1개만 있어야 사용이 가능하다.)
		ps.painting(() -> {System.out.println("파랑 파랑 파랑");});
	}
}
