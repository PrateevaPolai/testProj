package com.spring_rest.cookpick.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.spring_rest.cookpick.DTO.ProductDTO;

@Repository
public class ProductRepository {
	
	List<ProductDTO> products = null;
	
	@PostConstruct
	public void initializer() {
		
		ProductDTO productDTO = new ProductDTO();
		
		productDTO.setProductCode(1);
		productDTO.setProductName("Soap");
		productDTO.setProductVendor("Dettol");
		productDTO.setProductPrice(15);
		productDTO.setProductInStock(100);
		
		products = new ArrayList<ProductDTO>();
		products.add(productDTO);
		
	}

	public List<ProductDTO> getProducts(){
		return products;
	}
	
	public ProductDTO getProductByCode(long productCode) {
		for(ProductDTO obj : products) {
			if(obj.getProductCode()==productCode)
				return obj;
		}
		
		return null;
	}
	
	public ProductDTO getProductByNameAndVendor(String productName, String productVendor) {
		for(ProductDTO obj : products) {
			if(obj.getProductName().equals(productName) && obj.getProductVendor().equals(productVendor))
				return obj;
		}
		
		return null;
	}
}
