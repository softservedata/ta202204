package com.softserve.edu03.service;

import com.softserve.edu03.dao.IProductDao;
import com.softserve.edu03.dao.ProductDao;

public class ProductService {

	private IProductDao productDao;

	public ProductService(IProductDao productDao) {
		System.out.println("Constructor ProductService(IProductDao productDao)");
		this.productDao = productDao; 
	}

	public ProductService() {
		System.out.println("Constructor ProductService()");
		productDao = new ProductDao();
	}

	public IProductDao getProductDao() {
		return productDao;
	}

	public String getLastDigits() {
		String origin = getProductDao().getIPAddress();
		return origin.substring(origin.lastIndexOf(".") + 1);
	}

	public String getLastDigits(String text) {
		String origin = getProductDao().getIPAddress(text);
		return origin.substring(origin.lastIndexOf(".") + 1);
	}

}
