package example.spring.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import example.spring.cloud.dto.ExampleProductDto;
import example.spring.cloud.service.ExampleProductService;

@RestController
@RequestMapping(value = "/example")
public class ExampleProductCtrl {
	
	@Autowired
	ExampleProductService prodService;
	
    @Autowired
    WebClient.Builder webClientBuilder;

	@GetMapping(value = "/product")
	public List<ExampleProductDto> getProducts() {
		return prodService.getProducts();
	}

	@GetMapping(value = "/product/{prodId}")
	public ExampleProductDto getProduct(@PathVariable(name = "prodId") int id) {
		return prodService.getProduct(id);
	}
	
	// http://localhost:5151/example/productWC/1
    // uri method does not accept service name like dc-product-user
    @RequestMapping("/productWC/{pId}")
    public ExampleProductDto getProductWC(@PathVariable("pId") String prodId) {
    	ExampleProductDto prod = webClientBuilder.build()
    			.get()
    			.uri("http://localhost:5151/example/product/"+ prodId)
    			.retrieve()
    			.bodyToMono(ExampleProductDto.class)
    			.block();
    	return prod;
    }

}
