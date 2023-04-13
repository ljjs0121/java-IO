package sample01_inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class InputStreamApp1 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		FileInputStream in = new FileInputStream("src/sample01_inputstream/sample.jpg");
		
		// int read() 메소드를 사용해서 1byte씩 읽어오기
//		int value = 0;
//		while ((value = in.read()) != -1) {
//			System.out.println(value);
//		}
//		in.close();
		
		// int read(byte[] buf) 메소드를 사용해서 배열의 크기만큼 한번에 읽어오기
		byte[] buf = new byte[1024];
		int length = 0;
		while ((length = in.read(buf)) != -1) {
			System.out.println(length);
			System.out.println(Arrays.toString(buf));
		}
		in.close();
	}
}





