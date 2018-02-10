package com.sapient.test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assumptions.*;
import com.sapient.dao.IProductDao;
import com.sapient.exceptions.ProductNotFoundException;
import com.sapient.service.IProductService;
import com.sapient.service.ProductSerImpl;
import com.sapient.vo.Product;

import name.falgout.jeffrey.testing.junit5.MockitoExtension;
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class ProductTest {
	private static Product prod1 ;
	private static Product prod2 ;
	private static String[] specs1;
	private static String[] specs2;
	@Mock
	private IProductDao pdao;
	
	@InjectMocks
	private IProductService ser  = new ProductSerImpl();
	
	@BeforeAll
	public static void setup() {
		specs1 = new String[] {"diet","1lts","flavoured"};
		 specs2 = new String[] {"1GB Ram","Snapdragon 420 Processor"};
	}
	@BeforeEach
	public void init() throws ProductNotFoundException {
		prod1 = new Product();
		prod2 = new Product();
		prod1.setPid(1001);
		prod1.setpName("coke");
		prod1.setPrice(160);
		prod1.setSpecs(specs1);
		prod2.setPid(1002);
		prod2.setpName("YuYunique");
		prod2.setPrice(5000);
		prod2.setSpecs(specs2);
		Mockito.when(pdao.getProduct(1001)).thenReturn(prod1);
		Mockito.when(pdao.getProduct(1002)).thenReturn(prod2);
		Mockito.when(pdao.getProduct(1003)).thenThrow(ProductNotFoundException.class);
		
	}
	
	@Test
	public void test1() throws ProductNotFoundException {
		assumeTrue(ser!=null);
		String[] expecteds = specs1;
		String[] actuals = ser.getProductDetails(1001).getSpecs();
		System.out.println(actuals);
		assertArrayEquals(expecteds, actuals);
		InOrder order = Mockito.inOrder(pdao);
		order.verify(pdao).getProduct(1001);
		order.verify(pdao).getProductSpecs("coke");
	}
}
