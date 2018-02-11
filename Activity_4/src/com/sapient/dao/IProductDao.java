package com.sapient.dao;

import java.util.Map;

import com.sapient.exceptions.ProductNotFoundException;
import com.sapient.vo.Product;

public interface IProductDao {
	Map<Integer, Product> getProducts();
	Map<Integer, Product> getProductsById(int id,String type);
//	Map<Integer, Product> getProductsByCatId();
	int addProduct(int pid, String pname, double price, String brand, int catId);
	int delProdeuct(int pid) throws ProductNotFoundException;
}
