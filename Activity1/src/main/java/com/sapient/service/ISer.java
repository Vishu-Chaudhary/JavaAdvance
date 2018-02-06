package com.sapient.service;

import java.util.List;

public interface ISer {
	double convertCelFar(double celisius);
	boolean findArmStrong(int num);
	boolean findLeapYear(int year);
	List<String> findDuplicate(List<String> lst);

}
