package com.jpaPagination.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpaPagination.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
