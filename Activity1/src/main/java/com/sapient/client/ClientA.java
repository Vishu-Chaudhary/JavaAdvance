package com.sapient.client;

import java.util.ArrayList;
import java.util.List;

import com.sapient.exceptions.EmptyListException;
import com.sapient.service.ISer;
import com.sapient.service.ServiceImpl;

public class ClientA {

	public static void main(String[] args) throws EmptyListException {
		// TODO Auto-generated method stub
		List<String> lst = new ArrayList<String>();
		lst.add("abc");
		lst.add("hgr");
		lst.add("dbc");
		lst.add("alc");
		lst.add("abc");
		ISer ser = ServiceImpl.getInstance();
		System.out.println(ser.findDuplicate(lst));
	}
}


