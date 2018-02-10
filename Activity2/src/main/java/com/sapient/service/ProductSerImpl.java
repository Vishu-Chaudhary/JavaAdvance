package com.sapient.service;

import com.sapient.dao.IProductDao;
import com.sapient.exceptions.ProductNotFoundException;
import com.sapient.vo.Product;

public class ProductSerImpl implements IProductService{
	private IProductDao dao;
	Product prod1 = new Product();
	public void setDao(IProductDao dao) {
		this.dao = dao;
	}
	public Product getProductDetails(int pid) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		Product prod = dao.getProduct(pid);
		System.out.println(prod.getpName());
		String[] specs = dao.getProductSpecs(prod.getpName());
		prod1.setSpecs(specs);
		return prod;
	}
	
	

}
