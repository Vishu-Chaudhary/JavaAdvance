package com.sapient.dao;

import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface DbDetails {
	ResourceBundle rb = ResourceBundle.getBundle("sape");
	Logger logger = LoggerFactory.getLogger("sapient");
	String DRIVER =rb.getString("driver");
	String URL = rb.getString("url");
	String UNAME = rb.getString("uname");
	String PWD = rb.getString("pwd");
	String SELQRY = "select * from products";
	String SELBYPIDQRY = "select * from products where pid=?";
	String SELBYCIDQRY = "select * from products where catId=?";
	String INSERTQRY ="insert into products values(?,?,?,?,?)";
	String DELQRY = "delete from products where pid=?";

}
