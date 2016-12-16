package file.object;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamDemo2 {
	public static void main(String[] args) throws Exception {
		User user = new User();
		user.setName("황보길동");
		user.setId("hong1234");
		user.setPassword("zzz");
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.sav"));
		oos.writeObject(user);
		
		oos.close();
	}
}