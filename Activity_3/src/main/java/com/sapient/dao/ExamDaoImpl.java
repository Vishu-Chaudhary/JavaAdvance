package com.sapient.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import static com.sapient.dao.DbDetails.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sapient.entity.Question;

public class ExamDaoImpl implements IDao {
	private static Logger logger = LoggerFactory.getLogger("sapient");
	private static IDao dao = new ExamDaoImpl();
	private ExamDaoImpl(){
		
	}
	public static IDao getDao(){
		return dao;
	}
	static{
		try {
			Class.forName(DRIVER);
			logger.info("diver loaded");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			logger.error(e.getMessage());
		}
		
	}
	public Map<Integer, Question> getQuestions(){
		Map<Integer, Question> map = null;
		Question ques = null;
		try{
			Connection conn = DriverManager.getConnection(URL, UNAME, PWD);
			map = new HashMap<Integer, Question>();
			
			PreparedStatement st = conn.prepareStatement(QRY);
			logger.info("statement created");
			ResultSet rs = st.executeQuery();
			logger.info("Query Executed");
		    while(rs.next()){
		    	ques = new Question();
		    	ques.setQdesc(rs.getString("qdesc"));
		    	ques.setOptiona(rs.getString("optiona"));
		    	ques.setOptionb(rs.getString("optionb"));
		    	ques.setOptionc(rs.getString("optionc"));
		    	ques.setQid(rs.getInt("qid"));
		    	ques.setAnswer(rs.getString("answer"));
		    	map.put(ques.getQid(),ques);
		    	logger.info(ques.toString());
		    	
		    }
		
		}catch (SQLException e) {
			// TODO: handle exception
			logger.error(e.getMessage());
		}
		
		return map;
	}

}
