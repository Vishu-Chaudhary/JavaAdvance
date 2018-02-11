package com.sapient.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.Logger;

import com.sapient.dao.DbDetails;
import com.sapient.entity.Question;
import com.sapient.service.ExamService;
import com.sapient.service.IExamSer;

public class ClientA {
	private static Logger logger = DbDetails.logger;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String ans = null;
		
		IExamSer ser = ExamService.getService();
		System.err.println(ser);
		List<Question> list = ser.generateQuestions();
		Map<Integer, String> amap = new HashMap<Integer, String>();
		for(Question ques: list){
//			ques = new Question();
			System.out.println(ques.getQdesc());
			System.out.println(ques.getOptiona());
			System.out.println(ques.getOptionb());
			System.out.println(ques.getOptionc());
			System.out.println("Enter Answer:");
			ans = sc.next();
			amap.put(ques.getQid(), ans);
		}
		System.out.println("Your Score: "+ser.evaluate(amap));
		

	}

}
