package com.softserve.edu03.stub;

import com.softserve.edu03.dao.IProductDao;
import com.softserve.edu03.service.ProductService;

public class Appl {

	public static void main(String[] args) {
		IProductDao userDao = new OutDotProductDaoStub();
		ProductService productService = new ProductService(userDao);
		System.out.println("result = " + productService.getLastDigits());
	}
}
