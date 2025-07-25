package set;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("Apple");
		set.add("Banana");
		set.add("Cherry");
		set.add("Apple");
		set.add("Orange");
		
		System.out.println(set.size());
		
		for(String element : set)
			System.out.println(element);
		
		boolean contains = set.contains("Cherry");
		System.out.println("Does set contain Cherry? " + contains);
		
		set.clear();
		
		boolean empty = set.isEmpty();
		System.out.println("Is set empty? " + empty);
	}
}
