package com.sapient.service;

import com.sapient.exceptions.ProductNotFoundException;
import com.sapient.vo.Product;

public interface IProductService {
	Product getProductDetails(int pid) throws ProductNotFoundException;
	
}
