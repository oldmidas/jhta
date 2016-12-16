package file.read;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class IOpractice3 {
	public static void main(String[] args) throws Exception{
		FileOutputStream fos = new FileOutputStream("practice2.txt");
		
		String text = "hello IO" + System.lineSeparator();
		byte[] bytes = text.getBytes();
		
		fos.write(bytes);
		
		ArrayList<String> strings = new ArrayList<>();
		strings.add("only");
		strings.add("know");
		strings.add("you");
		strings.add("love");
		strings.add("her");
		strings.add("when");
		strings.add("you");
		strings.add("let");
		strings.add("her");
		strings.add("go");
		
		for (String s : strings) {
			s = s + System.lineSeparator();
			bytes = s.getBytes();
			fos.write(bytes);
		}		
		fos.close();
	}
}
