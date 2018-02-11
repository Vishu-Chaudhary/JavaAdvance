package com.sapient.streamDemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo4 {

	public static void main(String[] args) {
		List<Integer> lst1 = Arrays.asList(10,24,27,55,26,33,35);
		List<Integer> lst2 = Arrays.asList(260,336,335);
		Stream<List<Integer>> s = Stream.of(lst1,lst2);
		Stream<Integer> s2 = s.flatMap(lst -> lst.stream()).sorted();
		s2.forEach(System.out::println);

	}

}
