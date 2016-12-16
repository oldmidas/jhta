package file.read;

import java.io.FileInputStream;
import java.io.IOException;

public class IOPractice2 {
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("practice.txt");
		int letter1 = fis.read();
		int letter2 = fis.read();
		
		System.out.println(letter1);
		System.out.println(letter2);
		System.out.println((char)letter1);
		System.out.println((char)letter2);
		String binary1 = Integer.toBinaryString(letter1);
		String binary2 = Integer.toBinaryString(letter2);
		System.out.println(binary1);
		System.out.println(binary2);
		System.out.println(binary1);
		System.out.println(binary2);
		int letter3 = Integer.parseInt(binary1, 2);
		int letter4 = Integer.parseInt(binary2, 2);
		System.out.println((char)letter3);
		System.out.println((char)letter4);
		
		long start = System.currentTimeMillis();
		
		// txt파일에서 한칸내리기 == 4칸내려감
		int letter = 0;
		while ((letter = fis.read()) != -1) {
			System.out.println((char)letter);
		}
		
		long stop = System.currentTimeMillis();
		
		System.out.println((stop - start)+"밀리세컨드 소요");
		
		
		fis.close();
	}
}
