package com.spring_rest.cookpick.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_rest.cookpick.DTO.ProductDTO;
import com.spring_rest.cookpick.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public List<ProductDTO> getProducts(){
		return productRepository.getProducts();
	}

	public ProductDTO getProductByCode(long productCode){
		return productRepository.getProductByCode(productCode);
	}
	
	public ProductDTO getProductByNameAndVendor(String productName, String productVendor){
		return productRepository.getProductByNameAndVendor(productName,productVendor);
	}
}
