package sample05_buffered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedApp {

	public static void main(String[] args) throws IOException {
		
		/* Buffer -> 임시저장소
		 * BufferedInputStream, BufferedOutputStream
		 * 	다른 스트림의 읽기/쓰기 성능을 향상시키는 스트림이다.
		 * 	다른 스트림과 연결해서 사용하는 2차 스트림이다.
		 * 	주요 API
		 * 		생성자
		 * 			BufferedInputStream(InputStream in)
		 * 			BufferedOutputStream(OutputStream out)
		 */
		
		long startTime = System.currentTimeMillis();
		
		String src = "src/sample05_buffered/sample.zip";
		String dest = "src/sample05_buffered/sample_backup.zip";
		
		// 아래 실행 했을 때 -> 142,220 밀리초
//		FileInputStream in = new FileInputStream(src);
//		FileOutputStream out = new FileOutputStream(dest);

		// 성능 향상 -> 216 밀리초
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(src));
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dest));
		
		int value = 0;
		while ((value = in.read()) != -1) {
			out.write(value);
		
		}
		
		in.close();
		out.close();
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("소요시간 ->" + (endTime - startTime) + " 밀리초");
	}
}
