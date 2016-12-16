package comparator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FruitApp2 {
	public static void main(String[] args) throws Exception {
		ArrayList<Fruit> fruits = new ArrayList<>();
		fruits.add(new Fruit("귤", "주황", 1000, 5));
		fruits.add(new Fruit("토마토", "빨강", 1500, 15));
		fruits.add(new Fruit("바나나", "노랑", 2000, 50));
		fruits.add(new Fruit("키위", "골드", 1400, 30));
		fruits.add(new Fruit("블루베리", "보라", 3000, 20));
		ArrayList<Fruit> fruits2 = new ArrayList<>();
		
		
		FileOutputStream fos = new FileOutputStream("fruits.txt");
		FileOutputStream fos2 = new FileOutputStream("fruits2.txt");
		 
		
		byte[] bytes = new byte[1024];
		for (Fruit f : fruits) {
			String data = f.getName() +","+f.getColor()+","+f.getPrice()+","+f.getKcal()+":";
			bytes = data.getBytes();
			fos.write(bytes);
		}
		FileInputStream fis = new FileInputStream("fruits.txt");
		
		StringBuilder sb = new StringBuilder();
		int count = 0;
		while ((count = fis.read(bytes)) != -1) {
			String data = new String(bytes, 0, count);
			sb.append(data);
		}
		
		String str = sb.toString();
		String[] arr1 = str.split(":");
		for (String str2 : arr1) {
			String[] arr2 = str2.split(",");
			fruits2.add(new Fruit(arr2[0], arr2[1], Integer.parseInt(arr2[2]), Integer.parseInt(arr2[3])));
		}
		
		Comparator<Fruit> c = new Comparator<Fruit>() {
			public int compare(Fruit f1, Fruit f2) {
				return -(f1.getPrice() - f2.getPrice());
			}
		};
		Collections.sort(fruits2, c);
		
		Collections.sort(fruits2, new Comparator<Fruit>() {
			public int compare(Fruit f1, Fruit f2) {
				return f1.getKcal() - f2.getKcal();
			}
		});
		
		Collections.sort(fruits2, new Comparator<Fruit>() {
			public int compare(Fruit f1, Fruit f2) {
				return f1.getName().compareTo(f2.getName());
			}
		});
		
		Collections.sort(fruits2, (f1, f2) -> f1.getColor().compareTo(f2.getColor()));
		
		Comparator<Fruit> c2 = new Comparator<Fruit>() {
			public int compare(Fruit f1, Fruit f2) {
				return f1.getKcal() - f2.getKcal();
			}
		};
		
		Collections.sort(fruits2, new Comparator<Fruit>() {
			public int compare(Fruit f1, Fruit f2) {
				return f1.getPrice() - f2.getPrice();
			}
		});
		
		for (Fruit f : fruits2) {
			String data = f.getName() + "," + f.getColor() + "," + f.getPrice() + "," + f.getKcal() + ":" + System.lineSeparator();
			bytes = data.getBytes();
			fos2.write(bytes);
		}
		fos.close();
		fos2.close();
		fis.close();
	}
}
