package com.sapient.streamDemo;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;


public class Demo5 {

	public static void main(String[] args) {
		List<Integer> lst = Arrays.asList(10,24,27,55,26,33,35);
		IntStream s = lst.stream().mapToInt(i->i);
		System.out.println(s.sum());
		//Average
		IntStream s1 = lst.stream().mapToInt(i->i);
		OptionalDouble optavg = s1.average();
		System.out.println(optavg.getAsDouble());
		//Max
		IntStream s2 = lst.stream().mapToInt(i->i);
		OptionalInt optmax = s2.max();
		System.out.println(optmax.getAsInt());
		//Max
		IntStream s3 = lst.stream().mapToInt(i->i);
		OptionalInt optmin = s3.min();
		System.out.println(optmin.getAsInt());
	}

}
