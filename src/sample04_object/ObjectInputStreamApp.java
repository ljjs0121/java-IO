package sample04_object;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamApp {
// 복원하기
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		/*
		 * ObjectInputStream
		 * 	스트림을 통해서 읽어온 데이터로 객체를 복원한다.
		 * 	주요 API
		 * 		생성자
		 * 			ObjectInputStream(InputStream in)
		 * 				이 스트림과 연결되는 1차 스트림객체를 전달받아서 객체를 초기화한다.
		 * 		주요 메소드
		 * 			Object readObject() throws IOException, ClassNotFoundException
		 * 				* 직렬화된 객체의 데이터를 스트림으로 통해서 읽어와서
		 * 			  	  원래 객체로 복원시키고, 그 객체의 주소값을 Object타입으로 형변환해서 반환한다.
		 * 				* 직렬화할 때 사용했던 클래스와 일치하는 클래스가 존재하지 않으면 
		 * 			 	  ClassNotFoundException을 발생시킨다.
		 */
		
		String path = "src/sample04_object/obj.sav";
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
		
//		Object obj = in.readObject();
//		System.out.println("복원된 객체 -> " + obj);
		Score score = (Score) in.readObject();
		System.out.println("이름: " + score.getName());
		System.out.println("학년: " + score.getGrade());
		System.out.println("국어: " + score.getKor());
		System.out.println("영어: " + score.getEng());
		System.out.println("수학: " + score.getMath());
		System.out.println("합격여부: " + score.isPassed());
		
		in.close();
		
	}
}
