package example.spring.cloud.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import example.spring.cloud.dto.ExampleProductDto;
import example.spring.cloud.dto.ExampleProductDto.Availability;
import example.spring.cloud.service.ExampleProductService;

@Service
public class ExampleProductServiceImpl implements ExampleProductService {
	
	static List<ExampleProductDto> examProdList;
	
	static {
		examProdList = new ArrayList<>();
		examProdList.add(new ExampleProductDto(2, "Product-2", 200, Availability.SOLD_OUT));
		examProdList.add(new ExampleProductDto(21, "Product-2", 201, Availability.IN_STOCK));
		examProdList.add(new ExampleProductDto(5, "Product-5", 500, ExampleProductDto.Availability.IN_STOCK));
		examProdList.add(new ExampleProductDto(55, "Product-5", 505, ExampleProductDto.Availability.IN_STOCK));
		examProdList.add(new ExampleProductDto(3, "Product-3", 300, Availability.IN_STOCK));
		examProdList.add(new ExampleProductDto(1, "Product-1", 100, ExampleProductDto.Availability.IN_STOCK));
		examProdList.add(new ExampleProductDto(4, "Product-4", 400, ExampleProductDto.Availability.SOLD_OUT));
	}
	
	@Override
	public List<ExampleProductDto> getProducts() {
		return examProdList;
	}

	@Override
	public ExampleProductDto getProduct(int prodId) {
		return null;
	}

}
