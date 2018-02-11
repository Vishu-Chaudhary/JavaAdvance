package com.sapient.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.Logger;

import com.sapient.dao.DbDetails;
import com.sapient.dao.IProductDao;
import com.sapient.dao.ProductDaoImpl;
import com.sapient.exceptions.ProductNotFoundException;
import com.sapient.vo.Product;



public class ProductSerImpl implements IProductService{
    Logger logger = DbDetails.logger;
	private IProductDao dao= ProductDaoImpl.getDao();
	private static IProductService ser = new ProductSerImpl();
	private Scanner sc;
	private ProductSerImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public static IProductService getService() {
		return ser;
	}
	
	@Override
	public boolean addNewProduct() {
		sc = new Scanner(System.in);
		System.out.print("Enter Product Id: ");
		int pid= sc.nextInt();
		
		System.out.print("Enter Product Name: ");
		String pname = sc.next();
	
		
		System.out.print("Enter Price: ");
		double price = sc.nextDouble();
		
		System.out.print("Enter Product Brand: ");
		String brand = sc.next();
		
		
		System.out.print("Enter Category Id: ");
		int catId = sc.nextInt();
		
		int res = dao.addProduct(pid, pname, price, brand, catId);
		if(res>0)
			return true;
		return false;
	}
	@Override
	public boolean removeProduct()  {
		sc = new Scanner(System.in);
		System.out.print("Enter Product Id To Delete: ");
		int pid = sc.nextInt();
		try {
			int res = dao.delProdeuct(pid);
			if(res>0) {
				return true;
			}
			
		} catch (ProductNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Product with pid "+pid+" Not Found");
			logger.error("No Product With PID {} exists",pid);;
		}
		
		return false;
	}
	@Override
	public void viewAllProducts()  {
		Map<Integer, Product> res = dao.getProducts();
		List<Product> lstpdt = new ArrayList<>(res.values());
		Collections.sort(lstpdt);
		for(Product pid: lstpdt) {
			System.out.println(pid.toString());
		}
	}
	@Override
	public void viewProductsByPid(int pid) {
		Map<Integer, Product> res = dao.getProductsById(pid,"prod");
		List<Product> lstpdt = new ArrayList<>(res.values());
		Collections.sort(lstpdt);
		for(Product pdt: lstpdt) {
			System.out.println(pdt.toString());
		}
	}
	@Override
	public void viewProductByCatId(int catId){
		Map<Integer, Product> res = dao.getProductsById(catId,"cat");
		List<Product> lstpdt = new ArrayList<>(res.values());
		lstpdt.sort((Product p1, Product p2 )->{Integer price = p1.getPrice();
												Integer price2 = p2.getPrice();
												return price.compareTo(price2);});
		
		
		
		for(Product pid: lstpdt) {
			System.out.println(pid.toString());
		}
	}
	
	

}
