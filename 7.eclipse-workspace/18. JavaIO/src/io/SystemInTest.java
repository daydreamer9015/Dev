package io;

import java.io.IOException;

public class SystemInTest {
	public static void main(String[] args) {
		System.out.println("알파벳 하나를 쓰고 [Enter] 누르세요.");
		
		int i;
		
		try {
			i = System.in.read();	// 1바이트씩 읽어들이는 기능 = read
			System.out.println(i);
			System.out.println((char)i);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
