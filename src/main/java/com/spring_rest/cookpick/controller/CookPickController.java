package com.spring_rest.cookpick.controller;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring_rest.cookpick.DTO.ProductDTO;
import com.spring_rest.cookpick.service.ProductService;

@RestController
@RequestMapping("/greet")
public class CookPickController {
	
	@Autowired
	private ProductService productService;
	
//	@GetMapping
//	public String greet() {
//		Calendar cal = Calendar.getInstance();
//	      SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MMMM/yyyy hh:mm:s");
//	      
//	      Format f = new SimpleDateFormat("EEEE");
//	      String str = f.format(new Date());
//		return "Welcome to "+ str +" sale";
//	}
	
	@GetMapping(value="products", produces = "application/json")
	public ResponseEntity<List<ProductDTO>> getProducts(){
		return ResponseEntity.ok(productService.getProducts());
	}
	
	@GetMapping(value = "products/{prodCode}",produces = "application/json")
	public ResponseEntity<ProductDTO> getProductByCode(@PathVariable long prodCode){
		return ResponseEntity.ok(productService.getProductByCode(prodCode));
	}
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<ProductDTO> getProducts(@RequestParam("productName") String productName,
			@RequestParam("productVendor") String productVendor){
		
		ProductDTO product = productService.getProductByNameAndVendor(productName,productVendor);
		
		System.out.println(product);
		return ResponseEntity.ok(product);
	}
	
	

}
