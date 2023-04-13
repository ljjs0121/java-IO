package sample06_character;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringJoiner;

import sample04_object.Score;

public class WriterApp {

	public static void main(String[] args) throws IOException {
		
		// 텍스트 데이터를 출력하는 PrintWriter객체를 생성한다.
		String path = "src/sample06_character/score.txt";
		PrintWriter out = new PrintWriter(path);
		
		// 학생성적정보를 표현하는 Score객체를 생성하고, 성적정보를 저장한다.
		Score score = new Score();
		score.setName("홍수아");
		score.setPassword("zxcv1234");
		score.setGrade(3);
		score.setKor(100);
		score.setEng(90);
		score.setMath(90);
		score.setPassed(true);
		
		// Score객체에 저장된 성적정보를 , 로 구분된 문자열로 생성할 StringJoiner객체를 생성한다.
		StringJoiner joiner = new StringJoiner(","); // 구분문자 지정 공백 x
		// StringJoiner객체의 add(String value) 메소드를 실행해서 값을 추가한다.
		joiner
			.add(score.getName())
			.add(score.getPassword())
			.add(String.valueOf(score.getGrade()))
			.add(String.valueOf(score.getKor()))
			.add(String.valueOf(score.getEng()))
			.add(String.valueOf(score.getMath()))
			.add(String.valueOf(score.isPassed()));
		// StringJoiner객체의 toString() 메소드는 StringJoiner객체에 추가된 값을
		// 지정된 구분문자(,)로 이어진 하나의 문자열로 반환한다.
		String text = joiner.toString();
		
		out.println(text);
		out.println(text);
		out.println(text);
		out.println(text);
		out.close();
		
	}
}
