package file.second;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class BufferedReaderDemo2 {
	public static void main(String[] args) throws Exception {
		String path = "http://192.168.10.101:8080/data.jsp";
		URL url = new URL(path);
		/*
		InputStream is = url.openStream();
		BufferedReader bf = new BufferedReader(new InputStreamReader(is));
		
		*/
		BufferedReader br
			= new BufferedReader(new InputStreamReader(url.openStream()));

		String text = null;
		while ((text=br.readLine()) != null) {
			System.out.println(text);
		}
	}
}
