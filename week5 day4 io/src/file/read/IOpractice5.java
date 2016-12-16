package file.read;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class IOpractice5 {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.soccerline.co.kr/img/soccerline_logo.gif");
		InputStream is = url.openStream();
		FileOutputStream fos = new FileOutputStream("practice.gif");
		byte[] bytes = new byte[1024];
		
		int check = 0;
		while ((check = is.read(bytes)) != -1) {
			fos.write(bytes);
		}
		is.close();
		fos.close();
	}
}
