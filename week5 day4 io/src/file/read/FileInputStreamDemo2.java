package file.read;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo2 {
	public static void main(String[] args) throws FileNotFoundException,IOException {
		long start = System.currentTimeMillis();
		
		FileInputStream fis = new FileInputStream("sample.txt");
		int count = 0;
		byte[] buf = new byte[1024];
		
		while ((count=fis.read(buf)) != -1) {
			System.out.println(count);
		}
		fis.close();
		
		long stop = System.currentTimeMillis();
		
		System.out.println("소요시간 : " + (stop - start) + "mills");
		
		
	}
}