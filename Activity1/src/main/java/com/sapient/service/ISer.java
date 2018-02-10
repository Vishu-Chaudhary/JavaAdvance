package com.sapient.service;

import java.util.List;

import com.sapient.exceptions.EmptyListException;
import com.sapient.exceptions.InvalidYearException;
import com.sapient.exceptions.NumberZeroException;

public interface ISer {
	double convertCelFar(double celisius);
	boolean findArmStrong(int num) throws NumberZeroException;
	boolean findLeapYear(int year) throws InvalidYearException;
	List<String> findDuplicate(List<String> lst) throws EmptyListException;

}
