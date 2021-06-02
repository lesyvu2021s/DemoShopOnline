package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Containers;
import com.example.demo.model.Products;
import com.example.demo.repository.ContainersRepository;
import com.example.demo.repository.ProductsRepository;

@Service
public class ProductsService {

	@Autowired
	private ProductsRepository productRepo ; 
	
	@Autowired
	private ContainersRepository containerRepo ; 
	
	
	public List<Products> getAllProducts(){
		return productRepo.findAll();
	}
	
	public Products addProduct(Products products) {
		
		Containers conn = containerRepo.findById(products.getContainer().getId()).orElse(null);
		if(null == conn) {
			conn = new Containers();	
		}
		
		conn.setName(products.getContainer().getName());
		conn.setCapacity(products.getContainer().getCapacity());
		products.setContainer(conn);
		return productRepo.saveAndFlush(products);
		
	}
	
	public Products edit(Products product) {
		return productRepo.save(product);
	}
	
	public void deleteProduct(Integer id) {
		productRepo.deleteById(id);
		
		
	}
	
	public Optional<Products> GetByIdProducts(Integer id) {
		return productRepo.findById(id);
	}
	
	
	public Products store(MultipartFile file , Integer id) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		Products product =
	}
	
}
