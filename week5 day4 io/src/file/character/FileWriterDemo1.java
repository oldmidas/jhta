package file.character;

import java.io.FileWriter;

public class FileWriterDemo1 {
	public static void main(String[] args) throws Exception {
		FileWriter write = new FileWriter("song.txt");
		
		write.write("학교종이 땡땡땡 어서 모이자 선생님이 우리를 기다리신다.");
		write.flush();	// FileWriter의 내부버퍼에 보관된 잔류 데이터를 진짜로 출력하게 만든다.
		write.close();
	}
}
