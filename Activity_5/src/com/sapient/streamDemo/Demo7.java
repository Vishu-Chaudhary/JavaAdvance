package com.sapient.streamDemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo7 {

	public static void main(String[] args) {

		List<Integer> lst = Arrays.asList(10,24,27,55,26,33,35);
		Stream<Integer> s = lst.stream().filter((i)->i%5==0);
		long res = s.count();
		System.out.println(res);

	}

}
