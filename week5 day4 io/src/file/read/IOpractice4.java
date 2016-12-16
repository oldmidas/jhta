package file.read;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class IOpractice4 {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.glasgowvant.com/");
		InputStream is = url.openStream();
		FileOutputStream fos = new FileOutputStream("practice2.txt");
		int count = 0;
		byte[] bytes = new byte[1024];
		
		while ((count = is.read(bytes))!= -1) {
			fos.write(bytes);
		}
		is.close();
		fos.close();
		
		URL url2 = new URL("http://www.glasgowvant.com/wp-content/uploads/passenger-gig-glasgow.jpeg");
		InputStream is2 = url2.openStream();
		FileOutputStream fos2 = new FileOutputStream("practice.jpg");
		int count2 = 0;
		byte[] bytes2 = new byte[1024];
		
		long start = System.currentTimeMillis();
		
		while ((count2 = is2.read(bytes2))!= -1) {
			fos2.write(bytes2);
		}
		
		fos2.close();
		is2.close();
		
		long stop = System.currentTimeMillis();
		System.out.println(stop-start + "millis");
	}
}
