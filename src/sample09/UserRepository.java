package sample09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
	
	// users.txt파일에 기록된 사용자 정보가 저장되는 객체다.
	private List<User> users = new ArrayList<>();
	
	public UserRepository() {
		try {
			String path = "src/sample09/users.txt";
			BufferedReader in = new BufferedReader(new FileReader(path)); // 한줄씩 읽어오는 BufferedReader
			String text = null;
			while ((text = in.readLine()) != null) {
				if (text.isBlank()) { // text 파일에 공백이 있으면 빠져나감
					break;
				}
				User user = User.createUser(text);
				users.add(user);
			}
			in.close();
		} catch (IOException ex) {
			throw new RuntimeException("user.txt 파일 읽기 오류", ex);
		}
	}
	
	/* 영속화계층은 예외는 필요없다.
	 * 아이디를 전달받아서 아이디에 해당하는 사용자정보를 반환한다.
	 * 	반환타입 : User
	 * 	메소드명 : getUserById
	 * 	매개변수 : String id
	 */
	public User getUserById(String id) {
		for (User user : users) {
			if (user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}
	
	// 종료 후 저장
	public void save() {
		try {
			String path = "src/sample09/users.txt";
			PrintWriter out = new PrintWriter(path);
			
			for (User user : users) {
				/*
				 * user.generateText()는 User객체의 사용자정보를
				 * "hong,zxcv1234,홍길동,1000"과 같은 문자열로 변환해서 반환한다.
				 */
				String text = user.generateText();
				out.println(text);
			}
			out.close();
			
		} catch (IOException ex) {
			throw new RuntimeException("user.txt 파일 읽기 쓰기 오류", ex);
		}
	}
	
}
















