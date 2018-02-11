package com.sapient.dao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface DbDetails {
	Logger logger = LoggerFactory.getLogger("sapient");
	String DRIVER ="oracle.jdbc.driver.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String UNAME = "QUIZ";
	String PWD = "sapient@123";
	String QRY = "select * from questions";

}
