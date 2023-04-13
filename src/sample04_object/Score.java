package sample04_object;

import java.io.Serializable;

public class Score implements Serializable {

	private static final long serialVersionUID = -4403701983491175747L; // 객체를 식별할 수 있는 값
	private String name;
	private int grade;
	private int kor;
	private int eng;
	private int math;
	private boolean passed;
	
	public Score() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public boolean isPassed() {
		return passed;
	}

	public void setPassed(boolean passed) {
		this.passed = passed;
	}
	
}
