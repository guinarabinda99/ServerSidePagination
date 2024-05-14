package com.jpaPagination.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpaPagination.ProductService;
import com.jpaPagination.Entity.Product;
import com.jpaPagination.dto.APIResponse;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public APIResponse<List<Product>> getProducts(){
		List<Product> allProducts = productService.getAllProducts();
		return new APIResponse<>(allProducts.size(),allProducts);
	}
	
	@GetMapping("/sort/{field}")
	public APIResponse<List<Product>> getProductsWithSort(@PathVariable String field){
		List<Product> allProducts = productService.findProductsWithSorting(field);
		return new APIResponse<>(allProducts.size(),allProducts);
	}
	
	@GetMapping("/pagination/{offset}/{pageSize}")
	public APIResponse<Page<Product>> getProductsWithPagination(@PathVariable Integer offset,@PathVariable Integer pageSize){
		Page<Product> allProducts = productService.findProductsWithPagination(offset, pageSize);
		return new APIResponse<>(allProducts.getSize(),allProducts);
	}
	
	@GetMapping("/pagination/{offset}/{pageSize}/{field}")
	public APIResponse<Page<Product>> getProductsWithPaginationAndSorting(@PathVariable Integer offset,
			@PathVariable Integer pageSize,@PathVariable String field){
		Page<Product> allProducts = productService.findProductsWithPaginationAndSorting(offset, pageSize,field);
		return new APIResponse<>(allProducts.getSize(),allProducts);
	}

}
