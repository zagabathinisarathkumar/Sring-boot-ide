package com.zensar.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.entity.Product;
import com.zensar.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	private List<Product> products = new ArrayList<Product>();

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product insertProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {

		return productRepository.findAll();
	}

	@Override
	public Product getProduct(int productId) {
		for (Product product : products) {
			if (product.getProductId() == productId) {
				return product;
			}
		}
		return null;
	}

	@Override
	public void delteProduct(int productId) {
		for (int i = 0; i < products.size(); i++) {
			Product product = products.get(i);
			if (product.getProductId() == productId) {
				products.remove(product);
			}
		}

	}

}
