package reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest2 {
	public static void main(String[] args) {
				
		try {FileInputStream fis = new FileInputStream("reader.txt");		// 파일 입력 스트림 생성
			int data;
			// data값이 -1이 아닌 동안 read() 메서드로 1바이트를 반복하여 읽음
			while((data = fis.read()) != -1) {
				System.out.println((char)data);
			}

		} catch (IOException e) {
			System.out.println(e);
		} 
		System.out.println("end");
 	}
}
