package com.sapient.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.sapient.exceptions.EmptyListException;
import com.sapient.service.ISer;
import com.sapient.service.ServiceImpl;

@RunWith(JUnitPlatform.class)
public class DuplicateTest {
	private static ISer ser;
	@BeforeEach
	public void init(){
		ser = ServiceImpl.getInstance();
	}
	@Test
	public void test1() throws EmptyListException{
		List<String> expected =Arrays.asList("abc");
		List<String> lst = new ArrayList<String>();
		lst.add("abc");
		lst.add("hgr");
		lst.add("dbc");
		lst.add("alc");
		lst.add("abc");
		assertEquals(expected, ser.findDuplicate(lst));
		
	}
	@Test
	public void test2() throws EmptyListException{
		List<String> lst = new ArrayList<String>();
//		System.out.println(lst.size());
		assertThrows(EmptyListException.class, ()->{ser.findDuplicate(lst);});
	}

}
