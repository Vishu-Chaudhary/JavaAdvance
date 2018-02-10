package com.sapient.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.sapient.exceptions.InvalidYearException;
import com.sapient.service.ISer;
import com.sapient.service.ServiceImpl;
@RunWith(JUnitPlatform.class)
public class LeapYearTest {
	private static ISer ser;
	@BeforeEach
	public void init(){
		ser = ServiceImpl.getInstance();
	}
	@Test
	public void test1() {
		assertThrows(InvalidYearException.class, ()->{ser.findLeapYear(99);});
	}
	@Test
	public void test2() {
		assertThrows(InvalidYearException.class, ()->{ser.findLeapYear(12000);});
	}
}
