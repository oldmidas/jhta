package kr.jhta.set;

import java.util.TreeSet;

public class TreeSetDemo2 {
	public static void main(String[] args) {
		TreeSet<Student> students = new TreeSet<>();
		students.add(new Student("홍길동", 100));
		students.add(new Student("김유신", 70));
		students.add(new Student("강감찬", 60));
		students.add(new Student("이순신", 40));
		students.add(new Student("유관순", 90));
		// students.add(new Student("윤봉길", 90));	저장되지 않는다. 이진트리법칙의 위배됨.
		
		System.out.println(students);
		
		// 1등찾기
		Student first = students.last();
		System.out.println(first);
		
		// 꼴등찾기
		Student last = students.first();
		System.out.println(last);
	}
	
	
	public static class Student implements Comparable<Student> {
		private String name;
		private int score;
		
		public Student() {}
		
		public Student(String name, int score) {
			this.name = name;
			this.score= score;
		}

		public String getName() {
			return name;
		}

		public int getScore() {
			return score;
		}

		@Override
		public String toString() {
			return "Student [name=" + name + ", score=" + score + "]";
		}

		@Override
		public int compareTo(Student other) {
			int result = score - other.score;
			return result;
		}
	}
}
