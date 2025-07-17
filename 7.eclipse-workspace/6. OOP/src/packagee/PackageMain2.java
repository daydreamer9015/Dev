package packagee;

import packagee.a.*;		// packagee.a의 모든 클래스 사용

public class PackageMain2 {
	public static void main(String[] args) {
		Data data = new Data();
		User user = new User();		// 위쪽에 import 사용해서 패키지명 생략 가능
	}
}
