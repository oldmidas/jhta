package file.character;

import java.io.FileReader;

public class FileReaderDemo1 {
	public static void main(String[] args) throws Exception {
		FileReader reader = new FileReader("song.txt");
		
		int count = 0;
		char[] buf = new char[1024]; // 글자 1024개를 담을 수 있는 버퍼 생성.

		while((count = reader.read(buf))!= -1) {
			String str = new String(buf, 0, count);
			System.out.println(str);
		}
		reader.close();
	}
}
