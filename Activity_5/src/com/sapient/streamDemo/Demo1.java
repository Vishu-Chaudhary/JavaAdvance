package com.sapient.streamDemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> lst = Arrays.asList(10,24,27,55,26,33,35);
		Stream<Integer> s = lst.stream().filter((i)-> i%5==0);
		s.forEach((i)->System.out.println(i));

	}

}
