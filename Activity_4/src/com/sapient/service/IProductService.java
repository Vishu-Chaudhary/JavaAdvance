package com.sapient.service;

import com.sapient.vo.Product;

public interface IProductService {
	boolean addNewProduct();
	boolean removeProduct();
	void viewAllProducts();
	void viewProductsByPid(int pid);
	void viewProductByCatId(int catId);
	
	
	
}
