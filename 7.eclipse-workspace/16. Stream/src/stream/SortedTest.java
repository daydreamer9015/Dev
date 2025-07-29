package stream;

import java.util.Arrays;
import java.util.List;

public class SortedTest {
	public static void main(String[] args) {
		//문자열 리스트 생성
		List<String> fruits = Arrays.asList("Pineapple", "Apple", "Mango", "Cherry", "Banana");
		fruits.stream()
			.sorted()
				.forEach(s -> System.out.print(s + " "));
		
		System.out.println();
		
		// 문자열 길이 기준으로 sort
		fruits.stream()
			.sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
				.forEach(s -> System.out.print(s + " "));
	}
}
