package com.sapient.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ServiceImpl implements ISer {
	private static final ServiceImpl ser  = new ServiceImpl();
	
	private ServiceImpl(){
		
	}
	
	public static ISer getInstance(){
		return ser;
	}

	public double convertCelFar(double celisius) {
		
		return (celisius*1.8)+32;
	}

	public boolean findArmStrong(int num) {
		int sum = 0;
		int res = num;
		while(res>0){ 
			sum+=Math.pow(res%10,3);
			res/=10;
		}
		if(sum==num)
			return true;
		return false;
	}

	public boolean findLeapYear(int year) {
        boolean leap = false;

        if(year % 4 == 0)
        {
            if( year % 100 == 0)
            {
                // year is divisible by 400, hence the year is a leap year
                if ( year % 400 == 0)
                    leap = true;
                else
                    leap = false;
            }
            else
                leap = true;
        }
        else
            leap = false;
        
		return leap;
	}

	public List<String> findDuplicate(List<String> lst) {
	    final Set<String> duplicates = new HashSet<String>();
	    final int listSize = lst.size();
	    if (listSize > 0) {
	      final Set<String> tempSet = new HashSet<String>(listSize);
	      for (final String element : lst) {
	        if (!tempSet.add(element)) {
	          duplicates.add(element);
	        }
	      }
	    }
	    return new ArrayList<String>(duplicates);
	}

}
