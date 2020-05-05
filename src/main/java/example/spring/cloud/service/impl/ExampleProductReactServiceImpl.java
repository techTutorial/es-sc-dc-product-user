package example.spring.cloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import example.spring.cloud.dto.ExampleProductDto;
import example.spring.cloud.service.ExampleProductReactService;

@Service
public class ExampleProductReactServiceImpl implements ExampleProductReactService {
	
    @Autowired
    WebClient.Builder webClientBuilder;

    // uri method does not accept service name like dc-product-user
	@Override
	public ExampleProductDto getProductWC(int prodId) {
    	ExampleProductDto prod = webClientBuilder.build()
    			.get()
    			.uri("http://localhost:5151/example/product/"+ prodId)
    			.retrieve()
    			.bodyToMono(ExampleProductDto.class)
    			.block();
    	return prod;
	}
	
}
