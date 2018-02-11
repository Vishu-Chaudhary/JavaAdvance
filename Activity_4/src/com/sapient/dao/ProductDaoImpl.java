package com.sapient.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import static com.sapient.dao.DbDetails.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sapient.exceptions.ProductNotFoundException;
import com.sapient.vo.Product;

public class ProductDaoImpl implements IProductDao {
	private static Logger logger = DbDetails.logger;
	private static IProductDao dao = new ProductDaoImpl();
	private int defaultID = -0;
	private String defaultType = null;
	private ProductDaoImpl(){
		
	}
	public static IProductDao getDao(){
		return dao;
	}
	static{
		try {
			Class.forName(DRIVER);
			logger.info("diver loaded");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			logger.error(e.getMessage());
		}
		
	}

	@Override
	public Map<Integer, Product> getProductsById(int id, String type) {
		String sql=null;
		if(type==null) 
			sql=SELQRY;
		else if(type.equals("cat"))
			sql=SELBYCIDQRY;
		else if(type.equals("prod"))
			sql=SELBYPIDQRY;
		logger.info("Generating Products byID");
		Map<Integer, Product> map = null;
		Product prod;
		try(Connection conn = DriverManager.getConnection(URL, UNAME, PWD)){
			map = new HashMap<>();
			PreparedStatement st = conn.prepareStatement(sql);
			if(id!=-0)
				st.setInt(1, id);
			logger.info("statement created");
		    ResultSet rs = st.executeQuery();
			logger.info("Query Executed");
			while(rs.next()) {
				prod = new Product();
				prod.setPid(rs.getInt("pid"));
				prod.setpName(rs.getString("pname"));
				prod.setPrice(rs.getInt("price"));
				prod.setBrand(rs.getString("brand"));
				prod.setCatId(rs.getInt("catId"));
				map.put(prod.getPid(),prod);
				logger.info("Got Product\n{}",prod.toString());
				
			}
		}
		catch (SQLException e) {
			// TODO: handle exception
			logger.error(e.getMessage());
		}
		
		return map;
	}
	@Override
	public Map<Integer, Product> getProducts() {	
		return getProductsById(defaultID,defaultType);
	}

	@Override
	public int addProduct(int pid, String pname, double price, String brand, int catId) {
		logger.info("Adding Product");
		int res = 0;
		try(Connection conn = DriverManager.getConnection(URL, UNAME, PWD)){
			PreparedStatement st = conn.prepareStatement(INSERTQRY);
			st.setInt(1, pid);
			st.setString(2, pname);
			st.setDouble(3, price);
			st.setString(4, brand);
			st.setInt(5, catId);
			logger.info(st.toString());
			logger.info("statement created");
		    res = st.executeUpdate();
			logger.info("Product Added with pid {}",pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
		
		return res;
	}
	@Override
	public int delProdeuct(int pid) throws ProductNotFoundException {
		int res = 0;
		try(Connection conn = DriverManager.getConnection(URL, UNAME, PWD)){
			PreparedStatement st = conn.prepareStatement(DELQRY);
			st.setInt(1, pid);
			logger.info("statement created");
		    res = st.executeUpdate();
		    if(res == 0) {
		    	throw new ProductNotFoundException("No Such Product Found");
		    }
			logger.info("Product with id {} deleted",pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
		
		return res;
	}


	

}
