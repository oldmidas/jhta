package file.copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.io.IOUtils;

public class FileCopyDemo1 {
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		FileInputStream fis = new FileInputStream("a.jpg");
		FileOutputStream fos = new FileOutputStream("b.jpg");
		IOUtils.copy(fis, fos);
		long end = System.currentTimeMillis();
		
		System.out.println(end-start);
	}
}
