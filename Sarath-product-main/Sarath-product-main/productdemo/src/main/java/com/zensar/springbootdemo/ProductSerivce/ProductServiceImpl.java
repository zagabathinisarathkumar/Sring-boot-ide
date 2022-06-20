package com.zensar.springbootdemo.ProductSerivce;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort.Direction;
import com.zensar.springbootdemo.ProductDto.ProductDto;
import com.zensar.springbootdemo.ProductEntity.Product;
import com.zensar.springbootdemo.ProductRepository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ProductDto getProduct(int productId) {
		Product product = productRepository.findById(productId).get();
		return modelMapper.map(product, ProductDto.class);
	}

	@Override
	public List<ProductDto> getProducts(int pageNumber, int pageSize, String sortBy, Direction dir) {
		// List<Product> findAll = productRepository.findAll();
		// Page<Product> findAll =
		// productRepository.findAll(PageRequest.of(pageNumber,pageSize,Sort.by(Direction.DESC,"productName")));
		Page<Product> findAll = productRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(dir, sortBy)));
		List<Product> content = findAll.getContent();
		List<ProductDto> dto = new ArrayList<ProductDto>();
		for (Product product : content)
			dto.add(modelMapper.map(product, ProductDto.class));
		return dto;
	}

	@Override
	public ProductDto insert(ProductDto productDto) {
		productRepository.save(modelMapper.map(productDto, Product.class));
		return productDto;
	}

	@Override
	public void update(int productId, ProductDto productDto) {
		productRepository.save(modelMapper.map(productDto, Product.class));
	}

	@Override
	public void delete(int productId) {
		productRepository.deleteById(productId);
	}

	@Override
	public List<ProductDto> getByProductName(String productName) {
		// List<Product> findbyProductName =
		// productRepository.findByProductName(productName);
		List<Product> findbyProductName = productRepository.byName(productName);
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		for (Product product : findbyProductName)
			productDtos.add(modelMapper.map(product, ProductDto.class));
		return productDtos;
	}

	@Override
	public List<ProductDto> getByProductNameAndProductPrice(String productName, int productPrice) {
		List<Product> products = productRepository.findByProductNameAndProductPrice(productName, productPrice);
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		for (Product product : products)
			productDtos.add(modelMapper.map(product, ProductDto.class));
		return productDtos;
	}

	@Override
	public List<ProductDto> getByProductNameOrProductPrice(String productName, int productPrice) {
		// List<Product> products =
		// productRepository.findByProductNameOrProductPrice(productName, productPrice);
		List<Product> products = productRepository.byNameOrPrice(productName, productPrice);
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		for (Product product : products)
			productDtos.add(modelMapper.map(product, ProductDto.class));
		return productDtos;
	}

	@Override
	public List<ProductDto> getByProductNameOrderByProductQuantity(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

}
