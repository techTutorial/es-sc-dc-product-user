package example.spring.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.spring.cloud.dto.ExampleProductDto;
import example.spring.cloud.service.ExampleProductService;

@RestController
@RequestMapping(value = "/example")
public class ExampleProductCtrl {
	
	@Autowired
	ExampleProductService prodService;

	@GetMapping(value = "/product")
	public List<ExampleProductDto> getProducts() {
		return prodService.getProducts();
	}

	@GetMapping(value = "/product/{prodId}")
	public ExampleProductDto getProduct(@PathVariable(name = "prodId") int id) {
		return prodService.getProduct(id);
	}

}
