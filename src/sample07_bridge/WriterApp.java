package sample07_bridge;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class WriterApp {

	public static void main(String[] args) throws IOException {
		
		/*
		 * OutputStreamWriter
		 * 	캐릭터 전용 스트림이다.
		 * 	브릿지 스트림이다.
		 *  바이트스트림과 연결가능한 캐릭터 스트림이다.
		 *  
		 *  주요 API
		 *  	생성자
		 *  		OutputStreamWriter(OutputStream out)
		 *  		OutputStreamWriter(OutputStream out, String charsetName)
		 *  		* 이 스트림과 연결되는 바이트스트림객체를 전달받아서 스트림객체를 초기화한다.
		 * 			* 문자전용스트림이지만, 바이트스트림객체를 전달받아서 그 스트림과 연결된다.
		 */
		
		String path = "src/sample07_bridge/sample.txt";
		
		FileOutputStream fos = new FileOutputStream(path);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		PrintWriter writer = new PrintWriter(osw);
		
		writer.println("브릿지 스트림 연습");
		
		writer.close();
	}
}
