package sample09;

import java.text.MessageFormat;

public class User {

	private String id;
	private String password;
	private String name;
	private int point;
	
	public User() {}
	public User(String id, String password, String name, int point) {
		this.id =id;
		this.password = password;
		this.name = name;
		this.point = point;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	public static User createUser(String text) {
		// text -> "hong,zxcv1234,홍길동,10000"
		// values -> {"hong", "zxcv1234", "홍길동", "10000"}
		String[] values = text.split(",");
		String id = values[0];
		String password = values[1];
		String name = values[2];
		int point = Integer.parseInt(values[3]);
		
		return new User(id, password, name, point);
	}
	
	public String generateText() {
	      return MessageFormat.format("{0},{1},{2},{3}", 
	            id, 
	            password, 
	            name, 
	            String.valueOf(point));
	   }
}

