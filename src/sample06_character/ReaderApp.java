package sample06_character;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import sample04_object.Score;

public class ReaderApp {

	public static void main(String[] args) throws IOException {
		
		String path = "src/sample06_character/score.txt";
		BufferedReader in = new BufferedReader(new FileReader(path));
		
		String text = null;
		while ((text = in.readLine()) != null) {
			Score score = createScore(text);
			System.out.println("["+score.getName()+"] 학생 성적 정보");
			System.out.println("이름: " + score.getName());
			System.out.println("학년: " + score.getGrade());
			System.out.println("국어: " + score.getKor());
			System.out.println("영어: " + score.getEng());
			System.out.println("수학: " + score.getMath());
			System.out.println("합격여부: " + score.isPassed());
			System.out.println();
		}
		
		in.close();
	}
	
	public static Score createScore(String text) {
		String[] values = text.split(",");
		
		String name = values[0];
		String password = values[1];
		int grade = Integer.parseInt(values[2]);
		int kor = Integer.parseInt(values[3]);
		int eng = Integer.parseInt(values[4]);
		int math = Integer.parseInt(values[5]);
		boolean passed = Boolean.parseBoolean(values[6]);
	
		Score score = new Score();
		score.setName(name);
		score.setPassword(password);
		score.setGrade(grade);
		score.setKor(kor);
		score.setEng(eng);
		score.setMath(math);
		score.setPassed(passed);
		
		return score;
	}
}
