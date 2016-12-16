package file.second;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferedInputStreamDemo {
	public static void main(String[] args) throws Exception {
		String resource = "C:\\Users\\JHTA\\Downloads\\D2Coding-1.2.zip";
		long begin1 = System.currentTimeMillis();
		FileInputStream fis1 = new FileInputStream(resource);
		while (fis1.read() != -1) {}
		fis1.close();
		long end1 = System.currentTimeMillis();
		
		System.out.println("소요시간 : " + (end1 - begin1) +"ms.");
		
		long begin2 = System.currentTimeMillis();
		FileInputStream fis2 = new FileInputStream(resource);
		BufferedInputStream bis = new BufferedInputStream(fis2);
		// 실제로는 이런식으로 더 많이 사용한다.
		// BufferedInputStream bis = new BufferedInputStream(new FileInputStream(resource));
		while (bis.read() != -1) {}

		bis.close(); // fis2를 닫지않아도 저절로 닫힌다.
		long end2 = System.currentTimeMillis();
		
		System.out.println("bufferedFIS 소요시간 : " + (end2 - begin2) +"ms.");
	}
}
