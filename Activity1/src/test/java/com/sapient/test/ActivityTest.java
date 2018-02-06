package com.sapient.test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;

import com.sapient.service.ISer;
import com.sapient.service.ServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import name.falgout.jeffrey.testing.junit5.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class ActivityTest {
	@InjectMocks
	private static ISer ser;
	
//	@BeforeAll
//	public static void setup(){
//		List<String> actual = Arrays.asList("abc", "dfe", "abc", "xyz", "dfe");
//		List<String> expected = 
//	}
	
	@BeforeEach
	public void init(){
		ser = ServiceImpl.getInstance();
	}
	@Test
	public void test1(){
		
	}

}
