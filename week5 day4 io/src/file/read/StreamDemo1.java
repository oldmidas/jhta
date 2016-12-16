package file.read;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class StreamDemo1 {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://edition.cnn.com/");
		
		InputStream is = url.openStream();
		int count = 0;
		byte[] buf = new byte[1024];
		while ((count=is.read(buf)) != -1) {
			String str = new String(buf, 0, count);
			System.out.print(str);				
		}
		
		URL url2 = new URL("http://i2.cdn.cnn.com/cnnnext/dam/assets/161103175733-abu-dhabi-aerial-view-corniche-resized-exlarge-169.jpg");
		InputStream is2 = url2.openStream();
		FileOutputStream fos = new FileOutputStream("a.jpg");
		
		int count2 = 0;
		byte[] buf2 = new byte[1024*8];
		while ((count2=is2.read(buf2)) != -1) {
			fos.write(buf2, 0, count2);
		}
		fos.close();
	}
}
