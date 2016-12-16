package file.read;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ioPractice {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("practice.txt");
		int v1 = fis.read();
		int v2 = fis.read();
		int v3 = fis.read();
		int v4 = fis.read();
		int v5 = fis.read();
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4);
		System.out.println(v5);
		System.out.println(Integer.toBinaryString(v1));
		System.out.println(Integer.toBinaryString(v2));
		System.out.println(Integer.toBinaryString(v3));
		System.out.println(Integer.toBinaryString(v4));
		System.out.println(Integer.toBinaryString(v5));
		System.out.println((char)v1);
		System.out.println((char)v2);
		System.out.println((char)v3);
		System.out.println((char)v4);
		System.out.println((char)v5);
		
		long start = System.currentTimeMillis();
		
		int letter = 0;
		while ((letter=fis.read()) != -1){
			System.out.println((char)letter);
		}
		
		long stop = System.currentTimeMillis();
		
		System.out.println((start-stop) + "밀리초 소요");
		
		fis.close();
		
	}
	
	
}
