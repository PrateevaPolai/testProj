package com.spring_rest.cookpick.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
	long productCode; 

	String productName;

	String productVendor;

	double productPrice;

	int productInStock;
	
	@Override
	public String toString(){
		
		return "ProductDTO[ Product Code : "+ productCode 
				+ ", Product Name : " + productName 
				+ ", Product Vendor : " + productVendor
				+ ", Product Price : " + productPrice
				+ " ]";
		
	}

}
