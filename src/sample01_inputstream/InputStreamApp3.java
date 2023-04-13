package sample01_inputstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class InputStreamApp3 {

	public static void main(String[] args) throws IOException {
		
		String path = "https://ticketimage.interpark.com/Play/image/large/23/23003674_p.gif";
		String dest = "src/sample01_inputstream/suyoung.gif";
		
		URL url = new URL(path); // URL 리소스 위치 표기법
		InputStream in = url.openStream();
		FileOutputStream out = new FileOutputStream(dest);
		
		byte[] buf = new byte[1024];
		int length = 0;
		while ((length = in.read(buf)) != -1) {
			out.write(buf, 0, length);
		}
		out.close();
	}
}
