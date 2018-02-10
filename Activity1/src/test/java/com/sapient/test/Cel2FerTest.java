package com.sapient.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import static org.junit.jupiter.api.Assertions.*;
import com.sapient.service.ISer;
import com.sapient.service.ServiceImpl;
@RunWith(JUnitPlatform.class)
public class Cel2FerTest {
	private static ISer ser;
	@BeforeEach
	public void init(){
		ser = ServiceImpl.getInstance();
	}
	
	@Test
	public void test1() {
		double expected = 89.6;
		double actual = ser.convertCelFar(32);
		assertEquals(expected, actual);
	}

}
