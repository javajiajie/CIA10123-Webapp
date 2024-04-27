package JSONBase64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class TestBase64 {
	
	public static void main(String[] args) throws IOException {
		File file = new File("FC_Bayern.png");
		FileInputStream fis = new FileInputStream(file);
		//JAVA9 寫法
		byte[] pic = fis.readAllBytes();
		//JAVA8以前寫法
//		byte[] pic = new byte[fis.available()];
//		fis.read(pic);
		fis.close();
		
		// Base64 encodes 3 bytes to 4 characters.
		
		// encode  把裝著位元資料轉化為Base64格式的文字
		String base64str = Base64.getEncoder().encodeToString(pic);
		System.out.println(base64str);
		
		// decode  把Base64文字轉換成為byte陣列，再把轉換成陣列的文字輸出
		byte[] fromBase64str = Base64.getDecoder().decode(base64str);
		FileOutputStream fos = new FileOutputStream("fromBase64str.png");
		fos.write(fromBase64str);
		fos.flush();
		fos.close();
		
	}
}
