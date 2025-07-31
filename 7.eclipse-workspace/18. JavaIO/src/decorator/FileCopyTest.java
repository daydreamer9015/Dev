package decorator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest {
	public static void main(String[] args) {
		long millisecond = 0;
		try(FileInputStream fis = new FileInputStream("Oh_my_cool.jpg");
				FileOutputStream fos = new FileOutputStream("Oh_my_cool3.jpg")) {
			
			millisecond = System.currentTimeMillis();
			
			int i;
			while((i = fis.read()) != -1) {
				fos.write(i);
			}
			
			millisecond = System.currentTimeMillis() - millisecond;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("파일을 복사하는데 " + millisecond + " milliseconds 소요"); 
	}
}
	