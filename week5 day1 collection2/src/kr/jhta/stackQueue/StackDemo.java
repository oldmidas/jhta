package kr.jhta.stackQueue;

import java.util.Stack;

public class StackDemo {
	public static void main(String[] args) {
		Stack<String> names = new Stack<>();
		names.push("이순신");
		names.push("김유신");
		names.push("강감찬");
		
		// 제일 마지막에 넣은게 제일 먼저 나온다.
		// 제일 처음에 넣은게 제일 마지막에 나온다.
		while (!names.isEmpty()) {
			String name = names.pop();
			System.out.println(name);
			
		}
		
	}
}
