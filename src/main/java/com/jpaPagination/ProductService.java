package com.jpaPagination;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.jpaPagination.Entity.Product;
import com.jpaPagination.Repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
//	@PostConstruct
//	public void InitDB() {
//		List<Product> products=IntStream.rangeClosed(1, 200)
//				.mapToObj(i->new Product("product"+i, new Random().nextInt(100), new Random().nextLong(50000)))
//				.collect(Collectors.toList());
//		productRepository.saveAll(products);
//	}
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public List<Product> findProductsWithSorting(String field){
		return productRepository.findAll(Sort.by(Direction.ASC,field));
	}
	
	public Page<Product> findProductsWithPagination(Integer offset, Integer pageSize){
		 return productRepository.findAll(PageRequest.of(offset, pageSize));
	}
	
	public Page<Product> findProductsWithPaginationAndSorting(Integer offset, Integer pageSize,String field){
		 return productRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.Direction.ASC,field));
	}
}
