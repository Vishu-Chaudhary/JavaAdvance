package com.sapient.vo;

public class Product implements Comparable<Product> {
	private int pid;
	private String pName;
	private int price;
	private String brand;
	private int catId;
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

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
	public Integer getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pName=" + pName + ", price=" + price + ", brand=" + brand + ", catId=" + catId
				+ "]";
	}

	@Override
	public int compareTo(Product o) {
		Integer pid1 = this.pid;
		Integer pid2 = o.pid;
		return pid1.compareTo(pid2);
	}

	
	

}
