package file.data;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class DataInputStreamDemo {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("score2.txt");
		DataInputStream dis = new DataInputStream(fis);
		
		String value1 = dis.readUTF();
		int value2 = dis.readInt();
		int value3 = dis.readInt();
		int value4 = dis.readInt();
		
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
		System.out.println(value4);
	
		dis.close();
	}
}
