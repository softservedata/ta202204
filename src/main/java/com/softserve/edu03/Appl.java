package com.softserve.edu03;

import com.softserve.edu03.dao.ProductDao;
import com.softserve.edu03.service.ProductService;

public class Appl {

	public static void main(String[] args) {
		ProductService productService = new ProductService(new ProductDao());
		System.out.println("result = " + productService.getLastDigits());
	}
}
