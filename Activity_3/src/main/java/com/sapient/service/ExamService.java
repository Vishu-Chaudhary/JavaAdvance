package com.sapient.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sapient.dao.DbDetails;
import com.sapient.dao.ExamDaoImpl;
import com.sapient.dao.IDao;
import com.sapient.entity.Question;

public class ExamService implements IExamSer {
	private static Logger logger = DbDetails.logger;
	private IDao dao = ExamDaoImpl.getDao();
	private static Map<Integer, Question> qmap = null;
	private static final IExamSer ser = new ExamService();
	private  ExamService() {
		// TODO Auto-generated constructor stub
	}
	public static IExamSer getService(){
		return ser;
	}
	
	public int evaluate(Map<Integer, String> amap) {
		int marks = 0;
		if(qmap == null)
			qmap = dao.getQuestions();
		logger.debug(qmap.toString());
		for(Integer qid: amap.keySet()){
			if(qmap.get(qid).getAnswer().equalsIgnoreCase(amap.get(qid))){
				marks+=1;
			}
		}
		logger.debug("marks");
		
		return marks;
	}
	
	public Set<Integer> getQuestionNos(){
		Set<Integer> set = new HashSet<Integer>();
		int max = 15, min = 1;
		Random r = new Random();
		
		while(set.size()<5){
			Integer rand = r.nextInt((max - min) + 1) + min;
			set.add(rand);
			logger.debug(set.toString());
		}
		return set;
	}
	public List<Question> generateQuestions() {
			logger.info("inside Generate Question");
			List<Question> lq = new ArrayList<Question>();
			Set<Integer> qnos = getQuestionNos();
			if(qmap == null)
				qmap = dao.getQuestions();
			for(Integer i : qnos){
				lq.add(qmap.get(i));
			}
			logger.debug(lq.toString());
			return lq;
		}
	
}
