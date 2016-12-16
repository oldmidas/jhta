package file.second;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class BufferedReaderDemo1 {
	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("data.txt");
		BufferedReader br = new BufferedReader(fr);
		// BufferedReader br = new BufferedReader(new FileReader("data.txt"));
		ArrayList<String> arr1 = new ArrayList<>();
		
		
		String text = null;
		while ((text=br.readLine()) != null) {
			String[] arr = text.split(",");
			
			String name = arr[0];
			int kor = Integer.parseInt(arr[1]);
			int eng = Integer.parseInt(arr[2]);
			int math = Integer.parseInt(arr[3]);
			int total = kor + eng + math;
			double avg = total/3;
			
			System.out.printf("%s %d %d %d %d %2.2f\n", name, kor, eng, math, total, avg);
		}
		
		for (String s : arr1) {
			if (s != null) {
				System.out.println(s);
			}
		}
		br.close();
	}
}
