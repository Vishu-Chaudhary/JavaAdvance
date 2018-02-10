package com.sapient.vo;

import java.util.Arrays;

public class Product {
	private int pid;
	private String pName;
	private double price;
	private String [] specs;
	
	public  Product() {
		super();
	}

	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String[] getSpecs() {
		return specs;
	}
	public void setSpecs(String[] specs) {
		this.specs = specs;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pName=" + pName + ", price=" + price + ", specs=" + Arrays.toString(specs)
				+ "]";
	}
	
	

}
