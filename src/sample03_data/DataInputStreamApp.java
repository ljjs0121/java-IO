package sample03_data;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamApp {
// 저장된 값을 불러와서 출력
	public static void main(String[] args) throws IOException {
		/*
		 * DataInputStream
		 * 	DataInputStream으로 출력한 데이터를 읽어서 원래 데이터 복원시킨다.
		 * 	주요 API
		 * 		생성자
		 * 			DataInputStream(InputStream)
		 * 				이 스트림과 연결되는 1차 스트림객체를 전달받아서 객체를 초기화시킨다.
		 * 		주요 메소드
		 * 			String readUTF()
		 * 			int readInt()
		 * 			long readLong()
		 * 			double readDouble()
		 * 			boolean readBoolean()
		 * 				* 위의 메소드는 DataOutputStream의 writeXXX(값) 메소드로 
		 * 				  출력한 데이터를 읽어서 해당 타입의 값으로 복원하는 메소드다.
		 * 				* readXXX() 메소드의 값을 읽어서 복원할 때는
		 * 				  반드시 기록한 순서와 같은 순서로 읽어야 한다. 
		 */
		
		String path = "src/sample03_data/sample.sav";
		DataInputStream in = new DataInputStream(new FileInputStream(path));
		
		// 복원
		String name = in.readUTF();
		int grade = in.readInt();
		int kor = in.readInt();
		int eng = in.readInt();
		int math = in.readInt();
		boolean passed = in.readBoolean();
		
		in.close();
		
		System.out.println("이름: " + name);
		System.out.println("학년: " + grade);
		System.out.println("국어: " + kor);
		System.out.println("영어: " + eng);
		System.out.println("수학: " + math);
		System.out.println("합격여부: " + passed);
	}
}





