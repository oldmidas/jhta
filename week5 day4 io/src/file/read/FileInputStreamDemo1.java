package file.read;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo1 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("sample.txt");
		int v1 = fis.read();
		int v2 = fis.read();
		int v3 = fis.read();
		
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		
		System.out.println((char)v1);
		System.out.println((char)v2);
		System.out.println(Integer.toBinaryString(v3));
		
		fis.close();
		
		long start = System.currentTimeMillis();
		FileInputStream fis2 = new FileInputStream("sample.txt");
		int value = 0;
		while((value = fis2.read()) != -1) {
			System.out.print((char)value);	
		}
		fis2.close();
		
		long stop = System.currentTimeMillis();
		System.out.println("소요시간: "+(stop-start)+"밀리초");
	}
}
