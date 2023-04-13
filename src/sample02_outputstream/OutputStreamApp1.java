package sample02_outputstream;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamApp1 {

	public static void main(String[] args) throws IOException {
		FileOutputStream out 
			= new FileOutputStream("src/sample02_outputstream/sample.txt");
		
//		out.write(65);		// 'A'가 기록된다.
//		out.write(66);		// 'B'가 기록된다.
//		out.write(67);		// 'C'가 기록된다.
//		out.write('a');		
//		out.write('b');		
//		out.write('c');		
//		out.write('d');		
//		out.write('가');		// 글자가 제대로 기록되지 않는다.
//		out.write('나');		// 글자가 제대로 기록되지 않는다.
//		out.write('다');		// 글자가 제대로 기록되지 않는다.
		
		String text = "안녕하세요. 반갑습니다.";
		byte[] bytes = text.getBytes();
		out.write(bytes);
		
		out.close();
	}
}
