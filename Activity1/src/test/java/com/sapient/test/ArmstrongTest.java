package com.sapient.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import static org.junit.jupiter.api.Assertions.*;

import com.sapient.exceptions.NumberZeroException;
import com.sapient.service.ISer;
import com.sapient.service.ServiceImpl;
@RunWith(JUnitPlatform.class)
public class ArmstrongTest {
	private static ISer ser;
	@BeforeEach
	public void init(){
		ser = ServiceImpl.getInstance();
	}
	
	@Test
	public void test1() {
		assertThrows(NumberZeroException.class, ()->{ser.findArmStrong(0);});
	}
	@Test
	public void test2() throws NumberZeroException{
		assertTrue(ser.findArmStrong(153));
	}
	@Test
	public void test3() throws NumberZeroException {
		assertFalse(ser.findArmStrong(100));
	}
	
}
