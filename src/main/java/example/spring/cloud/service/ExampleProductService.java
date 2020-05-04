package example.spring.cloud.service;

import java.util.List;

import example.spring.cloud.dto.ExampleProductDto;

public interface ExampleProductService {
	
	public List<ExampleProductDto> getProducts();
	
	public ExampleProductDto getProduct(int prodId);

}
