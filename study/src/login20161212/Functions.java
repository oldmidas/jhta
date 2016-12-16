package login20161212;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Functions {
	ArrayList<User> userList = new ArrayList<>();
	User loginStatus = null;
	
	public void login(String id, String pw) {
		if (loginStatus != null) {
			System.out.println("로그인 중입니다.");
			return;
		}
		for (User user : userList) {
			if (id.equals(user.getId()) && pw.equals(user.getPw())) {
				loginStatus = user;
				System.out.println(user.getName() + "님 반갑습니다.");
				return;
			}
		}
	}
	
	public void logout() {
		if (loginStatus == null) {
			System.out.println("로그인 안했는데여?");
			return;
		}
		
		if (loginStatus != null) {
			System.out.println(loginStatus.getName() + "님 바바염.");
			loginStatus = null;
			return;
		}
	}
	
	public void infoSave() throws Exception {
		if (loginStatus == null) {
			System.out.println("로그인하세여");
			return;
		}
		
		if (loginStatus != null) {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("name.sav"));
			oos.writeObject(loginStatus);
			System.out.println("객체 저장완료.");
			oos.close();
			return;
		}
	}
	
	public void register(String name, String id, String pw) {
		User user = new User(name, id, pw, 0);

		userList.add(user);
		System.out.println("회원가입 성공!");
		return;
	}
}
