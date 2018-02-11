package com.sapient.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sapient.dao.ExamDaoImpl;
import com.sapient.dao.IDao;
import com.sapient.entity.Question;

@RunWith(JUnitPlatform.class)
public class DaoTest {
	private static IDao dao;
	private static Logger logger = LoggerFactory.getLogger("sapient");
	@BeforeAll
	public static void setup(){
//		logger.info("inside setup");
		dao=  ExamDaoImpl.getDao();
//		logger.info("intialized");
	}
	@Test
	public void test1(){
		assertEquals(15, dao.getQuestions().size());
		
	}
	@Test
	public void test2(){
		Question actual = dao.getQuestions().get(2);
		Question expected = new Question();
		expected.setQid(2);
		expected.setQdesc("what is the size of byte type");
		expected.setOptiona("1");
		expected.setOptionb("2");
		expected.setOptionc("4");
		expected.setAnswer("1");
		assertEquals(expected.toString(), actual.toString());
		
	}

}
