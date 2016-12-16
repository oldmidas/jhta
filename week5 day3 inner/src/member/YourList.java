package member;

import java.util.Iterator;

public class YourList {
	private int x;
	
	private String[] names = {"홍길동", "김유신", "강감찬", "이순신"};
	
	public Iterator<String> iterator() {
		// 메소드 내부에 정의된 클래스
		class YourListIterator implements Iterator<String> {
			private int index = 0;
			public boolean hasNext() {
				if (index < names.length) {
					return true;
				}
				return false;
			}
			public String next() {
				String name = names[index];
				index++;
				return name;
			}
		}
		YourListIterator itr = new YourListIterator();
		return itr;
	}
	
	//////////////////////문법/////////////////////////
	////stack 저장소에 저장되기 때문에, class B에서는 method m()의 필드값중 변경되는 필드값은 사용 할 수 없다.
	public void m() {
		int y = 10;
		final int z = 20;
		
		// 로컬 내부 클래스
		class B {
			public void inner() {
				System.out.println(x);
				System.out.println(y);
				System.out.println(z);
			}	
		}
		// y=20; --> 변경되는 method m() 필드값의 예
	}
}
