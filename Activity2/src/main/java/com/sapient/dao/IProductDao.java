package com.sapient.dao;

import com.sapient.exceptions.ProductNotFoundException;
import com.sapient.vo.Product;

public interface IProductDao {
	Product getProduct(int pid) throws ProductNotFoundException;
	String[] getProductSpecs(String pname);
}
