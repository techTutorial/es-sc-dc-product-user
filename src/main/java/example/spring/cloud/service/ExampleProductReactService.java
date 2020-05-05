package example.spring.cloud.service;

import example.spring.cloud.dto.ExampleProductDto;

public interface ExampleProductReactService {
	
	public ExampleProductDto getProductWC(int prodId);

}
