package com.sapient.client;

import java.util.Scanner;

import com.sapient.service.IProductService;
import com.sapient.service.ProductSerImpl;

public class ClientA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IProductService ser = ProductSerImpl.getService();
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		while(choice !=6) {
			System.out.println("--------------------------------");
			System.out.println("1. Add New Product");
			System.out.println("2. Remove Product By Product Id");
			System.out.println("3. View All Products");
			System.out.println("4. View Product By Product Id");
			System.out.println("5. View Product By Category Id");
			System.out.println("6. Exit");
			System.out.println("---------------------------------");
			System.out.print("Enter Choice: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:if(ser.addNewProduct())
					System.out.println("Product SuccessFully Added");
				   else
						System.out.println("Product Not Added Please Try Again");
					break;
			case 2: if(ser.removeProduct())
						System.out.println("Product Successfully Removed");	
					else
						System.out.println("Cannot Remove Product ");
					break;
			case 3: ser.viewAllProducts();
					break;
			case 4: System.out.print("Enter Product Id: ");
					int pid = sc.nextInt();
					ser.viewProductsByPid(pid);
					break;
			case 5: System.out.print("Enter Category Id: ");
					int catId = sc.nextInt();
					ser.viewProductByCatId(catId);
					break;
			case 6: choice = 6;
					break;
			
			default:
				System.out.println("Wrong Choice! Try Again");
			}
		}
		System.out.println("Thank You! Bye..");

	}

}
