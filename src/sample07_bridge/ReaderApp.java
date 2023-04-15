package sample07_bridge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReaderApp {

	public static void main(String[] args) throws IOException {
		
		/*
		 * InputStreamReader
		 * 	브릿지 스트림이다.
		 *  문자 전용 스트림이다.	
		 *  바이트 스트림과 연결가능한 캐릭터 스트림 객체다.
		 * 	바이트스트림을 읽어온 데이터를 다른 캐릭터스트림객체와 연결시킨다.
		 * 	주요 API
		 * 		InputStreamReader(InputStream in)
		 * 		inputStreamReader(InputStream in, String charsetName)
		 * 			* 이 스트림과 연결되는 바이트스트림객체를 전달받아서 스트림객체를 초기화한다.
		 * 			* 문자전용스트림이지만, 바이트스트림객체를 전달받아서 그 스트림과 연결된다.
		 */
		
		// 키보드 입력을 한 줄씩 읽어오기
		
		// 1. 키보드와 연결된 스트림객체를 획득하기
		InputStream inputStream = System.in;	// 1byte씩 읽어오는 스트림이다.
		
		// 2. 키보드와 연결된 스트림을 Reader와 연결하기
		InputStreamReader isr = new InputStreamReader(inputStream); // 1글자씩 읽어오는 스트림이다.
		
		// 3. BufferedReader 스트림과 연결하기
		BufferedReader br = new BufferedReader(isr);	// 1라인씩 읽어오는 스트림이다.
		
		// 4. 키보드 입력을 읽어오기
		System.out.print("내용을 입력하세요: ");
		String text = br.readLine();
		
		// 5. 키보드 입력내용을 출력해보기
		System.out.println("입력내용 : " + text);
		
		
	}
}







