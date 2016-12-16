package file.read;

import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ContactApp {
	public static void main(String[] args) throws Exception {
		// 1. contacts.txt의 내용을 읽어서 화면에 표시하기.
		// 2. contacts.txt의 내용을 한 사람씩 구분해서 화면에 표시하기.
		// 3. ArrayList<Contact>를 생성해서 모든 사람의 정보를 저장하기.
		FileInputStream fis = new FileInputStream("contacts.txt");
		byte[] buf = new byte[1024];
		int count = 0;
		
		StringBuilder sb = new StringBuilder();
		
		while ((count = fis.read(buf)) != -1) {
			String text = new String(buf, 0, count);
			sb.append(text);
		}
		fis.close();
		
		
		String data = sb.toString();
		String[] array = data.split(":");
		
		ArrayList<Contact> contacts = new ArrayList<>();
		/*
		for (int i=0; i<array.length;i++) {
			String[] array2 = array[i].split(",");
			Contact contact = new Contact(array2[0], array2[1], array2[2]);
			contacts.add(contact);
		}
		*/
		for (String datas : array) {
			String[] array2 = datas.split(",");
			Contact contact = new Contact(array2[0], array2[1], array2[2]);
			contacts.add(contact);
		}
		
		for (Contact c : contacts) {
			System.out.println(c.getName());
			System.out.println(c.getTel());
			System.out.println(c.getEmail());
		}
	}
}
