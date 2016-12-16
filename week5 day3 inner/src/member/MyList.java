package member;

import java.util.Iterator;

public class MyList {
	private String[] names = {"홍길동", "김유신", "이순신", "강감찬"};
	
	public Iterator<String> iterator() {
		return new MyListIterator();		
	}
	
	//멤버 내부 클래스
	private class MyListIterator implements Iterator<String> {

		private int index = 0;
		public boolean hasNext() {
			if(index < names.length) {
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
}
